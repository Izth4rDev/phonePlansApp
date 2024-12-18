package globant.talentodigital.empresatelefonica.restempresatelefonica.restcontroller;

import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ClientDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ClientDtoDetails;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IBaseDtoService;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/client")
public class ClientRestController {

   private final IBaseDtoService<ClientDto> baseDtoService;
   private final IBaseDtoService<ClientDtoDetails> baseDtoDetailsService;
   private final IUpdateService<ClientDto> updateService;

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClient() {
        return ResponseEntity.ok(baseDtoService.getAllDtos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDtoDetails> getClientDetails(@PathVariable Long id) {
        return ResponseEntity.ok(baseDtoDetailsService.getDtoById(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ClientDto> updateClientStatus(@PathVariable Long id, @RequestParam Boolean status) {
        return ResponseEntity.ok(updateService.updateStatus(id, status));
    }
}
