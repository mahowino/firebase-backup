package online.doordrop.kenya.DoorDrop.store.service;

import online.doordrop.kenya.DoorDrop.store.DTOMapper.StoreCategoryDTOMapper;
import online.doordrop.kenya.DoorDrop.store.DTOMapper.StoreDTOMapper;
import online.doordrop.kenya.DoorDrop.store.dto.StoreCategoryDTO;
import online.doordrop.kenya.DoorDrop.store.dto.StoreDTO;
import online.doordrop.kenya.DoorDrop.store.repository.StoreCategoryRepository;
import online.doordrop.kenya.DoorDrop.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final StoreCategoryRepository repository;
    private final StoreCategoryDTOMapper storeCategoryDTOMapper;
    @Autowired
    public CategoryService(
            StoreCategoryRepository repository,
            StoreCategoryDTOMapper storeCategoryDTOMapper
    ){
        this.repository=repository;
        this.storeCategoryDTOMapper=storeCategoryDTOMapper;

    }
    public List<StoreCategoryDTO> getAllCategories(){
        return repository
                .findAll()
                .stream()
                .map(storeCategoryDTOMapper)
                .collect(Collectors.toList());
    }
}
