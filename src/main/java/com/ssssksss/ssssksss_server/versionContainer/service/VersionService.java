package com.ssssksss.ssssksss_server.versionContainer.service;

import com.ssssksss.ssssksss_server.versionContainer.dao.VersionDao;
import com.ssssksss.ssssksss_server.versionContainer.dto.VersionDto;
import com.ssssksss.ssssksss_server.versionContainer.repository.VersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VersionService {
    private final VersionRepository versionRepository;

    public ResponseEntity getVersion(String name) {
        Optional<VersionDao> versionDao = versionRepository.findByName(name);
        return ResponseEntity.ok()
                .body(new VersionDto(versionDao.get().getName(),versionDao.get().getUpdateDate()));

    }
}
