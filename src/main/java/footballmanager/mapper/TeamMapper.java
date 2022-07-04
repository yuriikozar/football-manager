package footballmanager.mapper;

import footballmanager.dto.request.TeamRequestDto;
import footballmanager.dto.response.TeamResponseDto;
import footballmanager.model.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {
    public Team mapToModel(TeamRequestDto dto) {
        Team team = new Team();
        team.setCommission(dto.getCommission());
        team.setName(dto.getName());
        team.setBank(dto.getBank());
        return team;
    }

    public TeamResponseDto mapToDto(Team team) {
        TeamResponseDto dto = new TeamResponseDto();
        dto.setId(team.getId());
        dto.setCommission(team.getCommission());
        dto.setBank(team.getBank());
        dto.setName(team.getName());
        return dto;
    }
}
