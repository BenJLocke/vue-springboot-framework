package cn.benlocke.webservice.service;

import java.util.List;

import cn.benlocke.webservice.domain.MenuItem;
import cn.benlocke.webservice.web.entity.Item;

public interface IMenuItemService {
	public List<Item> getItems();
	public Iterable<MenuItem> getMenuItems();
	public void save(MenuItem item);
	public void delete(Long id);
	public MenuItem get(Long id);
	public List<String> findTitleName();
}
