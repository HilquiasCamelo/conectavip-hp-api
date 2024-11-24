package com.conectavip_hp.conectavip_hp.adapters.in.web;

import com.conectavip_hp.conectavip_hp.core.domain.Escort;
import com.conectavip_hp.conectavip_hp.core.domain.dto.EscortDTO;
import com.conectavip_hp.conectavip_hp.core.useCase.EscortCrudUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/escorts")
public class EscortController {

    private final EscortCrudUseCase escortCrudUseCase;

    @Autowired
    public EscortController(EscortCrudUseCase escortCrudUseCase) {
        this.escortCrudUseCase = escortCrudUseCase;
    }

    // Criar novo Escort
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody EscortDTO escortDTO) {
        escortCrudUseCase.create(escortDTO);
        return ResponseEntity.status(201).build();
    }

    // Obter todos os Escorts com paginação
    @GetMapping
    public ResponseEntity<Page<Escort>> findAll(Pageable pageable) {
        return ResponseEntity.ok(escortCrudUseCase.findAll(pageable));
    }


    // Obter um Escort por ID
    @GetMapping("/{id}")
    public ResponseEntity<Escort> findById(@PathVariable UUID id) {
        return escortCrudUseCase.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar um Escort
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody EscortDTO escortDTO) {
        escortCrudUseCase.update(id, escortDTO);
        return ResponseEntity.noContent().build();
    }

    // Deletar um Escort por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        escortCrudUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
