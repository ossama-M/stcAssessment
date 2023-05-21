package com.alzain.stcAssessment.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FileLocationBean {
    private String space ;
    private String folder;
    private String file ;



}
