package online.doordrop.kenya.DoorDrop.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    StoreRepository repository;

    @Autowired
    public StoreService(StoreRepository repository){
        this.repository=repository;

    }
    public List<Store> getAllGoods(){
        return repository.findAll();
    }

    public Store getGood(Long goodId){
        return repository.getGoodById(goodId).orElseThrow(()-> new IDNotFoundException("good not found"));
    }

    public void addGoods(Store good){
        repository.save(good);
    }

}
