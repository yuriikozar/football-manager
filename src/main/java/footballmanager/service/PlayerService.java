package footballmanager.service;

import footballmanager.model.Player;
import java.util.List;

public interface PlayerService {
    Player add(Player player);

    Player get(Long id);

    List<Player> getAll();

    Player update(Player player);

    void delete(Long id);
}
