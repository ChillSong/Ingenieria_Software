package mx.unam.aragon.ico.is.televisionapi.repositories;

import mx.unam.aragon.ico.is.televisionapi.entities.Television;
import org.springframework.data.repository.CrudRepository;

public interface TelevisionRepository extends CrudRepository<Television, Long> {

    public Television findTelevisionByClave(Long clave);
    public Television deleteByClave(Long clave);

}
