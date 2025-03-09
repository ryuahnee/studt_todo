package com.studytodo.web;

import com.studytodo.core.shared.identifier.TodoId;
import com.studytodo.core.todo.application.AddTodo;
import com.studytodo.core.todo.application.FindTodos;
import com.studytodo.core.todo.application.ModifyTodo;
import com.studytodo.core.todo.application.RemoveTodo;
import com.studytodo.core.todo.domain.Todo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "/api/todos")
public class StudyTodoRestController {

    private final FindTodos findTodos;
    private final AddTodo add;
    private final ModifyTodo modify;

    private final RemoveTodo remove;

    private final Logger log = LoggerFactory.getLogger(getClass());
    public StudyTodoRestController(FindTodos findTodos, AddTodo add, ModifyTodo modify, RemoveTodo remove) {
        this.findTodos = Objects.requireNonNull(findTodos);
        this.add = Objects.requireNonNull(add);
        this.modify = Objects.requireNonNull(modify);
        this.remove = remove;
    }

    // 목록 출력
    @GetMapping
    public Iterable<Todo> readAll(){
        return findTodos.all();
    }
    // 등록
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid WriteTodoCommand command) {
        log.debug("request command: {}", command);

        add.add(command.text());
    }

    @PutMapping("/{id}")
    public void modify(@PathVariable("id") String id, @RequestBody @Valid WriteTodoCommand command) {
        log.debug("request id: {}, command: {}", id, command);
        modify.modify(TodoId.of(id), command.text, command.completed());
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        log.debug("request id: {}, command: {}", id);
        remove.remove(TodoId.of(id));
    }


    record WriteTodoCommand(@NotBlank @Size(min = 4, max = 140) String text, boolean completed) {
    }






}
