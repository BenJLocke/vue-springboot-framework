package cn.merryyou.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.merryyou.java.domain.MenuItem;
import cn.merryyou.java.entity.JsonResponse;
import cn.merryyou.java.service.IMenuItemService;

@RestController
public class MenuItemController {

	@Autowired
	private IMenuItemService menuItemService;

    @GetMapping("/service/menu")
    public Object menu() {
    	return JSON.toJSON(menuItemService.getItems());
    }

    @GetMapping("/service/getMenuItemList")
    public Object menuItemList() {
    	return JSON.toJSON(menuItemService.getMenuItems());
    }
    
    @GetMapping("/service/getMenuItem")
    public Object getMenuItem(@RequestParam("id") Long id) {
    	return JSON.toJSON(menuItemService.get(id));
    }
    
    @PostMapping("/service/deleteMenuItem")
    public Object deleteMenuItem(@RequestParam("id") Long id) {
    	String msg = "ok";
    	boolean status = true;
    	try {
    		menuItemService.delete(id);
    	}catch (Exception e) {
    		status = false;
    		msg = e.getMessage();
    	}
    	return JSON.toJSON(new JsonResponse(msg, status));
    }
    
    @PostMapping("/service/saveMenuItem")
    public Object saveMenuItem(@RequestBody MenuItem menuItem) {
    	String msg = "ok";
    	boolean status = true;
    	try {
    		menuItemService.save(menuItem);
    	}catch (Exception e) {
    		status = false;
    		msg = e.getMessage();
    	}
    	return JSON.toJSON(new JsonResponse(msg, status, menuItem));
    }
}
