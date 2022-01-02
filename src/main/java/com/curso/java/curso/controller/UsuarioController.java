package com.curso.java.curso.controller;

import com.curso.java.curso.dao.UsuarioDao;
import com.curso.java.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
