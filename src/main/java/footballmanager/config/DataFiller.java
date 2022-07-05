package footballmanager.config;

import footballmanager.model.Player;
import footballmanager.model.Team;
import footballmanager.service.PlayerService;
import footballmanager.service.TeamService;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataFiller {
    private final PlayerService playerService;
    private final TeamService teamService;

    public DataFiller(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }


    @PostConstruct
    public void inject() {
        Team real = new Team();
        real.setBank(BigDecimal.valueOf(100000000));
        real.setCommission(10);
        real.setName("Real Madrid");
        teamService.add(real);

        Team barcelona = new Team();
        barcelona.setBank(BigDecimal.valueOf(1000000));
        barcelona.setCommission(5);
        barcelona.setName("Barcelona");
        teamService.add(barcelona);

        Player player = new Player();
        player.setAge(33);
        player.setExperience(86);
        player.setTeam(real);
        player.setName("Runaldu");
        playerService.add(player);




    }
}
