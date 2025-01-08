package globant.talentodigital.empresatelefonica.restempresatelefonica.service.imp;

import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ContractRequestDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Contract;
import globant.talentodigital.empresatelefonica.restempresatelefonica.repository.IContractRepository;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ContractRequestServiceTest {

    @Mock
    private IContractRepository contractRepository;

    @Mock
    private IMapperEntity<Contract, ContractRequestDto> mapperToEntity;

    @InjectMocks
    private ContractRequestService contractRequestService;

    @Test
    void createShouldSaveAndReturnSameDto() {
        // dto de prueba
        ContractRequestDto contractRequestDto = new ContractRequestDto();
        contractRequestDto.setIdClient(123L);
        contractRequestDto.setIdPlan(456L);
        contractRequestDto.setStartDate(LocalDate.of(2024, 1, 10));
        contractRequestDto.setEndDate(LocalDate.of(2024, 12, 31));

        //entidad Contract simulada
        Contract contract = new Contract();
        contract.setStartDate(LocalDate.of(2024, 1, 10));
        contract.setEndDate(LocalDate.of(2024, 12, 31));

        when(mapperToEntity.toEntity(contractRequestDto)).thenReturn(contract);
        when(contractRepository.save(contract)).thenReturn(contract);


        ContractRequestDto result = contractRequestService.create(contractRequestDto);

        assertEquals(contractRequestDto, result);
        verify(contractRepository).save(contract);
        verify(mapperToEntity).toEntity(contractRequestDto);
    }
}