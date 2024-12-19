package globant.talentodigital.empresatelefonica.restempresatelefonica.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContractDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private double originalPrice;
    private double discountedPrice;
}
