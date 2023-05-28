package com.alzain.stcAssessment.repo;

import com.alzain.stcAssessment.entity.Item;
import com.alzain.stcAssessment.entity.ItemWUserPermission;
import com.alzain.stcAssessment.entity.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemWUserPermissionRepo extends JpaRepository<ItemWUserPermission, Long> {
    Optional<List<ItemWUserPermission>> findItemWUserPermissionByUserAndItem(ServiceUser userService, Item item);
}
