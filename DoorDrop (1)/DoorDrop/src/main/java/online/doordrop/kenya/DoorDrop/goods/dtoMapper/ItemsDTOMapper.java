package online.doordrop.kenya.DoorDrop.goods.dtoMapper;

import online.doordrop.kenya.DoorDrop.goods.dto.ItemsDTO;
import online.doordrop.kenya.DoorDrop.goods.model.Item;

import java.util.function.Function;

public class ItemsDTOMapper implements Function<Item,ItemsDTO> {
    @Override
    public ItemsDTO apply(Item item) {
        return new ItemsDTO(
          item.getItemId(),
          item.getItemImage(),
          item.getItemName()
        );
    }
}
