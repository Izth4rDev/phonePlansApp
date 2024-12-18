package globant.talentodigital.empresatelefonica.restempresatelefonica.repository;

import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Long> {
}
