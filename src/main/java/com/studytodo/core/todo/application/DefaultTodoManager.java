package com.studytodo.core.todo.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.studytodo.core.shared.identifier.TodoId;
import com.studytodo.core.todo.domain.Todo;
import com.studytodo.core.todo.domain.TodoIdGenerator;
import com.studytodo.core.todo.domain.TodoNotFoundException;
import com.studytodo.core.todo.domain.TodoRepository;

import java.util.List;
import java.util.Objects;

/**
 * 할일 관리를 위한 유스케이스 구현체이다.
 *
 * @author springrunner.kr@gmail.com
 */
@Service
@Transactional
class DefaultTodoManager implements FindTodos, AddTodo, ModifyTodo, RemoveTodo {

    private final TodoIdGenerator todoIdGenerator;
    private final TodoRepository todoRepository;

    DefaultTodoManager(TodoIdGenerator todoIdGenerator, TodoRepository todoRepository) {
        this.todoIdGenerator = Objects.requireNonNull(todoIdGenerator);
        this.todoRepository = Objects.requireNonNull(todoRepository);
    }

    @Override
    public List<Todo> all() {
        return todoRepository.findAll();
    }

    @Override
    public Todo byId(TodoId id) {
        return todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    @Override
    public TodoId add(String text) {
        return todoRepository.save(Todo.create(text, todoIdGenerator)).getId();
    }

    @Override
    public void modify(TodoId id, String text, boolean completed) {
        byId(id).edit(text, completed);
    }

    @Override
    public void remove(TodoId id) {
        todoRepository.delete(byId(id));
    }

}
