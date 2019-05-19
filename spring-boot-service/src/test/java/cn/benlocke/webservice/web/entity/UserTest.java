package cn.benlocke.webservice.web.entity;

import org.junit.Test;

import cn.benlocke.webservice.domain.User;

public class UserTest {

	@Test
	public void toStringTest() {
		User user = new User();
		user.setId(1L);
		user.setName("name");
		user.setPassword("password");
		user.setRoles("hello");
		user.setUrl("http://www.test.com");
		System.out.println(user.toString());
	}
}
