package edu.hacettepe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@ComponentScan
@EnableWebMvc
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/home", "/login.jsp").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login.jsp").permitAll()
                .defaultSuccessUrl("/jsp/customerIndex.jsp")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}