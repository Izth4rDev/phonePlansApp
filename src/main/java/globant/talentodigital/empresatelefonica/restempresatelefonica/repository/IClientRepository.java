package globant.talentodigital.empresatelefonica.restempresatelefonica.repository;

import globant.talentodigital.empresatelefonica.restempresatelefonica.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
}
