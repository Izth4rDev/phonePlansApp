package globant.talentodigital.empresatelefonica.restempresatelefonica.service;

import java.util.List;

public interface IMapperDTO<E , D> {
    D toDto (E entity);
    List<D> toDtos (List<E> entities);
}
