package com.alzain.stcAssessment.repo;

import com.alzain.stcAssessment.entity.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceUserRepo extends JpaRepository<ServiceUser,Long> {
    ServiceUser findByUserEmail(String userName) ;
}