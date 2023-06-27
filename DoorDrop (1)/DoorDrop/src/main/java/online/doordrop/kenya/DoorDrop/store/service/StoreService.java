package online.doordrop.kenya.DoorDrop.store.service;

import online.doordrop.kenya.DoorDrop.store.DTOMapper.StoreDTOMapper;
import online.doordrop.kenya.DoorDrop.store.dto.StoreDTO;
import online.doordrop.kenya.DoorDrop.store.repository.StoreRepository;
import online.doordrop.kenya.DoorDrop.store.exceptions.CategoryNotFoundException;
import online.doordrop.kenya.DoorDrop.store.exceptions.IDNotFoundException;
import online.doordrop.kenya.DoorDrop.store.models.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {
    private final StoreRepository repository;
    private final StoreDTOMapper storeDTOMapper;

    @Autowired
    public StoreService(
            StoreRepository repository,
            StoreDTOMapper storeDTOMapper
            ){
        this.repository=repository;
        this.storeDTOMapper=storeDTOMapper;

    }
    public List<StoreDTO> getAllStores(){
        return repository
                .findAll()
                .stream()
                .map(storeDTOMapper)
                .collect(Collectors.toList());
    }

    public StoreDTO getStoreByID(Long storeId){
        return repository.getStoreById(storeId)
                .map(storeDTOMapper)
                .orElseThrow(
                ()-> new IDNotFoundException("good not found")
        );
    }

    public List<StoreDTO> getStoresByCategory(Long storeId){

        return repository.getStoreByCategory(storeId).orElseThrow(
                ()-> new CategoryNotFoundException("The specified category is not found")
        )
                .stream()
                .map(storeDTOMapper)
                .collect(Collectors.toList());
    }


    public void addStore(Store good){
        repository.save(good);
    }

}
