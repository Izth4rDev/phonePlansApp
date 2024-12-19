package globant.talentodigital.empresatelefonica.restempresatelefonica.service.imp;
import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ClientDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Client;
import globant.talentodigital.empresatelefonica.restempresatelefonica.repository.IClientRepository;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceImpTest {

    @Mock
    private IClientRepository clientRepository;

    @Mock
    private IMapperDTO<Client, ClientDto> mapper;

    @InjectMocks
    private ClientServiceImp clientServiceImp;

   ClientDto clientDtoTest;
   Client clientTest;

    @BeforeEach
    public void setUp() {

        clientTest = new Client();
        clientTest.setId(10L);
        clientTest.setName("Test");
        clientTest.setRut("1111111-1");
        clientTest.setIsActive(true);
        clientTest.setAddress("Test avenue");

        clientDtoTest = new ClientDto();
         clientDtoTest.setName("Test");
         clientDtoTest.setRut("1111111-1");
         clientDtoTest.setBirthDate(LocalDate.of(1988,11,18));
         clientDtoTest.setIsActive(true);
         clientDtoTest.setAddress("Test avenue");

     }

    @Test
    public void getAllDtos(){

        //comportamiento del mock clientRepository
        when(clientRepository.findAll()).thenReturn(Collections.singletonList(clientTest));

        //comportamiento del mock mapper
        when(mapper.toDtos(Collections.singletonList(clientTest))).thenReturn(Collections.singletonList(clientDtoTest));

        List<ClientDto> clientDtos = clientServiceImp.getAllDtos();

        assertEquals(1, clientDtos.size(), "la lista debe tener un elemento");
        assertEquals("Test", clientDtos.get(0).getName());
    }

}