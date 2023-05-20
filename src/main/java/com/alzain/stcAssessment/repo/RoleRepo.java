package com.alzain.stcAssessment.repo;

import com.alzain.stcAssessment.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<AppRole,Long> {
    AppRole findByName(String name);
}
