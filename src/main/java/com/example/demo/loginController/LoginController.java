package com.example.demo.loginController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController  {

    @RequestMapping("/user/login")
    public String login(String userName, String password, Model model, HttpSession session){
        if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
            model.addAttribute("msg","用户名不能为空");
            return "login";
        }
        if(!password.equals("123456")){
            model.addAttribute("msg","密码错误哦!");
            return "login";
        }
        session.setAttribute("user",userName);
        return "redirect:/dashboard";
    }
}
