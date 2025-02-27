package net.weg.gestaotransporteapi.service;

import lombok.AllArgsConstructor;
import net.weg.gestaotransporteapi.model.dto.request.MotoristaRequestDTO;
import net.weg.gestaotransporteapi.model.dto.request.MotoristaRequestDTO;
import net.weg.gestaotransporteapi.model.dto.response.MotoristaResponseDTO;
import net.weg.gestaotransporteapi.model.dto.response.MotoristaResponseDTO;
import net.weg.gestaotransporteapi.model.entity.Motorista;
import net.weg.gestaotransporteapi.model.entity.Motorista;
import net.weg.gestaotransporteapi.repository.MotoristaRepository;
import net.weg.gestaotransporteapi.repository.MotoristaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class MotoristaService {

    private MotoristaRepository repository;
    private EnderecoService enderecoService;

    public MotoristaResponseDTO adicionarMotorista(MotoristaRequestDTO motoristaRequestDTO) {
        return repository.save(motoristaRequestDTO.toEntity(enderecoService)).toDTO();
    }

    public MotoristaResponseDTO buscarMotorista(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new).toDTO();
    }

    public MotoristaResponseDTO atualizarMotorista(MotoristaRequestDTO motoristaRequestDTO, Long id) {
        buscarMotorista(id);

        Motorista motorista = motoristaRequestDTO.toEntity(enderecoService);
        motorista.setId(id);

        return repository.save(motorista).toDTO();
    }

    public MotoristaResponseDTO deletarMotorista(Long id) {
        MotoristaResponseDTO motoristaResponseDTO = buscarMotorista(id);

        repository.deleteById(id);
        return motoristaResponseDTO;
    }

    public Page<MotoristaResponseDTO> listarMotorista(Pageable pageable) {
        return repository.findAll(pageable).map(Motorista::toDTO);
    }

    public Motorista buscarMotoristaEntidade(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
