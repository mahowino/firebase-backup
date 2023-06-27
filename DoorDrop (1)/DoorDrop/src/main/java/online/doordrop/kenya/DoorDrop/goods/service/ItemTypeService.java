package online.doordrop.kenya.DoorDrop.goods.service;

import online.doordrop.kenya.DoorDrop.goods.dao.ItemRepository;
import online.doordrop.kenya.DoorDrop.goods.dao.ItemTypesRepository;
import online.doordrop.kenya.DoorDrop.goods.dto.ItemTypesDTO;
import online.doordrop.kenya.DoorDrop.goods.dto.ItemsDTO;
import online.doordrop.kenya.DoorDrop.goods.dtoMapper.ItemTypesDTOMapper;
import online.doordrop.kenya.DoorDrop.goods.dtoMapper.ItemsDTOMapper;
import online.doordrop.kenya.DoorDrop.goods.exceptions.ItemsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemTypeService {
    private final ItemTypesRepository repository;
    private final ItemTypesDTOMapper itemTypesDTOMapper;

    @Autowired
    public ItemTypeService(
            ItemTypesRepository repository,
            ItemTypesDTOMapper itemTypesDTOMapper
    ) {
        this.repository = repository;
        this.itemTypesDTOMapper = itemTypesDTOMapper;

    }

    public List<ItemTypesDTO> getAllItemTypes() {
        return repository
                .findAll()
                .stream()
                .map(itemTypesDTOMapper)
                .collect(Collectors.toList());
    }

}