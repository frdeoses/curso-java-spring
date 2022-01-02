package com.curso.java.curso.dao;

import com.curso.java.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    public List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    boolean verificarEmailPassword(Usuario usuario);
}
