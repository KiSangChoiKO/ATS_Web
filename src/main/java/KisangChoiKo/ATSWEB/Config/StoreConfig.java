package KisangChoiKo.ATSWEB.Config;


import KisangChoiKo.ATSWEB.Service.StoreService;
import KisangChoiKo.ATSWEB.repository.MemoryStoreRepository;
import KisangChoiKo.ATSWEB.repository.StoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class StoreConfig {

    DataSource dataSource;
    EntityManager em;


    public StoreConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public StoreService storeService(){
        return new StoreService(storeRepository());
    }

    @Bean
    public StoreRepository storeRepository(){
        return new MemoryStoreRepository(em);
    }
}
