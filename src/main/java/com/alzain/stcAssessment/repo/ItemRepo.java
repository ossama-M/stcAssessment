package com.alzain.stcAssessment.repo;

import com.alzain.stcAssessment.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,String> {

}
