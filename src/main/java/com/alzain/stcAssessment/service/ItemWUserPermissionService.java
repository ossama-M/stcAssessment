package com.alzain.stcAssessment.service;

import com.alzain.stcAssessment.dto.request.AddPermissionForUserOnItemRequest;
import com.alzain.stcAssessment.dto.response.Response;


public interface ItemWUserPermissionService {
    Response addOperationForUserOnItem(AddPermissionForUserOnItemRequest permissionRequest);
}
