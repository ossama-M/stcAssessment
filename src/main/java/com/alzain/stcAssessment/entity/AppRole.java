package com.alzain.stcAssessment.entity;

import lombok.*;

import javax.persistence.*;

@Entity
//@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String name;

}
