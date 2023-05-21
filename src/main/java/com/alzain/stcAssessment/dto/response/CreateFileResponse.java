package com.alzain.stcAssessment.dto.response;

import com.alzain.stcAssessment.entity.Item;
import lombok.*;

@Getter
@Setter
@ToString
public class CreateFileResponse extends Response{
    public CreateFileResponse(int responseCode, long id, byte[] fileBinary, Item item) {
        super(responseCode);
        this.id = id;
        this.fileBinary = fileBinary;
        this.item = item;
    }

    public CreateFileResponse(long id, byte[] fileBinary, Item item) {
        this.id = id;
        this.fileBinary = fileBinary;
        this.item = item;
    }

    public CreateFileResponse() {
    }

    public CreateFileResponse(int responseCode) {
        super(responseCode);
    }
    private long id ;
    private byte[] fileBinary;
    private Item item;

}
