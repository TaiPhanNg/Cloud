package com.QuanLyNhanSu.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;
 
 @Autowired
 private DataSource dataSource;
 
 private final String USERS_QUERY = "select email, password, active from user where email=?";
 private final String ROLES_QUERY = "select u.email, r.role from user u inner join user_role ur on (u.id = ur.user_id) inner join role r on (ur.role_id=r.role_id) where u.email=?";

 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth.jdbcAuthentication()
   .usersByUsernameQuery(USERS_QUERY)
   .authoritiesByUsernameQuery(ROLES_QUERY)
   .dataSource(dataSource)
   .passwordEncoder(bCryptPasswordEncoder);
 }
 
 @Override
 protected void configure(HttpSecurity http) throws Exception{
	 http.authorizeRequests().antMatchers("/css/**","/img/**").permitAll();
	 http.authorizeRequests()

   .antMatchers("/").permitAll()
   .antMatchers("/login").permitAll()
   .antMatchers("/signup").permitAll()
   .antMatchers("/department").permitAll()
             .antMatchers("/employee").permitAll()
             .antMatchers("/projects").permitAll()
   .antMatchers("/department/**").hasAuthority("ADMIN").anyRequest();
   http.authorizeRequests().antMatchers("/employee/**").hasAuthority("ADMIN").anyRequest();
   http.authorizeRequests().antMatchers("/projects/**").hasAuthority("ADMIN").anyRequest()
   .authenticated().and().csrf().disable()
   .formLogin().loginPage("/login").failureUrl("/login?login=faile")
   .defaultSuccessUrl("/department")
   .usernameParameter("email")
   .passwordParameter("password")
   .and().logout()
   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
   .logoutSuccessUrl("/")
   .and().exceptionHandling().accessDeniedPage("/access_denied");
  	
 }
}
