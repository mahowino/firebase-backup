package online.doordrop.kenya.DoorDrop.auth.firebaseUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FirebaseUser {
    private String ID;
    private String firstname;
    private String lastname;
    private String email;
}
