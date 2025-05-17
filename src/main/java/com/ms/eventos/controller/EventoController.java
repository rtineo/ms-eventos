package com.ms.eventos.controller;

import java.util.List; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ms.eventos.service.EventoService;
import com.ms.eventos.entities.Evento;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api2/eventos")
public class EventoController {
    private final EventoService eventoService;

    public EventoController(EventoService eventoService){
        this.eventoService = eventoService;
    }


    //demas crud
    @GetMapping
	public ResponseEntity<List<Evento>> listarTodos() {
		return ResponseEntity.ok(eventoService.listarTodos());
	}

    @PostMapping
	public ResponseEntity<Evento> crear(@RequestBody Evento evento) {
		return ResponseEntity.ok(eventoService.guardar(evento));
	}


    //usamos esta opcion para listar el evento por id, servira para id si existe y controlar la capacidad del evento
    @GetMapping("/{id}") 
    public ResponseEntity<Evento> obtenerPorId(@PathVariable Long id){
        return eventoService.obtenerPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
	public ResponseEntity<Evento> actualizar(@PathVariable Long id, @RequestBody Evento evento) {
		return ResponseEntity.ok(eventoService.actualizar(id, evento));
	}

    @DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		eventoService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
   

}
