package footballmanager.service.impl;

import footballmanager.dto.request.Transfer;
import footballmanager.exception.DataProcessingException;
import footballmanager.model.Player;
import footballmanager.model.Team;
import footballmanager.service.PlayerService;
import footballmanager.service.TeamService;
import footballmanager.service.TransferService;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    private static final double DEFAULT_PRICE = 100000;
    private final TeamService teamService;
    private final PlayerService playerService;

    public TransferServiceImpl(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @Override
    public void doTransfer(Transfer transfer) {
        Team buyer = teamService.get(transfer.getBuyerId());
        Team seller = teamService.get(transfer.getSellerId());
        Player player = playerService.get(transfer.getPlayerId());
        BigDecimal priceOfTransfer = calculatePriceOfTransfer(player, seller.getCommission());
        if (priceOfTransfer.compareTo(seller.getBank()) > 0) {
            throw new DataProcessingException("Not enough money on " + seller + " bank");
        }
        player.setTeam(buyer);
        buyer.setBank(buyer.getBank().subtract(priceOfTransfer));
        seller.setBank(seller.getBank().add(priceOfTransfer));

        teamService.update(buyer);
        teamService.update(seller);
        playerService.update(player);
    }

    private BigDecimal calculatePriceOfTransfer(Player player, int commission) {
        MathContext mathContext = new MathContext(100);
        BigDecimal price = BigDecimal.valueOf(player.getExperience() * DEFAULT_PRICE)
                .divide(BigDecimal.valueOf(player.getAge()), mathContext);

        BigDecimal calculatedCommission = BigDecimal.valueOf((double) commission / 100).multiply(price);
        return price.add(calculatedCommission);
    }


}
