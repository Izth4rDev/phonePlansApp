package globant.talentodigital.empresatelefonica.restempresatelefonica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContractRequestDto {
   private Long idClient;
   private Long idPlan;
   private LocalDate startDate;
   private LocalDate endDate;
}
