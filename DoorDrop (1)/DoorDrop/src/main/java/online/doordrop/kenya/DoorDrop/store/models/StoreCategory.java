package online.doordrop.kenya.DoorDrop.store.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class StoreCategory {


    @Id

    long storeCategoryId;
    String storeCategoryName;

    @OneToMany( mappedBy = "category")
    List<Store> stores;

}
