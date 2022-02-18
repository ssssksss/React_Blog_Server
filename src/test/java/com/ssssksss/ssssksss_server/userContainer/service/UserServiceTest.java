package com.ssssksss.ssssksss_server.userContainer.service;

import com.ssssksss.ssssksss_server.userContainer.dao.User;
import com.ssssksss.ssssksss_server.userContainer.dto.UserDto;
import com.ssssksss.ssssksss_server.userContainer.repository.UserRepository;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;



@DisplayName("UserService 테스트")
@TestMethodOrder(MethodOrderer.MethodName.class)
class UserServiceTest {

    @DisplayName("회원가입")
    @Test
    @Order(1)
    void signup() {
//        1.given, 테스트코드에서 주어지는 값들
//        2.when, 값을 통해 조건을 주는 부분
//        3,then, 테스트를 하는 부분

    }

    @DisplayName("로그인")
    @Test
    @Order(2)
    public void login() throws Exception {
        //given, 테스트코드에서 주어지는 값들
        //when, 값을 통해 조건을 주는 부분
        //then, 테스트를 하는 부분
    }
}