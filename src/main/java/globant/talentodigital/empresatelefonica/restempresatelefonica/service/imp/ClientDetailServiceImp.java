package globant.talentodigital.empresatelefonica.restempresatelefonica.service.imp;

import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ClientDtoDetails;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Client;
import globant.talentodigital.empresatelefonica.restempresatelefonica.repository.IClientRepository;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IBaseDtoService;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientDetailServiceImp implements IBaseDtoService<ClientDtoDetails> {

    private final IClientRepository clientRepository;
    private final IMapperDTO<Client, ClientDtoDetails> clientDtoMapper;

    @Override
    public List<ClientDtoDetails> getAllDtos() {
        return clientDtoMapper.toDtos(clientRepository.findAll());
    }

    @Override
    public ClientDtoDetails getDtoById(Long id) {
        return clientDtoMapper.toDto(clientRepository.findById(id).get());
    }
}
