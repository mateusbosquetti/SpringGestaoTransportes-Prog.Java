package net.weg.gestaotransporteapi.service;

import lombok.AllArgsConstructor;
import net.weg.gestaotransporteapi.model.dto.request.RotaRequestDTO;
import net.weg.gestaotransporteapi.model.dto.response.RotaResponseDTO;
import net.weg.gestaotransporteapi.model.entity.Rota;
import net.weg.gestaotransporteapi.repository.RotaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class RotaService {

    private RotaRepository repository;
    private MotoristaService motoristaService;
    private EnderecoService enderecoService;

    public RotaResponseDTO adicionarRota(RotaRequestDTO rotaRequestDTO) {
        return repository.save(rotaRequestDTO.toEntity(enderecoService, motoristaService)).toDTO();
    }

    public RotaResponseDTO buscarRota(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new).toDTO();
    }

    public RotaResponseDTO atualizarRota(RotaRequestDTO rotaRequestDTO, Long id) {
        buscarRota(id);

        Rota rota = rotaRequestDTO.toEntity(enderecoService, motoristaService);
        rota.setId(id);

        return repository.save(rota).toDTO();
    }

    public RotaResponseDTO deletarRota(Long id) {
        RotaResponseDTO rotaResponseDTO = buscarRota(id);

        repository.deleteById(id);
        return rotaResponseDTO;
    }

    public Page<RotaResponseDTO> listarRota(Pageable pageable) {
        return repository.findAll(pageable).map(Rota::toDTO);
    }

    public Rota buscarRotaEntidade(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    
}
