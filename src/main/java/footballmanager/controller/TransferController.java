package footballmanager.controller;

import footballmanager.dto.request.Transfer;
import footballmanager.service.TransferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public String doTransfer(@RequestBody Transfer transfer) {
        transferService.doTransfer(transfer);
        return "Vsim pryvit:)";
    }
}
