package com.jake.querydsl.service.model;

public record TeamResponse(
        long id,
        String name,
        long memberCount,
        long milestoneCount
) {
}
