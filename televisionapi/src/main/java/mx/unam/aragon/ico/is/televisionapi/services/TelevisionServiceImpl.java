package mx.unam.aragon.ico.is.televisionapi.services;

import mx.unam.aragon.ico.is.televisionapi.entities.Television;
import mx.unam.aragon.ico.is.televisionapi.repositories.TelevisionRepository;
import mx.unam.aragon.ico.is.televisionapi.services.Interfaces.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelevisionServiceImpl implements TelevisionService {

    @Autowired
    private TelevisionRepository televisionRepository;

    @Override
    public Television crear(Television television) {
        return televisionRepository.save(television);
    }

    @Override
    public Iterable<Television> listarTodas() {
        return televisionRepository.findAll();
    }

    @Override
    public Optional<Television> buscarPorId(Long clave) {
        return televisionRepository.findById(clave);
    }

    @Override
    public Television actualizar(Long clave, Television television) {
        Optional<Television> televisionActual = televisionRepository.findById(clave);
        if(televisionActual.isPresent()){
            Television tmp = televisionActual.get();

            tmp.setClave(television.getClave());
            tmp.setModelo(television.getModelo());
            tmp.setMarca(television.getMarca());
            tmp.setFoto(television.getFoto());
            tmp.setPrecio(television.getPrecio());
            return televisionRepository.save(tmp);
        }else{
            return null;
        }
    }

    @Override
    public Television eliminar(Long clave) {
    /*    Television tmp = televisionRepository.findById(clave).orElse(null);
        if(tmp != null){
            televisionRepository.delete(tmp);
            return tmp;
        }else{
            return null;
        }

    }*/
        return televisionRepository.deleteByClave(clave);
    }
}
