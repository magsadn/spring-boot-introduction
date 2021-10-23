package az.atlacademy.springbootintro.service;

import az.atlacademy.springbootintro.config.MyTestClass;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service//Class-in bean-ini yaratmasi ucun mutleq bu annotasiya yazmaq lazimdir
public class MyService {

    MyTestClass myTestClass;

    public MyService(MyTestClass myTestClass) {
        this.myTestClass = myTestClass;
    }


    public List<String> getNames(){
        List<String> name = new ArrayList<>();
        //name=List.of("Anar","Ayhan","Meqsed");
        name.add("Anar");
        name.add("Ayhan");
        name.add("Meqsed");
        //name.addAll(myTestClass.names()); Bu kod elave etmedi deye, asagidaki yazdiq
       myTestClass.names().forEach(n->name.add(n));
        return name;
    }
}
