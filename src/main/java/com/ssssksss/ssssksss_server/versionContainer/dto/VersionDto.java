package com.ssssksss.ssssksss_server.versionContainer.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VersionDto {

    private String name;
    private LocalDate date;
}
