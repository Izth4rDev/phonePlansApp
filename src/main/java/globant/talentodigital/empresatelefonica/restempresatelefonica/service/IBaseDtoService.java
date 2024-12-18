package globant.talentodigital.empresatelefonica.restempresatelefonica.service;

import java.util.List;

public interface IBaseDtoService<D> {
    List<D> getAllDtos();
    D getDtoById(Long id);
}
