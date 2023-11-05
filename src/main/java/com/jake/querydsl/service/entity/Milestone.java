package com.jake.querydsl.service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "milestones")
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime celebratedAt;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @EqualsAndHashCode.Exclude
    private Team team;

    public Milestone(String name) {
        this.name = name;
        this.celebratedAt = LocalDateTime.now();
    }
}
