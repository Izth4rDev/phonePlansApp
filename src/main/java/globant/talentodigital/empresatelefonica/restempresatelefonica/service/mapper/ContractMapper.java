package globant.talentodigital.empresatelefonica.restempresatelefonica.service.mapper;

import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ContractDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ContractRequestDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Client;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Contract;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Plan;
import globant.talentodigital.empresatelefonica.restempresatelefonica.repository.IClientRepository;
import globant.talentodigital.empresatelefonica.restempresatelefonica.repository.IPlanRepository;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperDTO;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ContractMapper implements IMapperDTO<Contract, ContractDto>, IMapperEntity<Contract, ContractRequestDto>{

    private final IClientRepository clientRepository;
    private final IPlanRepository planRepository;

    @Override
    public ContractDto toDto(Contract entity) {

        double originalPrice = entity.getPlan().getPrice();
        double discountedPrice = originalPrice;

        // Calcular descuento
        if (entity.getClient().getContracts().size() > 1) {
            discountedPrice = originalPrice - (originalPrice * 0.10); // Aplicar 10% de descuento
        }

        ContractDto dto = new ContractDto();
        dto.setEndDate(entity.getEndDate());
        dto.setStartDate(entity.getStartDate());
        dto.setOriginalPrice(originalPrice);
        dto.setDiscountedPrice(discountedPrice);

        return dto;
    }

    @Override
    public List<ContractDto> toDtos(List<Contract> entities) {
        return entities.stream().map(this::toDto).toList() ;
    }

    @Override
    public Contract toEntity(ContractRequestDto dto) {
        Contract entity = new Contract();

        //Obtener client para setear el Request contract
        Client client = clientRepository.findById(dto.getIdClient())
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + dto.getIdClient()));

        //Obtener el plan para setear el Request contract
        Plan plan = planRepository.findById(dto.getIdPlan()).orElseThrow(() ->
                new RuntimeException("Plan not found with ID: " + dto.getIdPlan()));

        //seteo de la entity
        entity.setClient(client);
        entity.setPlan(plan);
        entity.setEndDate(dto.getEndDate());
        entity.setStartDate(dto.getStartDate());

        return entity;
    }
}
