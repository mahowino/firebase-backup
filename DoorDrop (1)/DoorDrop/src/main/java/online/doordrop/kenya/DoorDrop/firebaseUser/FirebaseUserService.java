package online.doordrop.kenya.DoorDrop.firebaseUser;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;

import online.doordrop.kenya.DoorDrop.firebaseUser.constants.UserConstants;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseUserService {
static FirebaseAuth auth=FirebaseAuth.getInstance();
    static Firestore db= FirestoreClient.getFirestore();

public static CompletableFuture<String> signUpUser(String email, String password, String firstName, String lastname) throws FirebaseAuthException {
    UserRecord.CreateRequest request=new UserRecord.CreateRequest();
    request.setEmail(email);
    request.setPassword(password);
    String uid= auth.createUser(request).getUid();
    db.collection(UserConstants.USER).document(uid).set(createUserObject(email,password,firstName,lastname));

    return CompletableFuture.supplyAsync(()-> uid);

}



    public static String logInUser(String email) throws FirebaseAuthException, ExecutionException, InterruptedException {
    //find userID from firestore;

        Query query=db.collection(UserConstants.USER).whereEqualTo(UserConstants.email,email);
        ApiFuture<QuerySnapshot> future=query.get();
        QuerySnapshot snapshot=future.get();
        String id="";
        for (DocumentSnapshot documentSnapshot:snapshot){
            id= documentSnapshot.getId();
        }
        return id;
    }


    private static Map<String, Object> createUserObject(String email, String password, String firstName, String lastname) {
        Map<String,Object> map=new HashMap<>();
        map.put(UserConstants.firstName,firstName);
        map.put(UserConstants.lastName,lastname);
        map.put(UserConstants.email,email);

        return map;
    }
}
