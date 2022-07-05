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
        Team realMadrid = new Team();
        realMadrid.setBank(BigDecimal.valueOf(100000000));
        realMadrid.setCommission(10);
        realMadrid.setName("Real Madrid");
        teamService.add(realMadrid);

        Team barcelona = new Team();
        barcelona.setBank(BigDecimal.valueOf(1000000));
        barcelona.setCommission(5);
        barcelona.setName("Barcelona");
        teamService.add(barcelona);

        Team karpaty = new Team();
        karpaty.setCommission(7);
        karpaty.setBank(BigDecimal.valueOf(1500000));
        karpaty.setName("Karpary Lviv");
        teamService.add(karpaty);


        Player ronaldo = new Player();
        ronaldo.setAge(37);
        ronaldo.setExperience(264);
        ronaldo.setTeam(realMadrid);
        ronaldo.setName("Cristiano Ronaldo");
        playerService.add(ronaldo);

        Player messi = new Player();
        messi.setTeam(barcelona);
        messi.setAge(35);
        messi.setExperience(220);
        messi.setName("Lionel Messi");
        playerService.add(messi);


    }
}
