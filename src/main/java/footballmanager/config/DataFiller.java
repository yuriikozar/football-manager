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
        Team team = new Team();
        team.setBank(BigDecimal.valueOf(1000000));
        team.setCommission(10);
        team.setName("Real Madrid");
        teamService.add(team);

        Player player = new Player();
        player.setAge(33);
        player.setExperience(86);
        player.setTeam(team);
        player.setName("Runaldu");
        playerService.add(player);




    }
}
