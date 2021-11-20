package KisangChoiKo.ATSWEB.Service;


import KisangChoiKo.ATSWEB.Domain.Store;
import KisangChoiKo.ATSWEB.repository.StoreRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public String register(Store store) throws Exception{
        storeRepository.save(store);
        return store.getBusinessName();
    }

    public Optional<Store> findStore(String id) throws Exception{
        return Optional.ofNullable(storeRepository.getDetailStore(id).get());
    }
}
