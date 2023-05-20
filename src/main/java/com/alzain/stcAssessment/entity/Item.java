package com.alzain.stcAssessment.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table

public class Item {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "space", column = @Column(name = "space", nullable = false))
            ,
            @AttributeOverride(name = "folder", column = @Column(name = "folder"))
            ,
            @AttributeOverride(name = "file", column = @Column(name = "file"))})
    private ItemId itemId ;

    @Enumerated(EnumType.STRING)
    private ItemType type ;

    @OneToOne(mappedBy = "itemId")
    private MetaData metaDataId ;

    @OneToMany(mappedBy = "item")
    List<ItemWUserPermission> ItemUser = new ArrayList<>();


}
