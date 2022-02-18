package com.ssssksss.ssssksss_server.todoContainer.dto;

import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
    private String color;
    private LocalDate date;
    private String dayOfWeek;
    private Boolean isCheck;
    private String content;

    public void setDayOfWeek(LocalDate localDate) {
        this.dayOfWeek = localDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);
    }
}
