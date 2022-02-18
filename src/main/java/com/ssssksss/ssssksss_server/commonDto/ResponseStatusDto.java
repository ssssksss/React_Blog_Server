package com.ssssksss.ssssksss_server.commonDto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStatusDto {
    private static final long serialVersionUID = 1L;

    private int statusCode;
    private String msg;
    @Builder.Default private Boolean successFlag = true;

    public ResponseStatusDto(int statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }
}
