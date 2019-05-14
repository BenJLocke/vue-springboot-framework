package cn.merryyou.java.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import cn.merryyou.java.repository.UserRepository;

@Component
public class MyUserDetailsService implements UserDetailsService {
 
  private Logger logger = LoggerFactory.getLogger(getClass());
  @Autowired
  UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    logger.info("用户的用户名: {}", username);
    // TODO 根据用户名，查找到对应的密码，与权限
 
    List<cn.merryyou.java.domain.User> list = userRepository.findAll();
    for (cn.merryyou.java.domain.User user : list) {
    	if (user.getName().equals(username)) {
    	    // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
    	    return new User(username, user.getPassword(),
    	              AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
    	}
    }

    return null;
 }
}
