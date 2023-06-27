package online.doordrop.kenya.DoorDrop.goods.dtoMapper;

import online.doordrop.kenya.DoorDrop.goods.dto.ItemTypesDTO;
import online.doordrop.kenya.DoorDrop.goods.dto.SubItemsDTO;
import online.doordrop.kenya.DoorDrop.goods.model.ItemTypes;
import online.doordrop.kenya.DoorDrop.goods.model.SubItems;

import java.util.function.Function;

public class ItemTypesDTOMapper implements Function<ItemTypes, ItemTypesDTO> {

    @Override
    public ItemTypesDTO apply(ItemTypes ItemTypes) {
        return new ItemTypesDTO(
                ItemTypes.getItemTypesId(),
                ItemTypes.getName()
        );
    }
}
