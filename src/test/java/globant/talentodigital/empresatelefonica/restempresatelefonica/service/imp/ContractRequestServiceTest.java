package globant.talentodigital.empresatelefonica.restempresatelefonica.service.imp;

import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ContractDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ContractRequestDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Contract;
import globant.talentodigital.empresatelefonica.restempresatelefonica.repository.IContractRepository;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperDTO;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ContractRequestServiceTest {

    @Mock
    private IContractRepository contractRepository;

    @Mock
    private IMapperEntity<Contract, ContractRequestDto> mapperToEntity;

    @Mock
    //private IMapperDTO<ContractDto, Contract> mapperToDTO;
    private IMapperDTO<Contract, ContractDto> mapperToDTO;
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

    @Test
    void getAllShouldReturnAllDto(){
        Contract contract1 = new Contract();
        contract1.setStartDate(LocalDate.of(2024, 1, 10));
        contract1.setEndDate(LocalDate.of(2024, 12, 31));
        Contract contract2 = new Contract();
        contract2.setStartDate(LocalDate.of(2024, 1, 10));
        contract2.setEndDate(LocalDate.of(2024, 12, 31));
        List<Contract> contracts = Arrays.asList(contract1, contract2);

        ContractDto contractDto1 = new ContractDto();
        contractDto1.setEndDate(LocalDate.of(2024, 1, 10));
        contractDto1.setStartDate(LocalDate.of(2024, 12, 31));
        ContractDto contractDto2 = new ContractDto();
        contractDto2.setEndDate(LocalDate.of(2024, 1, 10));
        contractDto2.setStartDate(LocalDate.of(2024, 12, 31));
        List<ContractDto> contractDtos = Arrays.asList(contractDto1, contractDto2);

        when(contractRepository.findAll()).thenReturn(contracts);
        when(mapperToDTO.toDtos(contracts)).thenReturn(contractDtos);

        List<ContractDto> result = contractRequestService.getAllDtos();
        assertEquals(contractDtos, result);

    }
}