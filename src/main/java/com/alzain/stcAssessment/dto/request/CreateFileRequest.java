package com.alzain.stcAssessment.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CreateFileRequest {
    private FileLocationBean location;
    private byte[] fileBinary;
}
