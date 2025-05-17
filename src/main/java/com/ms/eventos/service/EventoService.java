package com.ms.eventos.service;

import java.util.Optional;

import java.util.List; 
import com.ms.eventos.entities.Evento;

public interface EventoService {
    public boolean existeEvento(Long idEvento);   
    public Optional<Evento> obtenerPorId(Long id);    

    public List<Evento> listarTodos() ;
    public Evento guardar(Evento evento);
    public Evento actualizar(Long id, Evento eventoActualizado);
    public void eliminar(Long id);

}
