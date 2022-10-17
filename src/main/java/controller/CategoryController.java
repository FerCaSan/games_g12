package controller;


import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired

    private CategoryService categoryService;

    @GetMapping("/all")             //pe  //localhost:8080/api/Category/all
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")            //pe  //localhost:8080/api/Category/11
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

}
