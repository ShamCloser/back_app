package com.springboot.controller;

import com.springboot.entity.Department;
import com.springboot.entity.User;
import com.springboot.service.IDeptService;
import com.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

/**
 * @ project  项目介绍
 * @ author  clsr
 * @ date  2019/3/13
 */
@Controller
public class UserController {

    @Autowired
    IUserService userService;
    @Autowired
    IDeptService deptService;

    /**
     * 登录
     * @param username
     * @param password
     * @param session
     * @param map
     * @return
     */
    @PostMapping("/user/login")
    public String handleLogin(@RequestParam("username") String username,@RequestParam("password") String password,
                             HttpSession session, Map<String,Object> map){
        User user = userService.loadUserByUsernameAndPassword(username,password);
        if (user != null){
            session.setAttribute("user",user);
            return "redirect:/main";
        } else {
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }

    /**
     * 员工列表
     * @param page
     * @param size
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String userList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                           @RequestParam(value = "size",defaultValue = "10") Integer size,
                           Model model){
        Page<User> users = userService.userList(page-1,size);
        Collection<Department> departments = deptService.allDepartment();
        model.addAttribute("users",users);
        model.addAttribute("page",page);
        model.addAttribute("departments",departments);
        return "empList";
    }

    /**
     * 新增员工
     * @param user
     * @param deptId
     * @return
     */
    @PostMapping("/emp")
    public String addUser(User user,Integer deptId){
        Department department = deptService.findDeptByDeptId(deptId);
        System.out.println("保存员工："+user);
        System.out.println("部门:"+ department);
        userService.save(user);
        return "redirect:/emps";
    }

    /**
     * 显示简单修改员工页面
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditSimple(@PathVariable("id") Integer id, Model model){
        User user = userService.findUserById(id);
        Collection<Department> departments = deptService.allDepartment();
        model.addAttribute("departments",departments);
        model.addAttribute("user",user);
        return "empSimpleEdit";
    }

    /**
     * 保存修改的员工
     * @param user
     * @return
     */
    @PutMapping("/emp")
    public String editUser(User user){
        System.out.println("保存员工："+user);
        userService.save(user);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return "redirect:/emps";
    }
}
