package globant.talentodigital.empresatelefonica.restempresatelefonica.service.mapper;

import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ClientDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Client;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientDtoMapperDTO implements IMapperDTO<Client, ClientDto> {

    @Override
    public ClientDto toDto(Client entity) {

        if(entity == null) return null;

        ClientDto dto = new ClientDto();
        dto.setName(entity.getName());
        dto.setIsActive(entity.getIsActive());
        dto.setRut(entity.getRut());
        dto.setAddress(entity.getAddress());
        dto.setBirthDate(entity.getBirthDate());

        return dto;
    }

    @Override
    public List<ClientDto> toDtos(List<Client> entities) {

        if(entities == null) return List.of();

        return entities.stream().map(this::toDto).toList();
    }
}

