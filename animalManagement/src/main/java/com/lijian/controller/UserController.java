package com.lijian.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author lijia
 * @createTime 2023/5/21 22:21
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/{userId}")
    @ResponseBody
    public String userTest(@PathVariable String userId) {
        System.out.println("1111111"+ userId);
        return "success";
    }
}
