package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // localhost:8080/hello-mvc?name=spring
    public String helloMvc(@RequestParam(value= "name") String name, Model model){
        model.addAttribute("name",name); // 앞의 name이 key, 뒤의 name은 parameter로 넘어온 값
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    // http body 부분에 이 데이터("hello" + name)를 직접 넣어주겠다. name 을 spring 으로 넣으면 hello spring이 리턴.
    // 템플릿 엔진과의 차이 : view 가 없고 이 문자가 그대로 내려감. html 태그 없이 문자만 그대로 내려감
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api") // localhost:8080/hello-api?name=은주
    @ResponseBody
    public Hello helloApi(String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // json으로 반환
    }

    static class Hello {
        private String abc;

        public String getName() {
            return abc;
        }



        public void setName(String abc) {
            this.abc = abc;
        }
    }
}

