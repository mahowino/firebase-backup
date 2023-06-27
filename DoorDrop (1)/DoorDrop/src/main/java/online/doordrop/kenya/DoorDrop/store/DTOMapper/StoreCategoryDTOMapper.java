package online.doordrop.kenya.DoorDrop.store.DTOMapper;

import online.doordrop.kenya.DoorDrop.store.dto.StoreCategoryDTO;
import online.doordrop.kenya.DoorDrop.store.dto.StoreDTO;
import online.doordrop.kenya.DoorDrop.store.models.StoreCategory;

import java.util.function.Function;

public class StoreCategoryDTOMapper implements Function<StoreCategory, StoreCategoryDTO> {
    @Override
    public StoreCategoryDTO apply(StoreCategory storeCategory) {
        return new StoreCategoryDTO(
                storeCategory.getStoreCategoryId(),
                storeCategory.getStoreCategoryName()
        );
    }
}
