package com.alzain.stcAssessment.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table
public class MetaData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    @Enumerated(EnumType.STRING)
    private ItemType type ;

    @Column(name = "name", columnDefinition = "VARCHAR(60) NOT NULL")
    private String name ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "space", insertable = false, updatable = false),
            @JoinColumn(name = "folder", insertable = false, updatable = false),
            @JoinColumn(name = "file", insertable = false, updatable = false)
    })
    private Item itemId ;


//    private long permissionGroupId ;

}
