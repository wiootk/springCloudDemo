package com.jun.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jun.entity.User;
import com.jun.service.UserService;
import com.jun.utils.Access;
import com.jun.utils.AccessModule;
import com.jun.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RestController
@Controller
@AccessModule(module = {"module"},desc="类的描述")
public class UserController {
    @Autowired
    private UserService service;
    //    http://localhost:8002/testError
    @GetMapping("/testError")
    public void testError() {
        int i = 1 / 0;
    }
//    http://localhost:8002/find/name
    @GetMapping("/find/{name}")
    @ResponseBody
    @Access(roles = {"角色"},powers = {"power"},desc="方法的描述",absPowers={"absPowers"})
    @Log(desc="日志测试",func="功能",type="002")
    public PageInfo<User> likeName(@PathVariable(value="name")String name) {
        PageHelper.startPage(1, 2);
        List<User> list=service.likeName("%"+name+"%");
        PageInfo<User> p=new PageInfo<User>(list);
        return  p;
    }
    //    http://localhost:8002/save {"name":"test","age":10}
    @PostMapping("/save")
    @Log(desc="日志测试2",func="功能2",type="003")
    @Access(roles = {"角色"},powers = {"power"},desc="方法的描述",absPowers={"absPowers"})
    public ModelAndView save(@RequestBody User user) {
        ModelAndView model = new ModelAndView();
        service.save(user);
        model.addObject("user", service.getById(user.getId()));
        model.setViewName("userInfo");
        return model;
    }
//    http://localhost:8002/getById/1
    @RequestMapping("/getById/{id}")
    public String getById(Model model,@PathVariable(value="id")Integer id) {
        model.addAttribute("user", service.getById(id));
        return "userInfo";
    }
}