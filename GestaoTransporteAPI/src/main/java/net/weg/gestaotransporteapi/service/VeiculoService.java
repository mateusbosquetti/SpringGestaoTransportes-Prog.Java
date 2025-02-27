package net.weg.gestaotransporteapi.service;

import lombok.AllArgsConstructor;
import net.weg.gestaotransporteapi.model.dto.request.VeiculoRequestDTO;
import net.weg.gestaotransporteapi.model.dto.response.VeiculoResponseDTO;
import net.weg.gestaotransporteapi.model.entity.Veiculo;
import net.weg.gestaotransporteapi.repository.VeiculoRepository;
import net.weg.gestaotransporteapi.repository.VeiculoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class VeiculoService {
    
    private VeiculoRepository repository;
    private MotoristaService motoristaService;

    public VeiculoResponseDTO adicionarVeiculo(VeiculoRequestDTO veiculoRequestDTO) {
        return repository.save(veiculoRequestDTO.toEntity(motoristaService)).toDTO();
    }

    public VeiculoResponseDTO buscarVeiculo(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new).toDTO();
    }

    public VeiculoResponseDTO atualizarVeiculo(VeiculoRequestDTO veiculoRequestDTO, Long id) {
        buscarVeiculo(id);

        Veiculo veiculo = veiculoRequestDTO.toEntity(motoristaService);
        veiculo.setId(id);

        return repository.save(veiculo).toDTO();
    }

    public VeiculoResponseDTO deletarVeiculo(Long id) {
        VeiculoResponseDTO veiculoResponseDTO = buscarVeiculo(id);

        repository.deleteById(id);
        return veiculoResponseDTO;
    }

    public Page<VeiculoResponseDTO> listarVeiculo(Pageable pageable) {
        return repository.findAll(pageable).map(Veiculo::toDTO);
    }

    public Veiculo buscarVeiculoEntidade(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    
}
