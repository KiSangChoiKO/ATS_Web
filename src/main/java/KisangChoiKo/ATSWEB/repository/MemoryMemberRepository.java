package KisangChoiKo.ATSWEB.repository;

import KisangChoiKo.ATSWEB.Domain.Member;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import javax.persistence.EntityManager;

import java.util.Optional;


public class MemoryMemberRepository implements MemberRepository{
    private final EntityManager em;
    long sequence = 0L;
    public static final String Collection_member = "member";

    public MemoryMemberRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public String insertMember(Member member) throws Exception{
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture=
                dbFirestore.collection(Collection_member).document(member.getId()).set(member);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Optional<Member> getDetailMember(String id) throws Exception{
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection(Collection_member).document(id);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
        return Optional.ofNullable(documentSnapshot.toObject(Member.class));
    }

}