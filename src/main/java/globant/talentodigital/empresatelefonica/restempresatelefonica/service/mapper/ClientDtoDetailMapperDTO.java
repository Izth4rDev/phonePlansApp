package globant.talentodigital.empresatelefonica.restempresatelefonica.service.mapper;

import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ClientDtoDetails;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Client;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientDtoDetailMapperDTO implements IMapperDTO<Client, ClientDtoDetails> {
    @Override
    public ClientDtoDetails toDto(Client entity) {

        ClientDtoDetails dto = new ClientDtoDetails();
        dto.setName(entity.getName());
        dto.setRut(entity.getRut());
        dto.setAddress(entity.getAddress());
        dto.setBirthDate(entity.getBirthDate());
        dto.setIsActive(entity.getIsActive());
        dto.setPlanDtoDetailList(entity.getContracts().stream().map(contract -> {

            ClientDtoDetails.PlanDtoDetail planDtoDetail = new ClientDtoDetails.PlanDtoDetail();
            planDtoDetail.setPlanName(contract.getPlan().getPlanName());
            planDtoDetail.setPlanPrice(contract.getPlan().getPrice());
            planDtoDetail.setPlanIsActive(contract.getPlan().getIsActive());
            planDtoDetail.setServiceProvided(contract.getPlan().getServiceProvided());
            planDtoDetail.setContractStartDate(contract.getStartDate());
            planDtoDetail.setContractEndDate(contract.getEndDate());

            return planDtoDetail;

        }).toList());

        return dto;
    }

    @Override
    public List<ClientDtoDetails> toDtos(List<Client> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}
