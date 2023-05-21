package com.alzain.stcAssessment.controller;

import com.alzain.stcAssessment.dto.request.CreateSpaceRequest;
import com.alzain.stcAssessment.dto.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stc-assessments")
@RequiredArgsConstructor
@Slf4j
public class SystemDesignController {


    @PostMapping("/create-space")
    public Response createSpace(@RequestBody CreateSpaceRequest createSpaceRequest){

        return null;
    }

    @PostMapping("/create-folder")
    public Response createFolder(){
        return null;
    }
    @PostMapping("/create-file")
    public Response createFile(){
        return null;
    }

    @PutMapping("/modify-space")
    public Response modifySpace(){
        return null;
    }
    @PutMapping("/modify-folder")
    public Response modifyFolder(){
        return null;
    }
    @PutMapping("/modify-file")
    public Response modifyFile(){
        return null;
    }
    @GetMapping("/view-space")
    public Response viewSpace(){
        return null;
    }
    @GetMapping("/view-folder")
    public Response viewFolder(){
        return null;
    }
    @GetMapping("/view-file")
    public Response viewFile(){
        return null;
    }

    @PostMapping("/save-user")
    public Response saveUser(){
        return null;
    }




}
