package online.doordrop.kenya.DoorDrop.goods.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
@Data
public class ItemTypes {
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
    long itemTypesId;
    String name;
    String description;


}
