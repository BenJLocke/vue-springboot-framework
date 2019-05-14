package cn.merryyou.java.service;

import java.util.List;

import cn.merryyou.java.domain.MenuItem;
import cn.merryyou.java.entity.Item;

public interface IMenuItemService {
	public List<Item> getItems();
	public List<MenuItem> getMenuItems();
	public void save(MenuItem item);
	public void delete(Long id);
	public MenuItem get(Long id);
}
