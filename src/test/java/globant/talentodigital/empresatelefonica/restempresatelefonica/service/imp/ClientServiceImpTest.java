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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
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
        assertEquals("Test", clientDtos.get(0).getName(), "el nombre debe ser test");
    }

    @Test
    public void getEmptyList(){

        when(clientRepository.findAll()).thenReturn(Collections.emptyList());
        when(mapper.toDtos(Collections.emptyList())).thenReturn(Collections.emptyList());

        List<ClientDto> clientDtos = clientServiceImp.getAllDtos();
        assertEquals(0,clientDtos.size(),"la lista debe estar vacia");
    }

    @Test
    public void getDtoById(){

        when(clientRepository.findById(10L)).thenReturn(java.util.Optional.of(clientTest));
        when(mapper.toDto(clientTest)).thenReturn(clientDtoTest);

        ClientDto clientDto = clientServiceImp.getDtoById(10L);
        assertEquals("Test",clientDto.getName(),"el nombre debe ser test");
    }

    @Test
    public void getNullDtoById(){
        when(clientRepository.findById(10L)).thenReturn(java.util.Optional.empty());

        ClientDto clientDto = clientServiceImp.getDtoById(10L);
        assertNull(clientDto, "el dto debe ser null");
    }

    @Test
    public void updateStatus(){
        //  Simula que el repositorio devuelve el cliente real
        when(clientRepository.findById(10L)).thenReturn(java.util.Optional.of(clientTest));

        //  Simula que al guardar el cliente simplemente se retorna el mismo objeto
        when(clientRepository.save(any(Client.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        //  Simula que el mapper construye un ClientDto basado en el Client actualizado
        when(mapper.toDto(any(Client.class)))
                .thenAnswer(invocation -> {
                    Client clientParam = invocation.getArgument(0);
                    ClientDto dto = new ClientDto();
                    dto.setName(clientParam.getName());
                    dto.setIsActive(clientParam.getIsActive());
                    dto.setRut(clientParam.getRut());
                    dto.setAddress(clientParam.getAddress());
                    dto.setBirthDate(clientParam.getBirthDate());
                    return dto;
                });

        ClientDto updatedDto = clientServiceImp.updateStatus(10L, false);

        //    -> Verificas que en el propio 'clientTest' se cambió el estado
        assertFalse(clientTest.getIsActive(), "El cliente debe tener isActive = false");

        //    -> Verificas que el DTO también muestre el estado actualizado
        assertFalse(updatedDto.getIsActive(), "El DTO debe reflejar el estado actualizado");
    }
}