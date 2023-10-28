package cn.shh.test.ssm.controller;

import cn.shh.test.ssm.pojo.User;
import cn.shh.test.ssm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/get/{id}")
    @ResponseBody
    public User getUserById(@PathVariable int id){
        return userService.getById(id);
    }
}