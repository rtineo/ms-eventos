package com.ms.eventos.service;

import com.ms.eventos.repository.EventoRepository;
import com.ms.eventos.entities.Evento;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List; 
@Service
public class EventoServiceImpl implements EventoService {
    
    private final EventoRepository eventoRepository;

    public EventoServiceImpl(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    public boolean existeEvento(Long idEvento){
        boolean existe = false;
        Optional<Evento> event = eventoRepository.findById(idEvento);
        
        if(event!=null){
            existe = true;
        }

        return existe;
    }

    @Override
    public Optional<Evento> obtenerPorId(Long id){
        return eventoRepository.findById(id);
    }

    @Override
	public List<Evento> listarTodos() {
		return eventoRepository.findAll();
	}

    @Override
	public Evento guardar(Evento evento) {
		if (eventoRepository.existsByDescripcion(evento.getDescripcion())) {
			throw new IllegalArgumentException("La Descripcion del evento ya existe con ese nombre.");
		}
		return eventoRepository.save(evento);
	}

    @Override
	public Evento actualizar(Long id, Evento eventoActualizado) {
		return eventoRepository.findById(id).map(evento -> {
			evento.setDescripcion(eventoActualizado.getDescripcion());
			evento.setUbicacion(eventoActualizado.getUbicacion());
			evento.setCapacidad(eventoActualizado.getCapacidad());
			evento.setFechaEvento(eventoActualizado.getFechaEvento());
			return eventoRepository.save(evento);
		}).orElseThrow(() -> new IllegalArgumentException("Evento no encontrado"));
	}

    @Override
	public void eliminar(Long id) {
		eventoRepository.deleteById(id);
	}
    
}
