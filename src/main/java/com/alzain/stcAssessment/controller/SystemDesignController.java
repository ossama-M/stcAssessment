package com.alzain.stcAssessment.controller;

import com.alzain.stcAssessment.dto.request.AddPermissionForUserOnItemRequest;
import com.alzain.stcAssessment.dto.request.CreateFileRequest;
import com.alzain.stcAssessment.dto.request.CreateFolderRequest;
import com.alzain.stcAssessment.dto.request.CreateSpaceRequest;
import com.alzain.stcAssessment.dto.response.Response;
import com.alzain.stcAssessment.entity.AppRole;
import com.alzain.stcAssessment.entity.ServiceUser;
import com.alzain.stcAssessment.security.service.UserService;
import com.alzain.stcAssessment.service.ItemService;
import com.alzain.stcAssessment.service.ItemWUserPermissionService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/stc-assessments")
@RequiredArgsConstructor
@Slf4j
public class SystemDesignController {

    private final ItemService itemService;
    private final UserService userService;
    private final ItemWUserPermissionService itemWUserPermissionService;


    @PostMapping("/create-space")
    public @ResponseBody Response createSpace(@RequestBody CreateSpaceRequest createSpaceRequest) {
        return itemService.createSpace(createSpaceRequest);

    }

    @PostMapping("/create-folder")
    public @ResponseBody Response createFolder(@RequestBody CreateFolderRequest createFolderRequest) {
        return itemService.createFolder(createFolderRequest);
    }

    @PostMapping("/create-file")
    public @ResponseBody Response createFile(@RequestBody CreateFileRequest createFileRequest) {
        return itemService.createFile(createFileRequest);
    }

    @PostMapping("/add-Permission")
    public @ResponseBody Response addPermission(@RequestBody AddPermissionForUserOnItemRequest permission) {
        return itemWUserPermissionService.addOperationForUserOnItem(permission);
    }

    //
//    @PutMapping("/modify-space")
//    public @ResponseBody Response modifySpace(){
//        return null;
//    }
//    @PutMapping("/modify-folder")
//    public @ResponseBody Response modifyFolder(){
//        return null;
//    }
//    @PutMapping("/modify-file")
//    public @ResponseBody Response modifyFile(){
//        return null;
//    }
//    @GetMapping("/view-space")
//    public @ResponseBody Response viewSpace(){
//        return null;
//    }
//    @GetMapping("/view-folder")
//    public @ResponseBody Response viewFolder(){
//        return null;
//    }
//    @GetMapping("/view-file")
//    public @ResponseBody Response viewFile(){
//        return null;
//    }
//
//    @PostMapping("/save-user")
//    public @ResponseBody Response saveUser(){
//        return null;
//    }
//
    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authenticationHeader = request.getHeader("AUTHORIZATION");
        if (authenticationHeader != null && authenticationHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authenticationHeader.substring("Bearer ".length());

                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refreshToken);
                String userName = decodedJWT.getSubject();
                ServiceUser user = userService.getUser(userName);
                String accessToken = JWT.create().
                        withSubject(user.getUserEmail()).
                        withIssuer(request.getRequestURI().toString()).
                        withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 10000)).
                        withClaim("roles", user.getRoles().stream().map(AppRole::getName).collect(Collectors.toList())).
                        sign(algorithm);


                Map<String, String> tokens = new HashMap<>();
                tokens.put("accessToken", accessToken);
                tokens.put("refreshToken", refreshToken);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception ex) {
                log.error("Error loading in {}", ex.getMessage());
                response.setHeader("error", ex.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error-message", ex.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing ");
        }
    }
}
