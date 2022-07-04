package footballmanager.service.impl;

import footballmanager.model.Team;
import footballmanager.repository.TeamRepository;
import footballmanager.service.TeamService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team add(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team get(Long id) {
        return teamRepository.getReferenceById(id);
    }

    @Override
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team update(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void delete(Long id) {
        teamRepository.delete(teamRepository.getReferenceById(id));
    }
}
