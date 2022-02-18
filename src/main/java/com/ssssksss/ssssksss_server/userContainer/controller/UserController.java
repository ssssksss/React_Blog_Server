package com.ssssksss.ssssksss_server.userContainer.controller;

import com.ssssksss.ssssksss_server.userContainer.dto.UserDto;
import com.ssssksss.ssssksss_server.userContainer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(value="/ssssksss/user/signup", method= RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody UserDto userDto) {
        return userService.signup(userDto);
    }

    @RequestMapping(value="/ssssksss/user/login", method= RequestMethod.POST)
    public ResponseEntity loginUser(@RequestBody UserDto userDto) {
        return userService.login(userDto);
    }

}
