package com.alzain.stcAssessment.service;

import com.alzain.stcAssessment.dto.request.CreateFileRequest;
import com.alzain.stcAssessment.dto.response.Response;
import com.alzain.stcAssessment.repo.FileRepo;
import com.alzain.stcAssessment.repo.ItemRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class FileService {
    public final FileRepo fileRepo;
    public final ItemRepo itemRepo;

    public Response createFile(CreateFileRequest createFileRequest) {
        return null;
    }
}
