package net.weg.gestaotransporteapi.repository;

import net.weg.gestaotransporteapi.model.entity.Endereco;
import net.weg.gestaotransporteapi.model.entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
}
