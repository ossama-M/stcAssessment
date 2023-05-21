package com.alzain.stcAssessment.repo;

import com.alzain.stcAssessment.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item,String> {
    List<Item> getAllByItemId(Item item);

}
