package KisangChoiKo.ATSWEB.repository;

import java.util.Optional;

public class MemoryStoreRepository implements StoreRepository{
    Long index = 0L;
    private final EntityManager em;


    public MemoryStoreRepository(EntityManager em) {
        this.em = em;
    }

    public static final String Collection_member = "store";

    @Override
    public String save(Store store) throws Exception {
        Firestore dbFiresotre = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture =
                dbFiresotre.collection(Collection_member).document(store.getId()).set(store);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }


    @Override
    public Optional<Store> getDetailStore(String id) throws Exception {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection(Collection_member).document(id);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
        return Optional.ofNullable(documentSnapshot.toObject(Store.class));
    }
}
