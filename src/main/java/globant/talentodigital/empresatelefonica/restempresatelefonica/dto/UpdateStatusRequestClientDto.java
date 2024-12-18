package globant.talentodigital.empresatelefonica.restempresatelefonica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateStatusRequestClientDto {
    private Boolean isActive;
}