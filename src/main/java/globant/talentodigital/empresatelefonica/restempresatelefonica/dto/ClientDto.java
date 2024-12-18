package globant.talentodigital.empresatelefonica.restempresatelefonica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ClientDto {
    private String name;
    private String rut;
    private String address;
    private Boolean isActive;
    private LocalDate birthDate;
}
