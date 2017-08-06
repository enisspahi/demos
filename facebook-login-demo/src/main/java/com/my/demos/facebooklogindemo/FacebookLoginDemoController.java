package com.my.demos.facebooklogindemo;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableOAuth2Sso
public class FacebookLoginDemoController extends WebSecurityConfigurerAdapter {

    @RequestMapping("/myDemoPage")
    public String myDemoPage(Authentication authentication, Model model) {
        model.addAttribute("message", "Hello from MVC controller");
        model.addAttribute("userId", authentication.getName());
        model.addAttribute("details", authentication.getDetails());
        model.addAttribute("isAuthenticated", authentication.isAuthenticated());
        return "myDemoPage";
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**").authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated();
    }

}