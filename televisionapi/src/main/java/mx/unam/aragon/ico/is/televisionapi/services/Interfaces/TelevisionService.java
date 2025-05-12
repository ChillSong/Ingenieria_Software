package mx.unam.aragon.ico.is.televisionapi.services.Interfaces;

import mx.unam.aragon.ico.is.televisionapi.entities.Television;

import java.util.Optional;

public interface TelevisionService {
    public abstract Television crear(Television television);
    public abstract Iterable<Television> listarTodas();
    public abstract Optional<Television> buscarPorId(Long clave);
    public abstract Television actualizar(Long clave , Television television);
    public abstract Television eliminar(Long clave);

}
