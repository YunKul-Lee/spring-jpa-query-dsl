package com.jake.querydsl.service.init;

import com.jake.querydsl.service.entity.Member;
import com.jake.querydsl.service.entity.Team;
import com.jake.querydsl.service.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final TeamRepository teamRepo;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Team firstTeam = new Team("First Team");
        firstTeam.addMember(new Member("Jay"));
        firstTeam.addMember(new Member("Steve"));
        firstTeam.addMember(new Member("Jun"));
        firstTeam.addMember(new Member("Joel"));

        Team secondTeam = new Team("Second Team");
        secondTeam.addMember(new Member("Ats"));
        secondTeam.addMember(new Member("Ken"));
        secondTeam.addMember(new Member("Yu"));

        teamRepo.saveAll(List.of(firstTeam, secondTeam));
    }
}
