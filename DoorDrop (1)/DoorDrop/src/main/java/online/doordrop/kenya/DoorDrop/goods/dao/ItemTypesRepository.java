package online.doordrop.kenya.DoorDrop.goods.dao;

import online.doordrop.kenya.DoorDrop.goods.model.Item;
import online.doordrop.kenya.DoorDrop.goods.model.ItemTypes;
import online.doordrop.kenya.DoorDrop.goods.model.SubItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemTypesRepository extends JpaRepository<ItemTypes, Long> {


}
