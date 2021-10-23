package az.atlacademy.springbootintro.controller;

//import org.springframework.stereotype.Controller;
import az.atlacademy.springbootintro.dto.Account;
import az.atlacademy.springbootintro.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
//@Controller
public class MyController {
/*
    //1ci usul
    @Autowired -- Controller yarananda gozleyir service class-nin beanii yaranir, goturub getirir bura.
*/
    private MyService myService;

    //2ci usul -- En dogru usul budur, MyService-de spring ozu objectini yaradir ve bura gonderir.
    public MyController(MyService myService){
        this.myService = myService;
    }

/*    //3cu usul. cons - gerek methodu cagiraq ki, inject elesin objecti bura.
    void inject(MyService myService){
        this.myService = myService;
    }*/

    //@GetMapping("/home") // bunun evezine asadikini yaza bilerik
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public String getHome() {
        return "<h1 style='color:red'>Home Page</h1>" + LocalDateTime.now().toString();
    }

    @GetMapping("/now")
    public String getNow(){
        String localDateTime = LocalDateTime.now().toString();
        return String.format("<h1>%s</h1>",localDateTime);
    }

    @GetMapping("/names")
    public List<String> getNames(){
        String localDateTime = LocalDateTime.now().toString();
        return myService.getNames();
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> save(@RequestBody Account account){
        System.out.println("Account " + account);
        if (account.getName().length()<6){
            return new ResponseEntity<>(
                    String.format("%s %s",account.getCustomer(),account.getName()),
                    HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity(String.format("%s %s", account.getCustomer(),account.getName()), HttpStatus.CREATED);
        //ResponseEntity.ok(String.format("%s %s", account.getCustomer(),account.getName())); //bu kod erro 500 verdi.
    }
}
