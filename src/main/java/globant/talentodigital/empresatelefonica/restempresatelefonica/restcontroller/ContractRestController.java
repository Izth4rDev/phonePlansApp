package globant.talentodigital.empresatelefonica.restempresatelefonica.restcontroller;

import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ContractDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ContractRequestDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IBaseDtoService;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/contracts")
public class ContractRestController {

    private final ITransactionService<ContractRequestDto> transactionService;
    private final IBaseDtoService<ContractDto> baseDtoService;

    @GetMapping
    public ResponseEntity<List<ContractDto>> getContracts() {
        return ResponseEntity.ok(baseDtoService.getAllDtos());
    }

    @PostMapping
    public ResponseEntity<ContractRequestDto> createContract(@RequestBody ContractRequestDto contractRequestDto ) {
        return ResponseEntity.ok(transactionService.create(contractRequestDto));
    }
}
