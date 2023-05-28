package com.alzain.stcAssessment.dto.request;

import com.alzain.stcAssessment.constant.ResponseCodes;
import com.alzain.stcAssessment.entity.PermissionLevel;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonPropertyOrder({"space", "folder", "file", "userEmail", "permissionLevel"})
public class AddPermissionForUserOnItemRequest {
    @NotNull(message = ResponseCodes.SPACE_NULL)
    private String space;
    private String folder;
    private String file;
    @NotNull(message = ResponseCodes.USER_NULL)
    private String userEmail;
    @NotNull(message = ResponseCodes.INVALID_PERMISSION)
    private PermissionLevel permissionLevel;

}
