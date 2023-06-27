package online.doordrop.kenya.DoorDrop.goods.controller;

import online.doordrop.kenya.DoorDrop.goods.dto.ItemTypesDTO;
import online.doordrop.kenya.DoorDrop.goods.dto.ItemsDTO;
import online.doordrop.kenya.DoorDrop.goods.service.ItemService;
import online.doordrop.kenya.DoorDrop.goods.service.ItemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class ItemTypesController {

    private final ItemTypeService service;


    @Autowired
    public ItemTypesController(ItemTypeService service) {
        this.service = service;
    }
    @GetMapping("/")
    public ResponseEntity<List<ItemTypesDTO>> getAllItems(){
        return ResponseEntity.ok(service.getAllItemTypes());
    }
}
