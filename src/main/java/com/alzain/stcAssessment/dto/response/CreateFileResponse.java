package com.alzain.stcAssessment.dto.response;

import com.alzain.stcAssessment.entity.Item;
import com.alzain.stcAssessment.entity.ItemType;
import com.alzain.stcAssessment.entity.ItemWUserPermission;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CreateFileResponse extends Response {
    List<ItemWUserPermission> ItemUserPermission = new ArrayList<>();
    private long id;
    private ItemType type;
    private String name;
    private Item locationId;
    private byte[] fileBinary;

    public CreateFileResponse(int responseCode, long id,
                              ItemType type, String name,
                              Item locationId, List<ItemWUserPermission> itemUserPermission,
                              byte[] fileBinary) {
        super(responseCode);
        this.id = id;
        this.type = type;
        this.name = name;
        this.locationId = locationId;
        ItemUserPermission = itemUserPermission;
        this.fileBinary = fileBinary;
    }
}
