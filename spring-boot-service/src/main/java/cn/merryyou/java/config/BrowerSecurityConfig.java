package cn.merryyou.java.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
	@Autowired
	private AuthenticationFailureHandler myAuthenctiationFailureHandler;
	@Autowired
	private MacLoginUrlAuthenticationEntryPoint macLoginUrlAuthenticationEntryPoint;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
				.loginPage("/static/index.html")
				.loginProcessingUrl("/login")
				.successHandler(myAuthenticationSuccessHandler)
				.failureHandler(myAuthenctiationFailureHandler)
				.and()
			.authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
				.antMatchers("/static/**").permitAll() // 设置所有人都可以访问登录页面
				.anyRequest().authenticated() // 任何请求,登录后可以访问
				.and()
			.headers()
				.frameOptions()
				.sameOrigin()
				.and()
			.exceptionHandling()
				.authenticationEntryPoint(macLoginUrlAuthenticationEntryPoint).and()
			.csrf()
				.ignoringAntMatchers("/console/**").disable(); // 关闭csrf防护
	}
}