package com.kingloo.springpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody  // html의 body 부분에 내가 직접 데이터를 넣어주겠다라는 뜻인거임
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;  // name이 요청한 것 그대로
    }

    // json 방식
    // Controller 에서 받은 요청을 처리하기 위해 HttpMessageConverter 가 동작한다
    // jackson, Gson 두가지 라이브러리가 있음(객체를 json 으로 바꾸는것)
    // API는 객체를 반환하는 방식, view 없이 바로 http response 에 값을 넣어줌 그냥
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() { return name; };
        public void setName(String name) { this.name = name; }
    }
}
