package com.ssssksss.ssssksss_server.userContainer.service;

import com.ssssksss.ssssksss_server.common.JwtTokenManager;
import com.ssssksss.ssssksss_server.commonDto.ResponseErrorDto;
import com.ssssksss.ssssksss_server.commonDto.ResponseStatusDto;
import com.ssssksss.ssssksss_server.commonDto.ResponseTokenDto;
import com.ssssksss.ssssksss_server.userContainer.dao.User;
import com.ssssksss.ssssksss_server.userContainer.dto.UserDto;
import com.ssssksss.ssssksss_server.userContainer.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public ResponseEntity signup(UserDto userDto) {
        System.out.println("1:"+userDto.toString());
        User user = User.builder()
                        .email(userDto.getEmail())
                        .password(bCryptPasswordEncoder.encode(userDto.getPassword())).build();
        userRepository.save(user);
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"Signup Success"));
    }

    public ResponseEntity login(UserDto userDto) {
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if(bCryptPasswordEncoder.matches(userDto.getPassword(),user.get().getPassword())) {
            JwtTokenManager jwtTokenManager = new JwtTokenManager();
            return ResponseEntity.ok().body(new ResponseTokenDto(200,"Login Success",
                    jwtTokenManager.createAccessToken(user.get())));
        }
        return ResponseEntity.ok().body("");
    }
}
