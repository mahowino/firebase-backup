package online.doordrop.kenya.DoorDrop.goods.controller;

import online.doordrop.kenya.DoorDrop.goods.dto.ItemsDTO;
import online.doordrop.kenya.DoorDrop.goods.dto.SubItemsDTO;
import online.doordrop.kenya.DoorDrop.goods.service.ItemService;
import online.doordrop.kenya.DoorDrop.goods.service.SubItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subItems")
public class SubItemsController {
    private final SubItemsService service;


    @Autowired
    public SubItemsController(SubItemsService service) {
        this.service = service;
    }

    @GetMapping(path = "/{itemId}")
    public ResponseEntity<List<SubItemsDTO>> getItemById(@PathVariable("itemId") Long id){
        return ResponseEntity.ok(service.getItemById(id));
    }

}
