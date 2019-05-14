package cn.merryyou.java.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import cn.merryyou.java.domain.MenuItem;
import cn.merryyou.java.entity.Item;
import cn.merryyou.java.exception.ServiceException;
import cn.merryyou.java.repository.MenuItemRepository;
import cn.merryyou.java.service.IMenuItemService;

@Component("menuItemService")
public class MenuItemServiceImpl implements IMenuItemService {

	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public List<Item> getItems() {
		List<MenuItem> list = menuItemRepository.findAll();
		List<Item> itemList = new LinkedList<>();
		Map<Long,Item> level0Map = new HashMap<>();
		Map<Long,Item> level1Map = new HashMap<>();
		Map<Long,Item> level2Map = new HashMap<>();

		Item item;
		for (MenuItem menuItem : list) {
			if (menuItem.getLevel() == 0) {
				item = createItem(menuItem);
				itemList.add(item);
				level0Map.put(menuItem.getId(), item);
			} else if (menuItem.getLevel() == 1) {
				level1Map.put(menuItem.getId(), createItem(menuItem));
			} else if (menuItem.getLevel() == 2) {
				level2Map.put(menuItem.getId(), createItem(menuItem));
			}
		}

		Long id;
		for (MenuItem menuItem : list) {
			id = menuItem.getId();
			if (menuItem.getLevel() == 1) {
				getSubs(level0Map, menuItem.getParentId()).add(level1Map.get(id));
			} else if (menuItem.getLevel() == 2) {
				getSubs(level1Map, menuItem.getParentId()).add(level2Map.get(id));
			}
		}
		
		return itemList;
	}

	private List<Item> getSubs(Map<Long, Item> level0Map, Long parent) {
		Item item = level0Map.get(parent);
		if (item.getSubs() == null) {
			item.setSubs(new LinkedList<>());
		}
		return item.getSubs();
	}

	private Item createItem(MenuItem menuItem) {
		Item item = new Item();
		item.setIcon(menuItem.getIcon());
		//item.setId(menuItem.getId());
		item.setIndex(menuItem.getIndex());
		item.setTitle(menuItem.getTitle());
		//item.setSubs(new LinkedList<>());

		return item;
	}

	@Override
	public List<MenuItem> getMenuItems() {
		return  menuItemRepository.findAll();
	}

	@Override
	public void save(MenuItem item) {
		if (item.getLevel() > 0) {
			if (menuItemRepository.getOne(item.getParentId()) == null) {
				throw new ServiceException("Can't find the parent item via parent id " + item.getParentId());
			}
		}
		menuItemRepository.save(item);
	}

	@Override
	public void delete(Long id) {
		MenuItem menuItem = menuItemRepository.getOne(id);
		if (menuItem != null) {
			List<MenuItem> list = menuItemRepository.findMenuItemByParentId(menuItem.getParentId());
			if (list.size() > 0) {
				throw new ServiceException("Find the parent item via parent id " + menuItem.getParentId());
			}
			this.menuItemRepository.delete(id);
		}
	}

	@Override
	public MenuItem get(Long id) {
		return this.menuItemRepository.getOne(id);
	}
	
}
