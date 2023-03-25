
package pe.com.cibertec.servicio;

import java.util.List;
import pe.com.cibertec.domain.Persona;


public interface PersonaService {
    
    public List<Persona> listarPersonas();
    
    public void guardar(Persona persona);
    
    public void eliminar (Persona persona);
    
    public Persona encontrarPersona(Persona persona);
    
}
