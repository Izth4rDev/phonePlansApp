package globant.talentodigital.empresatelefonica.restempresatelefonica.service;

public interface IUpdateService<D> {
   D updateStatus(Long id, Boolean isActive);
}
