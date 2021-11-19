package KisangChoiKo.ATSWEB.repository;


import KisangChoiKo.ATSWEB.Domain.Store;

import java.util.Optional;

public interface StoreRepository {
    String save(Store store) throws Exception;
    Optional<Store> getDetailStore(String id) throws Exception;
}
