package com.ssssksss.ssssksss_server;

import com.ssssksss.ssssksss_server.commonDto.ResponseStatusDto;
import com.ssssksss.ssssksss_server.userContainer.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * PackageName : com.ssssksss.ssssksss_server
 * FileName : TestController
 * Author : 이 수 경
 * Date : 2022-02-19
 * Description : API 작동 테스트 컨트롤러
 */

@RestController
public class TestController {

    @RequestMapping("/")
    public String index() throws Exception{
        return "Hello World3";
    }
    @RequestMapping(value="/ssssksss/test", method= RequestMethod.GET)
    public String test() throws Exception{
        return "Hello World";
    }

}
