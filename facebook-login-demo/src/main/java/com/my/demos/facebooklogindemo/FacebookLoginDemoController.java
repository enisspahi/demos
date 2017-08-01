package com.my.demos.facebooklogindemo;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableOAuth2Sso
public class FacebookLoginDemoController {

    @RequestMapping("/myDemoPage")
    public String myDemoPage(Model model) {
        model.addAttribute("message", "Hello from MVC controller");
        return "myDemoPage";
    }

}