package online.doordrop.kenya.DoorDrop.goods.service;

import online.doordrop.kenya.DoorDrop.goods.dao.ItemRepository;
import online.doordrop.kenya.DoorDrop.goods.dao.SubItemsRepository;
import online.doordrop.kenya.DoorDrop.goods.dto.ItemsDTO;
import online.doordrop.kenya.DoorDrop.goods.dto.SubItemsDTO;
import online.doordrop.kenya.DoorDrop.goods.dtoMapper.ItemsDTOMapper;
import online.doordrop.kenya.DoorDrop.goods.dtoMapper.SubItemsDTOMapper;
import online.doordrop.kenya.DoorDrop.store.exceptions.IDNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubItemsService {
    //get all items in store,

    //get specific item

    private final SubItemsRepository repository;
    private final SubItemsDTOMapper subItemsDTOMapper;
    @Autowired
    public SubItemsService(
            SubItemsRepository repository,
            SubItemsDTOMapper subItemsDTOMapper
    ){
        this.repository=repository;
        this.subItemsDTOMapper=subItemsDTOMapper;

    }
    public List<SubItemsDTO> getAllItems(){
        return repository
                .findAll()
                .stream()
                .map(subItemsDTOMapper)
                .collect(Collectors.toList());
    }


    public List<SubItemsDTO> getItemById(Long id) {
        return repository.getItemsById(id)
                .orElseThrow(
                        ()-> new IDNotFoundException("item not found")
                )
                .stream()
                .map(subItemsDTOMapper)
                .collect(Collectors.toList());

    }

}
