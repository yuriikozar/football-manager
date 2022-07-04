package footballmanager.service.impl;

import footballmanager.model.Player;
import footballmanager.repository.PlayerRepository;
import footballmanager.service.PlayerService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player add(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player get(Long id) {
        return playerRepository.getReferenceById(id);
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player update(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void delete(Long id) {
        playerRepository.delete(playerRepository.getReferenceById(id));
    }
}
