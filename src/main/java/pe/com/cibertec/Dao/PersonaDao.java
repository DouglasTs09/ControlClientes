
package pe.com.cibertec.Dao;

import org.springframework.data.repository.CrudRepository;
import pe.com.cibertec.domain.Persona;


public interface PersonaDao extends CrudRepository<Persona, Long>{
    
}
