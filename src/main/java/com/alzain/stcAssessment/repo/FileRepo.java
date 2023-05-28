package com.alzain.stcAssessment.repo;

import com.alzain.stcAssessment.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<Files, Long> {


}
