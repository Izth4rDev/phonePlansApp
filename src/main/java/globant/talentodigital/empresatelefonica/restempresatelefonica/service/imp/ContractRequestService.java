package globant.talentodigital.empresatelefonica.restempresatelefonica.service.imp;

import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ContractDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.ContractRequestDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Contract;
import globant.talentodigital.empresatelefonica.restempresatelefonica.repository.IContractRepository;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IBaseDtoService;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperDTO;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperEntity;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ContractRequestService implements ITransactionService<ContractRequestDto>, IBaseDtoService<ContractDto> {

    private final IContractRepository contractRepository;
    private final IMapperDTO<Contract, ContractDto> mapperToDto;
    private final IMapperEntity<Contract,ContractRequestDto> mapperToEntity;

    @Override
    @Transactional
    public ContractRequestDto create(ContractRequestDto entity) {
        Contract contract = mapperToEntity.toEntity(entity);
        contractRepository.save(contract);
        return entity;
    }

    @Override
    public List<ContractDto> getAllDtos() {
        return mapperToDto.toDtos(contractRepository.findAll());
    }

    @Override
    public ContractDto getDtoById(Long id) {
        return null;
    }
}
