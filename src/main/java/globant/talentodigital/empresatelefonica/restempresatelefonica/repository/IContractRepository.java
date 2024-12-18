package globant.talentodigital.empresatelefonica.restempresatelefonica.repository;

import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Long> {
}
