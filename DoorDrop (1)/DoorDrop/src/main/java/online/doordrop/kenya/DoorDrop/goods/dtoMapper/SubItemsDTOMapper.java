package online.doordrop.kenya.DoorDrop.goods.dtoMapper;

import online.doordrop.kenya.DoorDrop.goods.dto.ItemsDTO;
import online.doordrop.kenya.DoorDrop.goods.dto.SubItemsDTO;
import online.doordrop.kenya.DoorDrop.goods.model.Item;
import online.doordrop.kenya.DoorDrop.goods.model.SubItems;

import java.util.function.Function;

public class SubItemsDTOMapper  implements Function<SubItems, SubItemsDTO> {

    @Override
    public SubItemsDTO apply(SubItems subItems) {
        return new SubItemsDTO(
                subItems.getName(),
                subItems.getDescription(),
                subItems.getItemPrice()
        );
    }
}
