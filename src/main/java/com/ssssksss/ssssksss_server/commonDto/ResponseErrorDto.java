package com.ssssksss.ssssksss_server.commonDto;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseErrorDto{

    private static final long serialVersionUID = 1L;

    private String fieldname;
    private String errorMessage;
    private int statusCode;
    private String msg;

//    public ResponseErrorDto(String fieldname,String errorMessage,int statusCode,String msg) {
//        this.statusCode = statusCode;
//        this.msg = msg;
//    }
}
