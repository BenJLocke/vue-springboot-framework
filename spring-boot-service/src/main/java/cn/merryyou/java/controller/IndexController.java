package cn.merryyou.java.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.merryyou.java.repository.UserRepository;
import cn.merryyou.java.service.IMenuItemService;

@RestController
public class IndexController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	IMenuItemService menuItemService;

    @GetMapping("/")
    void index(HttpServletRequest request, HttpServletResponse respons) {
    	try {
			respons.sendRedirect("/static/index.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @GetMapping("/error")
    String error() {
        return "Spring Boot - You get error!";
    }
}
