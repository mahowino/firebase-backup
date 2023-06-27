package online.doordrop.kenya.DoorDrop.goods.service;

import online.doordrop.kenya.DoorDrop.goods.dao.ItemRepository;
import online.doordrop.kenya.DoorDrop.goods.dto.ItemsDTO;
import online.doordrop.kenya.DoorDrop.goods.dtoMapper.ItemsDTOMapper;
import online.doordrop.kenya.DoorDrop.goods.exceptions.ItemsNotFoundException;
import online.doordrop.kenya.DoorDrop.goods.model.Item;
import online.doordrop.kenya.DoorDrop.store.DTOMapper.StoreCategoryDTOMapper;
import online.doordrop.kenya.DoorDrop.store.dto.StoreCategoryDTO;
import online.doordrop.kenya.DoorDrop.store.exceptions.IDNotFoundException;
import online.doordrop.kenya.DoorDrop.store.models.Store;
import online.doordrop.kenya.DoorDrop.store.repository.StoreCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    //get all items in store,

    //get specific item

    private final ItemRepository repository;
    private final ItemsDTOMapper itemsDTOMapper;
    @Autowired
    public ItemService(
            ItemRepository repository,
            ItemsDTOMapper itemsDTOMapper
    ){
        this.repository=repository;
        this.itemsDTOMapper=itemsDTOMapper;

    }
    public List<ItemsDTO> getAllItems(){
        return repository
                .findAll()
                .stream()
                .map(itemsDTOMapper)
                .collect(Collectors.toList());
    }
    public List<ItemsDTO> getAllItemsFromCategory(Long categoryID){
        return repository
                .getItemsByCategory(categoryID)
                .orElseThrow(
                        ()->new ItemsNotFoundException("The items in the category do not exist")
                )
                .stream()
                .map(itemsDTOMapper)
                .collect(Collectors.toList());
    }
    public List<ItemsDTO> getAllItemsFromStore(Long itemId){
        return repository
                .getItemsByStore(itemId)
                .orElseThrow(
                        ()->new ItemsNotFoundException("The items in the store do not exist")
                )
                .stream()
                .map(itemsDTOMapper)
                .collect(Collectors.toList());
    }


    public ItemsDTO getItemById(Long id) {
        return repository.getItemById(id)
                .map(itemsDTOMapper)
                .orElseThrow(
                        ()-> new IDNotFoundException("item not found")
                );
    }

    public Item addItem(Item item) {
        return repository.save(item);
    }
}
