package online.doordrop.kenya.DoorDrop.groceries.goodVariant;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.firebase.cloud.FirestoreClient;

import online.doordrop.kenya.DoorDrop.groceries.goodVariant.goodUtil.GoodVariantCollections;
import online.doordrop.kenya.DoorDrop.groceries.goodVariant.goodUtil.GoodVariantDao;
import online.doordrop.kenya.DoorDrop.groceries.goods.GoodUtil.GoodsCollections;
import online.doordrop.kenya.DoorDrop.groceries.goods.GoodVariant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class GoodVariantService {

    static Firestore db= FirestoreClient.getFirestore();

    public List<GoodVariant> getGoods(String goodId) throws ExecutionException, InterruptedException {
        Query query=db.collection(GoodsCollections.GOODS).document(goodId).collection(GoodVariantCollections.GOOD_TYPE);
        return GoodVariantDao.getGoodsFromFirestore(query);
    }

    public void addGoodVariant(GoodVariant good,String goodId){
        DocumentReference reference=db.collection(GoodsCollections.GOODS).document(goodId).collection(GoodVariantCollections.GOOD_TYPE).document();
        GoodVariantDao.addGoodsToFirestore(reference,good);
    }

}
