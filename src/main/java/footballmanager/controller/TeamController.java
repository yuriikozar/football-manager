package footballmanager.controller;

import footballmanager.dto.request.TeamRequestDto;
import footballmanager.dto.response.TeamResponseDto;
import footballmanager.mapper.TeamMapper;
import footballmanager.service.TeamService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public TeamResponseDto getById(@PathVariable Long id) {
        return teamMapper.mapToDto(teamService.get(id));
    }

    @GetMapping
    public List<TeamResponseDto> getAll() {
        return teamService.getAll().stream()
                .map(teamMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public TeamResponseDto addTeam(@RequestBody TeamRequestDto dto) {
        return teamMapper.mapToDto(teamService.add(teamMapper.mapToModel(dto)));
    }

    @PutMapping
    public TeamResponseDto update(@RequestBody TeamRequestDto dto) {
        return teamMapper.mapToDto(teamService.update(teamMapper.mapToModel(dto)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        teamService.delete(id);
    }
}
