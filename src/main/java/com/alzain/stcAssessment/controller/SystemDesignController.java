package com.alzain.stcAssessment.controller;

import com.alzain.stcAssessment.dto.request.CreateFileRequest;
import com.alzain.stcAssessment.dto.request.CreateSpaceRequest;
import com.alzain.stcAssessment.dto.response.Response;
import com.alzain.stcAssessment.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stc-assessments")
@RequiredArgsConstructor
@Slf4j
public class SystemDesignController {
    public final FileService fileService ;


    @PostMapping("/create-space")
    public @ResponseBody Response createSpace(@RequestBody CreateSpaceRequest createSpaceRequest){

        return null;
    }

    @PostMapping("/create-folder")
    public @ResponseBody Response createFolder(){
        return null;
    }
    @PostMapping("/create-file")
    public @ResponseBody Response createFile(@RequestBody CreateFileRequest createFileRequest){
        return fileService.createFile(createFileRequest);
    }

    @PutMapping("/modify-space")
    public @ResponseBody Response modifySpace(){
        return null;
    }
    @PutMapping("/modify-folder")
    public @ResponseBody Response modifyFolder(){
        return null;
    }
    @PutMapping("/modify-file")
    public @ResponseBody Response modifyFile(){
        return null;
    }
    @GetMapping("/view-space")
    public @ResponseBody Response viewSpace(){
        return null;
    }
    @GetMapping("/view-folder")
    public @ResponseBody Response viewFolder(){
        return null;
    }
    @GetMapping("/view-file")
    public @ResponseBody Response viewFile(){
        return null;
    }

    @PostMapping("/save-user")
    public @ResponseBody Response saveUser(){
        return null;
    }

}
