package com.ssssksss.ssssksss_server.versionContainer.repository;

import com.ssssksss.ssssksss_server.versionContainer.dao.VersionDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VersionRepository extends JpaRepository<VersionDao,Long> {
    Optional<VersionDao> findByName(String name);
}