package net.weg.gestaotransporteapi.service;

import lombok.AllArgsConstructor;
import net.weg.gestaotransporteapi.model.dto.request.EnderecoRequestDTO;
import net.weg.gestaotransporteapi.model.dto.response.EnderecoResponseDTO;
import net.weg.gestaotransporteapi.model.entity.Endereco;
import net.weg.gestaotransporteapi.repository.EnderecoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class EnderecoService {

    private EnderecoRepository repository;

    public EnderecoResponseDTO adicionarEndereco(EnderecoRequestDTO enderecoRequestDTO) {
        return repository.save(enderecoRequestDTO.toEntity()).toDTO();
    }

    public EnderecoResponseDTO buscarEndereco(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new).toDTO();
    }

    public EnderecoResponseDTO atualizarEndereco(EnderecoRequestDTO enderecoRequestDTO, Long id) {
        buscarEndereco(id);

        Endereco endereco = enderecoRequestDTO.toEntity();
        endereco.setId(id);

        return repository.save(endereco).toDTO();
    }

    public EnderecoResponseDTO deletarEndereco(Long id) {
        EnderecoResponseDTO enderecoResponseDTO = buscarEndereco(id);

        repository.deleteById(id);
        return enderecoResponseDTO;
    }

    public Page<EnderecoResponseDTO> listarEndereco(Pageable pageable) {
        return repository.findAll(pageable).map(Endereco::toDTO);
    }

    public Endereco buscarEnderecoEntidade(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

}
