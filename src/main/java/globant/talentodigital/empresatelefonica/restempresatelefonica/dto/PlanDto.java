package globant.talentodigital.empresatelefonica.restempresatelefonica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlanDto {
    private String planName;
    private double price;
    private Boolean isActive;
    private String serviceProvided;
}
