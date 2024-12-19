package globant.talentodigital.empresatelefonica.restempresatelefonica.service.imp;
import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ClientDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ContractDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Client;
import globant.talentodigital.empresatelefonica.restempresatelefonica.repository.IClientRepository;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClientServiceImpTest {

    @Mock
    private IClientRepository clientRepository;

    @Mock
    private IMapperDTO<Client, ClientDto> mapper;

    @InjectMocks
    private ClientServiceImp clientServiceImp;

    ContractDto contractDto;

    @BeforeEach
    public void setUp() {

        contractDto = new ContractDto("");
    }

    @Test
    public void getAllDtos(){

    }

}