package com.ssssksss.ssssksss_server.todoContainer.controller;

import com.ssssksss.ssssksss_server.todoContainer.dto.TodoDto;
import com.ssssksss.ssssksss_server.todoContainer.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @RequestMapping(value="/ssssksss/add/todo", method= RequestMethod.POST)
    public ResponseEntity addTodo(@RequestBody TodoDto todoDto) {
        todoDto.setDayOfWeek(todoDto.getDate());
        return ResponseEntity.ok()
                .body(todoDto);
    }
}
