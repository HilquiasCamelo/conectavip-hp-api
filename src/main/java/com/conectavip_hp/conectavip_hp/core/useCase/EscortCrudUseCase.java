package com.conectavip_hp.conectavip_hp.core.useCase;

import com.conectavip_hp.conectavip_hp.core.domain.Escort;
import com.conectavip_hp.conectavip_hp.core.domain.dto.EscortDTO;
import com.conectavip_hp.conectavip_hp.ports.out.EscortRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EscortCrudUseCase {

    private final EscortRepositoryPort escortRepositoryPort;

    @Autowired
    public EscortCrudUseCase(EscortRepositoryPort escortRepositoryPort) {
        this.escortRepositoryPort = escortRepositoryPort;
    }

    // Criar um novo Escort
    public void create(EscortDTO escortDTO) {
        Escort escort = new Escort();
        escort.setId(UUID.randomUUID());
        escort.setName(escortDTO.getName());
        escort.setPhone(escortDTO.getPhone());
        escort.setWhatsapp(escortDTO.getWhatsapp());
        escort.setTelegram(escortDTO.getTelegram());
        escort.setAddress(escortDTO.getAddress());
        escort.setDescription(escortDTO.getDescription());
        escort.setServices(escortDTO.getServices());
        escort.setServicesPrices(escortDTO.getServicesPrices());
        escort.setAvailability(escortDTO.getAvailability());
        escort.setPhotos(escortDTO.getPhotos());
        escort.setGender(escortDTO.getGender());
        escort.setAge(escortDTO.getAge());
        escortRepositoryPort.save(escort);
    }

    // Obter todos os Escorts com paginação
    public Page<Escort> findAll(Pageable pageable) {
        return escortRepositoryPort.findAll(pageable);
    }

    // Obter um Escort por ID
    public Optional<Escort> findById(UUID id) {
        return escortRepositoryPort.findById(id);
    }

    // Atualizar um Escort
    public void update(UUID id, EscortDTO escortDTO) {
        Escort escort = escortRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("Escort não encontrado."));
        escort.setName(escortDTO.getName());
        escort.setPhone(escortDTO.getPhone());
        escort.setWhatsapp(escortDTO.getWhatsapp());
        escort.setTelegram(escortDTO.getTelegram());
        escort.setAddress(escortDTO.getAddress());
        escort.setDescription(escortDTO.getDescription());
        escort.setServices(escortDTO.getServices());
        escort.setServicesPrices(escortDTO.getServicesPrices());
        escort.setAvailability(escortDTO.getAvailability());
        escort.setPhotos(escortDTO.getPhotos());
        escort.setGender(escortDTO.getGender());
        escort.setAge(escortDTO.getAge());
        escortRepositoryPort.save(escort);
    }

    // Deletar um Escort por ID
    public void delete(UUID id) {
        escortRepositoryPort.deleteById(id);
    }
}
