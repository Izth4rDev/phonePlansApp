package globant.talentodigital.empresatelefonica.restempresatelefonica.service.imp;

import globant.talentodigital.empresatelefonica.restempresatelefonica.dto.PlanDto;
import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Plan;
import globant.talentodigital.empresatelefonica.restempresatelefonica.repository.IPlanRepository;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IBaseDtoService;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IMapperDTO;
import globant.talentodigital.empresatelefonica.restempresatelefonica.service.IUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class PlanServiceImp implements IBaseDtoService<PlanDto>, IUpdateService<PlanDto> {

    private final IPlanRepository planRepository;
    private final IMapperDTO<Plan, PlanDto> mapper;

    @Override
    public List<PlanDto> getAllDtos() {
        return  mapper.toDtos(planRepository.findAll());
    }

    @Override
    public PlanDto getDtoById(Long id) {
        return mapper.toDto(planRepository.findById(id).orElseThrow(()-> new RuntimeException("Plan not found")));
    }

    @Transactional
    @Override
    public PlanDto updateStatus(Long id, Boolean isActive) {

        Plan plan = planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan not found"));
        plan.setIsActive(isActive);
        planRepository.save(plan);

        return mapper.toDto(plan);

    }
}
