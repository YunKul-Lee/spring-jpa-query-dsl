package com.jake.querydsl.service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime since;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @EqualsAndHashCode.Exclude
    private Team team;



    public Member(String name) {
        this.name = name;
        this.since = LocalDateTime.now();
    }
}
