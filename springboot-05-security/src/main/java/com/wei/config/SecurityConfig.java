package com.wei.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问
        //功能页有权限的人才可以访问
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限会自动跳转到登录页,需要开启的登录页面
        //定制登入页面，需一一对应
        http.formLogin().loginPage("/toLogin")
                .usernameParameter("user")
                .passwordParameter("pwd")
                .loginProcessingUrl("/login");
        //注销
        //注销成功去首页
        http.logout().logoutSuccessUrl("/");
        //关闭CSRF功能
        http.csrf().disable();
        //记住我功能，用Cookie实现,自定义接收前端参数
        http.rememberMe().rememberMeParameter("remember");
    }

    //密码编码加密：在Spring Security 5+中，新增了许多加密方法。password1中标明了编码加密
    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据从数据库中读取
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("cosmos").password(new BCryptPasswordEncoder().encode("134567")).roles("vip1", "vip2")
                .and()
                .withUser("wei").password("123456").roles("vip3", "vip2")
                .and()
                .withUser("xu").password("123456").roles("vip3", "vip2", "vip1");
    }
}
