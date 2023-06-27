package online.doordrop.kenya.DoorDrop.goods.controller;

import online.doordrop.kenya.DoorDrop.goods.dto.ItemsDTO;
import online.doordrop.kenya.DoorDrop.goods.model.Item;
import online.doordrop.kenya.DoorDrop.goods.service.ItemService;
import online.doordrop.kenya.DoorDrop.store.dto.StoreDTO;
import online.doordrop.kenya.DoorDrop.store.models.Store;
import online.doordrop.kenya.DoorDrop.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
    private final ItemService service;


    @Autowired
    public ItemController(ItemService service) {
        this.service = service;
    }


    @GetMapping("/")
    public ResponseEntity<List<ItemsDTO>> getAllItems(){
        return ResponseEntity.ok(service.getAllItems());
    }

    @GetMapping(path = "/category/{categoryId}")
    public ResponseEntity<List<ItemsDTO>> getItemsByCategory(@PathVariable("categoryId") Long id){
        return ResponseEntity.ok(service.getAllItemsFromCategory(id));
    }
    @GetMapping(path = "/{itemId}")
    public ResponseEntity<ItemsDTO> getItemById(@PathVariable("itemId") Long id){
        return ResponseEntity.ok(service.getItemById(id));
    }

    @GetMapping(path = "/store/{storeId}")
    public ResponseEntity<List<ItemsDTO>> getItemsByStore(@PathVariable("storeId") Long id){
        return ResponseEntity.ok(service.getAllItemsFromStore(id));
    }

    @PostMapping("/add")
    public void addItem(@RequestBody Item item){
        service.addItem(item);
    }
}
