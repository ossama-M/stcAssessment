package com.alzain.stcAssessment.dto.response;

import com.alzain.stcAssessment.constant.ResponseCodes;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Response {
    private int responseCode;
    private String responseMessage;
    public Response(int responseCode) {
        this.responseCode = responseCode;
        this.responseMessage = ResponseCodes.getDesc(responseCode);
    }
}
