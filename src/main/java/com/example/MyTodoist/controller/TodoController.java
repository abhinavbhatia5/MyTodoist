package com.example.MyTodoist.controller;

import com.example.MyTodoist.models.ListItem;
import com.example.MyTodoist.repository.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/")

public class TodoController {

    @Autowired
    private TodoRepository todoRepo;

    @GetMapping("/getList")
    public List<ListItem> findAll(){
        return (List<ListItem>) todoRepo.findAll();
    }
//    @PostMapping("/add")
//    public void addItem(@Valid @RequestParam String title){
//        ListItem n=new ListItem(title);
//        todoRepo.save(n);
//    }
@PostMapping("/add")
public void addItem(@Valid @RequestBody ListItem request) {
    todoRepo.save(request);
}



    @PutMapping("/complete")
    public void update(@Valid @RequestBody ListItem request){
        ListItem n=todoRepo.FindByTitle(request.getTitle());
        n.setIsDone(true);
        todoRepo.save(n);

    }
    @DeleteMapping("/remove")
    public void delete(@Valid @RequestBody ListItem request){
        ListItem n=todoRepo.FindByTitle(request.getTitle());
        todoRepo.delete(n);
    }



}
