package online.doordrop.kenya.DoorDrop.store.controllers;

import online.doordrop.kenya.DoorDrop.store.dto.StoreCategoryDTO;
import online.doordrop.kenya.DoorDrop.store.dto.StoreDTO;
import online.doordrop.kenya.DoorDrop.store.service.CategoryService;
import online.doordrop.kenya.DoorDrop.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService service;


    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<StoreCategoryDTO>> getAllCategories(){
        return ResponseEntity.ok(service.getAllCategories());
    }

}
