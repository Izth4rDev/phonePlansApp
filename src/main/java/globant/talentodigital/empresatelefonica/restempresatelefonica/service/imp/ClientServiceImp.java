package globant.talentodigital.empresatelefonica.restempresatelefonica.service.imp;

import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ClientDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Client;
import globant.talentodigital.empresatelefonica.restempresatelefonica.repository.IClientRepository;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IBaseDtoService;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperDTO;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.ITransactionService;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IUpdateService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service("clientService")
public class ClientServiceImp implements IBaseDtoService<ClientDto>, IUpdateService<ClientDto> {

    private final IClientRepository clientRepository;
    private final IMapperDTO<Client, ClientDto> clientDtoMapper;

    @Override
    public List<ClientDto> getAllDtos() {
        return clientDtoMapper.toDtos(clientRepository.findAll());
    }

    @Override
    public ClientDto getDtoById(Long id) {
        return clientDtoMapper.toDto(clientRepository.findById(id).get());
    }

    @Transactional
    @Override
    public ClientDto updateStatus(Long id, Boolean isActive) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));
        client.setIsActive(isActive);
        clientRepository.save(client);

        return clientDtoMapper.toDto(client);
    }

}
