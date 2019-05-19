package cn.benlocke.webservice.config;

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

import cn.benlocke.webservice.repository.UserRepository;

@Component
public class MyUserDetailsService implements UserDetailsService {
 
  private Logger logger = LoggerFactory.getLogger(getClass());
  @Autowired
  UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    logger.info("用户的用户名: {}", username);
 
    List<cn.benlocke.webservice.domain.User> list = userRepository.findListByName(username);
    for (cn.benlocke.webservice.domain.User user : list) {
    	return new User(username, user.getPassword(),
    	    AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
    }

    return null;
 }
}
