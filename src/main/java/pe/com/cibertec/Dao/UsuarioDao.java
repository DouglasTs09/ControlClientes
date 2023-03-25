/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.cibertec.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.cibertec.domain.Usuario;

/**
 *
 * @author jaimePC
 */
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByUsername ( String username );
}
