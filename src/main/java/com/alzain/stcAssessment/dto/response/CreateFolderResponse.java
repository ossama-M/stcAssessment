package com.alzain.stcAssessment.dto.response;

import com.alzain.stcAssessment.entity.Item;
import com.alzain.stcAssessment.entity.ItemType;
import com.alzain.stcAssessment.entity.ItemWUserPermission;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateFolderResponse extends Response {
    List<ItemWUserPermission> ItemUserPermission = new ArrayList<>();
    private long id;
    private ItemType type;
    private String name;
    private Item locationId;

    public CreateFolderResponse(int responseCode, long id, ItemType type, String name, Item locationId, List<ItemWUserPermission> itemUserPermission) {
        super(responseCode);
        this.id = id;
        this.type = type;
        this.name = name;
        this.locationId = locationId;
        ItemUserPermission = itemUserPermission;
    }
}
