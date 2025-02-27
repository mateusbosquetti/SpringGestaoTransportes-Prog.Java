package net.weg.gestaotransporteapi.repository;

import net.weg.gestaotransporteapi.model.entity.Endereco;
import net.weg.gestaotransporteapi.model.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
