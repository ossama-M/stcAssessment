package com.alzain.stcAssessment.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table
public class ServiceUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String userEmail ;
    private String password ;

    @OneToMany(mappedBy = "user")
    List<ItemWUserPermission> userPermission = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles = new ArrayList<>();

}
