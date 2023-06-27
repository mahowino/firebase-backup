package online.doordrop.kenya.DoorDrop.goods.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.doordrop.kenya.DoorDrop.store.models.Store;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
@Data

public class Item {
    @Id
    @SequenceGenerator(
            name = "good_sequence",
            sequenceName = "good_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "good_sequence"
    )
    long itemId;
    String itemImage, itemName;

    @OneToOne
    ItemTypes types;

    @ManyToOne
    Store store;

    @OneToMany(mappedBy = "item")
    List<SubItems> subItems;




}
