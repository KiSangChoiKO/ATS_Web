package KisangChoiKo.ATSWEB.Domain;

import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter @Setter
public class Store {

    private String id;
    private String businessName;
    private String storeName;
    private String type;
    private String address;
    private String detailAddress;
    private String phone;
    private long totalSeat;
    private String introduce;
    private List<String> positionIndex;

}
