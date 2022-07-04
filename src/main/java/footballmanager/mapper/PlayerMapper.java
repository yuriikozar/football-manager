package footballmanager.mapper;

import footballmanager.dto.request.PlayerRequestDto;
import footballmanager.dto.response.PlayerResponseDto;
import footballmanager.model.Player;
import footballmanager.service.TeamService;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    private final TeamService teamService;

    public PlayerMapper(TeamService teamService) {
        this.teamService = teamService;
    }

    public Player mapToModel(PlayerRequestDto dto) {
        Player player = new Player();
        player.setName(dto.getName());
        player.setTeam(teamService.get(dto.getTeamId()));
        player.setExperience(dto.getExperience());
        player.setAge(dto.getAge());
        return player;
    }

    public PlayerResponseDto mapToDto(Player player) {
        PlayerResponseDto dto = new PlayerResponseDto();
        dto.setId(player.getId());
        dto.setExperience(player.getExperience());
        dto.setTeamId(player.getTeam().getId());
        dto.setAge(player.getAge());
        dto.setName(player.getName());
        return dto;
    }
}
