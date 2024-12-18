package globant.talentodigital.empresatelefonica.restempresatelefonica.service;

public interface IMapperEntity<E , D> {
    E toEntity(D dto);
}
