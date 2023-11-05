package com.jake.querydsl.service.controller;

import com.jake.querydsl.service.model.MemberResponse;
import com.jake.querydsl.service.repository.DefaultTeamQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class TeamController {

    private final DefaultTeamQueryRepository query;

    @GetMapping("/v1/teams/{teamId}/members")
    public List<MemberResponse> members(@PathVariable long teamId) {
        return query.findMemberByTeamId(teamId);
    }

    @GetMapping("/v2/teams/{teamId}/members")
    public List<MemberResponse> searchMembers(@PathVariable long teamId, @RequestParam(required = false) String searchText) {
        return query.searchMembersByTeamId(teamId, searchText);
    }

    public Page<MemberResponse> paginatedMembers(Pageable pageable) {
        return query.members(pageable);
    }
}
