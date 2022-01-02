package com.curso.java.curso.controller;

import com.curso.java.curso.dao.UsuarioDao;
import com.curso.java.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id){

        Usuario user = new Usuario();

        user.setId(id);
        user.setNombre("Fran");
        user.setApellido("dsfds");
        user.setEmail("fran@test.com");
        user.setPassword("pass");
        user.setTelefono("6574332121");

        return user;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }


    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        String hash = argon2.hash(1,1024,1,usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "usuarioasd")
    public Usuario editar(){

        Usuario user = new Usuario();

        user.setNombre("Fran");
        user.setApellido("dsfds");
        user.setEmail("fran@test.com");
        user.setPassword("pass");
        user.setTelefono("6574332121");

        return user;
    }
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminar(id);
    }

    @RequestMapping(value = "usuario234")
    public Usuario buscar(){

        Usuario user = new Usuario();

        user.setNombre("Fran");
        user.setApellido("dsfds");
        user.setEmail("fran@test.com");
        user.setPassword("pass");
        user.setTelefono("6574332121");

        return user;
    }
}
