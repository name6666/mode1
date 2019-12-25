package net.jhc.app_info_mng.pojodto;

import lombok.Data;

@Data
public class OrderInformationDto {
    private int oid,oNumber;
    private String oName,oAddress,oFruit,oPrice;

}
