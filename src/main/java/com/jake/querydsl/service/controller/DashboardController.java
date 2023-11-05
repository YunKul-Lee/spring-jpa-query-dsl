package com.jake.querydsl.service.controller;

import com.jake.querydsl.service.entity.Team;
import com.jake.querydsl.service.model.TeamResponse;
import com.jake.querydsl.service.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class DashboardController {

    private final TeamRepository teamRepo;

    @GetMapping("/v1/dashboard")
    public List<TeamResponse> dashboard1() {
        List<Team> all = teamRepo.findAllUsingJoinFetch();
        return all.stream()
                .map(team -> new TeamResponse(team.getId(), team.getName(), team.getMembers().size(), team.getMembers().size()))
                .collect(Collectors.toList());
    }

    @GetMapping("/v2/dashboard")
    public List<TeamResponse> dashboard2() {
        List<Team> all = teamRepo.findAll();
        return all.stream()
                .map(team -> new TeamResponse(team.getId(), team.getName(), team.getMembers().size(), team.getMembers().size()))
                .collect(Collectors.toList());
    }

    @GetMapping("/v3/dashboard")
    public Page<TeamResponse> dashboard3(Pageable pageable) {
        Page<Team> all = teamRepo.findAll(pageable);
        var content = all.stream()
                .map(team -> new TeamResponse(team.getId(), team.getName(), team.getMembers().size(), team.getMembers().size()))
                .collect(Collectors.toList());

        return new PageImpl<>(content, pageable, all.getTotalElements());
    }
}
