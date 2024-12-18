package globant.talentodigital.empresatelefonica.restempresatelefonica.service.mapper;

import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.PlanDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Plan;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanDtoMapperDTO implements IMapperDTO<Plan,PlanDto> {

    @Override
    public PlanDto toDto(Plan entity) {

        PlanDto dto = new PlanDto();
        dto.setPrice(entity.getPrice());
        dto.setPlanName(entity.getPlanName());
        dto.setIsActive(entity.getIsActive());
        dto.setServiceProvided(entity.getServiceProvided());

        return dto;
    }

    @Override
    public List<PlanDto> toDtos(List<Plan> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}
