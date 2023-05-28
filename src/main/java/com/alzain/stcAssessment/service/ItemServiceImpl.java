package com.alzain.stcAssessment.service;

import com.alzain.stcAssessment.constant.ResponseCodes;
import com.alzain.stcAssessment.dto.request.CreateFileRequest;
import com.alzain.stcAssessment.dto.request.CreateFolderRequest;
import com.alzain.stcAssessment.dto.request.CreateSpaceRequest;
import com.alzain.stcAssessment.dto.response.CreateFileResponse;
import com.alzain.stcAssessment.dto.response.CreateFolderResponse;
import com.alzain.stcAssessment.dto.response.CreateSpaceResponse;
import com.alzain.stcAssessment.dto.response.Response;
import com.alzain.stcAssessment.entity.Files;
import com.alzain.stcAssessment.entity.Item;
import com.alzain.stcAssessment.entity.ItemType;
import com.alzain.stcAssessment.repo.FileRepo;
import com.alzain.stcAssessment.repo.ItemRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@Slf4j
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepo itemRepo;
    private final FileRepo fileRepo;


    public Response createSpace(CreateSpaceRequest createSpaceRequest) {

        if (itemRepo.findItemByNameAndItemType(createSpaceRequest.getSpace(), String.valueOf(ItemType.space)).isPresent()) {
            return new Response(ResponseCodes.SPACE_ALREADY_EXIST);
        }

        Item itemDb = itemRepo.save(Item.builder().name(createSpaceRequest.getSpace()).
                type(ItemType.space).locationId(itemRepo.findItemById(1).get()).build());

        CreateSpaceResponse createSpaceResponse = new CreateSpaceResponse(ResponseCodes.CREATED,
                itemDb.getId(), itemDb.getType(), itemDb.getName(), itemDb.getLocationId(), itemDb.getItemUserPermission());
        return createSpaceResponse;
    }

    @Override
    public Response createFolder(CreateFolderRequest folderRequest) {
        Item spaceItem = itemRepo.findItemByNameAndItemType(folderRequest.getSpace(),
                String.valueOf(ItemType.space)).orElse(new Item());
        if (spaceItem.getId() == 0)
            return new Response(ResponseCodes.SPACE_NOT_EXIST);
        Item folderItem = itemRepo.save(Item.builder().locationId(spaceItem).type(ItemType.folder).name(folderRequest.getFolder()).build());

        return new CreateFolderResponse(ResponseCodes.CREATED,
                folderItem.getId(),
                ItemType.folder,
                folderItem.getName(),
                folderItem.getLocationId(),
                folderItem.getItemUserPermission());
    }

    @Override
    public Response createFile(CreateFileRequest fileRequest) {
        long fileid = -1;
        boolean fileInSpaceFlag = false;
        Item parentItem = new Item();

        if (Objects.nonNull(fileRequest.getFolder())) {
            fileid = itemRepo.findLocationIdBySpaceAndFolder(
                    fileRequest.getSpace(), fileRequest.getFolder()).orElse(Long.valueOf(-1));
        } else {
            parentItem = itemRepo.findItemByNameAndItemType(fileRequest.getSpace(),
                    String.valueOf(ItemType.space)).orElse(Item.builder().id(-1).build());
            fileid = parentItem.getId();
            fileInSpaceFlag = true;
        }
        if (fileid == -1) {
            return new Response(ResponseCodes.INVALID_LOCATION);
        }
        if (!fileInSpaceFlag) {
            parentItem = itemRepo.findItemById(fileid).get();
        }
        Item fileItem = Item.builder().name(fileRequest.getFile()).type(ItemType.file).
                locationId(parentItem).build();
        fileItem = itemRepo.save(fileItem);
        Files files = Files.builder().item(fileItem).fileName(fileItem.getName()).fileBinary(fileRequest.getFileBinary()).build();
        files = fileRepo.save(files);

        CreateFileResponse createFileResponse = new CreateFileResponse(ResponseCodes.CREATED,
                files.getId(), ItemType.file
                , files.getFileName(), files.getItem()
                , fileItem.getItemUserPermission()
                , null);
        return createFileResponse;
    }


    @Override
    public void prepareRoot() {
        // itemRepo.createRootLocation();
    }


}
