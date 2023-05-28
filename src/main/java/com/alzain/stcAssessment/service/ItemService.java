package com.alzain.stcAssessment.service;

import com.alzain.stcAssessment.dto.request.CreateFileRequest;
import com.alzain.stcAssessment.dto.request.CreateFolderRequest;
import com.alzain.stcAssessment.dto.request.CreateSpaceRequest;
import com.alzain.stcAssessment.dto.response.Response;

public interface ItemService {
    Response createSpace(CreateSpaceRequest createSpaceRequest);

    Response createFolder(CreateFolderRequest createFolderRequest);

    Response createFile(CreateFileRequest createFileRequest);

    void prepareRoot();

}
