package online.doordrop.kenya.DoorDrop.store.controllers;

import online.doordrop.kenya.DoorDrop.store.DTOMapper.StoreDTOMapper;
import online.doordrop.kenya.DoorDrop.store.dto.StoreDTO;
import online.doordrop.kenya.DoorDrop.store.models.Store;
import online.doordrop.kenya.DoorDrop.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store/")
public class StoreController {

    private final StoreService service;


    @Autowired
    public StoreController(StoreService service) {
        this.service = service;
    }


    @GetMapping("/")
    public ResponseEntity<List<StoreDTO>> getAllStores(){
        return ResponseEntity.ok(service.getAllStores());
    }


 /*   @GetMapping(path = "/{storeId}")
    public ResponseEntity<StoreDTO> getStore(@PathVariable("storeId") Long id){
        return ResponseEntity.ok(service.getStoreByID(id));
    }*/

    @GetMapping(path = "/{categoryId}")
    public ResponseEntity<List<StoreDTO>> getStoreByCategory(@PathVariable("categoryId") Long id){
        return ResponseEntity.ok(service.getStoresByCategory(id));
    }

    @PostMapping("/add")
    public void addStore(@RequestBody Store store){
        service.addStore(store);
    }
}
