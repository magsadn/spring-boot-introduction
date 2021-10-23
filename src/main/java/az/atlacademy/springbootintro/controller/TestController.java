package az.atlacademy.springbootintro.controller;

import az.atlacademy.springbootintro.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {
    private MyService myService;

    public TestController(MyService myService){
        this.myService = myService;
    }

    @GetMapping("/names2")//     /a/names2 - olacaq ancaq diger MyController-de /api/names olacaq
    public List<String> getNames(){
        return myService.getNames();
    }
}
