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
public class SubItems {
    @Id
    long subItemID;

    @ManyToOne
    Item item;
    String name;
    String description;

    double itemPrice;

    public SubItems(String name,String description,double itemPrice){
        this.name=name;
        this.description=description;
        this.itemPrice=itemPrice;
    }

}
