package com.alzain.stcAssessment.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "files")
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    @Lob
    @Column(name = "file_Binary",length = 1000)
    private byte[] fileBinary;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "space", insertable = false, updatable = false),
            @JoinColumn(name = "folder", insertable = false, updatable = false),
            @JoinColumn(name = "file", insertable = false, updatable = false)
    })
    private Item item;
}
