package net.weg.gestaotransporteapi.repository;

import net.weg.gestaotransporteapi.model.entity.Endereco;
import net.weg.gestaotransporteapi.model.entity.Rota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RotaRepository extends JpaRepository<Rota, Long> {
}
