package globant.talentodigital.empresatelefonica.restempresatelefonica.restcontroller;


import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.PlanDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IBaseDtoService;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/plan")
public class PlanRestController {

    private final IBaseDtoService<PlanDto> planService;
    private final IUpdateService<PlanDto> planUpdateService;

    @GetMapping
    public ResponseEntity<List<PlanDto>> getPlan() {
        return ResponseEntity.ok(planService.getAllDtos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanDto> getPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(planService.getDtoById(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PlanDto> updatePlanStatus(@PathVariable Long id, @RequestParam Boolean status) {
        return ResponseEntity.ok(planUpdateService.updateStatus(id, status));
    }
}
