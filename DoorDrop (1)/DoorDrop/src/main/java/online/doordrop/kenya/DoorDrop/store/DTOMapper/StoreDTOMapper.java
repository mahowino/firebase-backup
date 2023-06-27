package online.doordrop.kenya.DoorDrop.store.DTOMapper;

import online.doordrop.kenya.DoorDrop.store.dto.StoreDTO;
import online.doordrop.kenya.DoorDrop.store.models.Store;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StoreDTOMapper implements Function<Store, StoreDTO> {
    @Override
    public StoreDTO apply(Store store) {
       return new StoreDTO(
                store.getStoreId(),
                store.getStoreName(),
                store.getStoreUrl()
        );
    }
}
