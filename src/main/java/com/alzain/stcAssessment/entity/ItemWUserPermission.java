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
public class ItemWUserPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id  ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private ServiceUser user ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "space", insertable = false, updatable = false),
            @JoinColumn(name = "folder", insertable = false, updatable = false),
            @JoinColumn(name = "file", insertable = false, updatable = false)
    })
    private Item item ;

    @Enumerated(EnumType.STRING)
    private PermissionLevel operation ;



}
