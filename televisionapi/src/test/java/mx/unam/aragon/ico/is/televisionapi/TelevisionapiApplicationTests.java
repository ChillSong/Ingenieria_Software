package mx.unam.aragon.ico.is.televisionapi;

import mx.unam.aragon.ico.is.televisionapi.entities.Television;
import mx.unam.aragon.ico.is.televisionapi.repositories.TelevisionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TelevisionapiApplicationTests {

	@Autowired
	private TelevisionRepository televisionRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void insertarTelevision() {
		Television television = new Television(0,"Sony", "tele_chida" , null , 10000.0f);
		televisionRepository.save(television);
	}

	@Test
	void leerTelevision() {
		Long claveTmp = 2l;
		televisionRepository.findTelevisionByClave(claveTmp);

		Television tmp = televisionRepository.findTelevisionByClave(claveTmp);
		System.out.println(tmp);
	}

	@Test
	void eliminarTelevision() {
		Long claveTmp = 2l;
		televisionRepository.deleteById(claveTmp);
	}

	@Test
	void actualizarTelevision() {
		Long claveTmp = 3l;
		Television tmp = televisionRepository.findTelevisionByClave(claveTmp);
		tmp.setModelo("patitoprecioso");
		televisionRepository.save(tmp);
	}

}
