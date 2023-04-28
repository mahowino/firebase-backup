package online.doordrop.kenya.DoorDrop.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class StoreController {

    private final  StoreService service;

    @Autowired
    public StoreController(StoreService service) {
        this.service = service;
    }
    @Autowired

    @GetMapping("/")
    public ResponseEntity<List<Store>> getAllGoods(){
        return ResponseEntity.ok(service.getAllGoods());
    }


    @GetMapping(path = "/{goodId}")
    public ResponseEntity<Store> getGoods(@PathVariable("goodId") Long id){
        return ResponseEntity.ok(service.getGood(id));
    }
    @PostMapping("/add")
    public void getGoods(@RequestBody Store good){
        service.addGoods(good);
    }
}
