package com.alzain.stcAssessment.service;

import com.alzain.stcAssessment.constant.ResponseCodes;
import com.alzain.stcAssessment.dto.request.CreateFileRequest;
import com.alzain.stcAssessment.dto.response.CreateFileResponse;
import com.alzain.stcAssessment.dto.response.Response;
import com.alzain.stcAssessment.entity.Files;
import com.alzain.stcAssessment.entity.Item;
import com.alzain.stcAssessment.entity.ItemId;
import com.alzain.stcAssessment.repo.FileRepo;
import com.alzain.stcAssessment.repo.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FileService {
    public final FileRepo fileRepo ;
    public final ItemRepo itemRepo ;

    public Response createFile(CreateFileRequest createFileRequest){
        Item item = Item.builder().itemId(ItemId.builder().
                file(createFileRequest.getLocation().getFile()).
                folder(createFileRequest.getLocation().getFolder()).
                space(createFileRequest.getLocation().getSpace()).build())
                .build();
        if(!itemRepo.getAllByItemId(item).isEmpty()){
            return new Response(ResponseCodes.ALREADY_EXIST);
        }
        Files files  = Files.builder().
                fileBinary(createFileRequest.getFileBinary()).
                item(item).build();
        Files fileDb =  fileRepo.save(files);
        return new CreateFileResponse(ResponseCodes.CREATED,
                fileDb.getId(),
                fileDb.getFileBinary(),
                fileDb.getItem());

    }
}
