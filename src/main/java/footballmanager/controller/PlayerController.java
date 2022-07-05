package footballmanager.controller;

import footballmanager.dto.request.PlayerRequestDto;
import footballmanager.dto.response.PlayerResponseDto;
import footballmanager.mapper.PlayerMapper;
import footballmanager.model.Player;
import footballmanager.service.PlayerService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerMapper playerMapper;

    public PlayerController(PlayerService playerService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.playerMapper = playerMapper;
    }

    @GetMapping("/{id}")
    public PlayerResponseDto getById(@PathVariable Long id) {
        return playerMapper.mapToDto(playerService.get(id));
    }

    @PostMapping
    public PlayerResponseDto addPlayer(@RequestBody @Valid PlayerRequestDto dto) {
        return playerMapper.mapToDto(playerService.add(playerMapper.mapToModel(dto)));
    }

    @GetMapping
    public List<PlayerResponseDto> getPlayers() {
        return playerService.getAll().stream()
                .map(playerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }

    @PutMapping("/{id}")
    public PlayerResponseDto update(@PathVariable Long id,
                                    @RequestBody @Valid PlayerRequestDto dto) {
        Player player = playerMapper.mapToModel(dto);
        player.setId(id);
        return playerMapper.mapToDto(playerService.update(player));
    }

}
