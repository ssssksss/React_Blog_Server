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

    @RequestMapping(value="/ssssksss/test", method= RequestMethod.POST)
    @CrossOrigin(origins="*", allowedHeaders="*")
    public ResponseEntity testPost(@RequestBody String test) {
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"POST API 성공"));
    }
    
    @RequestMapping("/")
    public String index() throws Exception{
        return "Hello World";
    }

}
