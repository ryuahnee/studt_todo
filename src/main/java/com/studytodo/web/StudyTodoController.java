package com.studytodo.web;


import com.studytodo.core.todo.application.FindTodos;
import com.studytodo.core.todo.domain.Todo;
import com.studytodo.core.todo.domain.support.SpreadsheetConverter;
import com.studytodo.web.model.SiteProperties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.AbstractView;

import java.util.*;

@Controller
public class StudyTodoController {

    private final SiteProperties siteProperties;
    private final FindTodos find;

    public StudyTodoController(SiteProperties siteProperties, FindTodos find) {
        this.siteProperties = Objects.requireNonNull(siteProperties);
        this.find = find;
    }

    //todos 엔드포인트에 할일 목록 페이지를 매핑한다
    @RequestMapping("/todos")
    public void todolist(Model model){
            model.addAttribute(SpreadsheetConverter.convert(find.all()));
        }

}
