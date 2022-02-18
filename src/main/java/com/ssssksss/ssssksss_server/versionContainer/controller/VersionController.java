package com.ssssksss.ssssksss_server.versionContainer.controller;

import com.ssssksss.ssssksss_server.versionContainer.service.VersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VersionController {

    private final VersionService versionService;

    @RequestMapping(value="/ssssksss/version", method= RequestMethod.GET)
    public ResponseEntity getVersion(String name) {
        return versionService.getVersion(name);
    }
}
