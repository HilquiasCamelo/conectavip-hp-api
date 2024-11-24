package com.conectavip_hp.conectavip_hp.ports.out;

import com.conectavip_hp.conectavip_hp.core.domain.Escort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface EscortRepositoryPort extends JpaRepository<Escort, Long> {
    Optional<Escort> findById(UUID id);

    void deleteById(UUID id);
    // Defina consultas customizadas aqui, se necessário
}
