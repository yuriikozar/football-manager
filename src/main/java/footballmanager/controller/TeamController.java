package footballmanager.controller;

import footballmanager.dto.request.TeamRequestDto;
import footballmanager.dto.response.TeamResponseDto;
import footballmanager.mapper.TeamMapper;
import footballmanager.model.Team;
import footballmanager.service.TeamService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;
    private final TeamMapper teamMapper;

    public TeamController(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeamResponseDto getById(@PathVariable Long id) {
        return teamMapper.mapToDto(teamService.get(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeamResponseDto> getAll() {
        return teamService.getAll().stream()
                .map(teamMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamResponseDto addTeam(@RequestBody @Valid TeamRequestDto dto) {
        return teamMapper.mapToDto(teamService.add(teamMapper.mapToModel(dto)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeamResponseDto update(@PathVariable Long id,
                                  @RequestBody @Valid TeamRequestDto dto) {
        Team team = teamMapper.mapToModel(dto);
        team.setId(id);
        return teamMapper.mapToDto(teamService.update(team));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        teamService.delete(id);
    }
}
