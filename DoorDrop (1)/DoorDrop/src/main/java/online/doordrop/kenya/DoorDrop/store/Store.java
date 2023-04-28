package online.doordrop.kenya.DoorDrop.store;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@ToString
public class Store {
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
    long storeId;
    String storeName,storeUrl;
    double storeDeliveryCost;
}
