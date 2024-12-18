package globant.talentodigital.empresatelefonica.restempresatelefonica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDtoDetails {
    private String name;
    private String rut;
    private String address;
    private Boolean isActive;
    private LocalDate birthDate;

    private List<PlanDtoDetail> planDtoDetailList;

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        public static class PlanDtoDetail {
            private String planName;
            private double planPrice;
            private Boolean planIsActive;
            private String serviceProvided;
            private LocalDate contractStartDate;
            private LocalDate contractEndDate;
        }
}
