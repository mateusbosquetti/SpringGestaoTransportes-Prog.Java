package net.weg.gestaotransporteapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.gestaotransporteapi.model.dto.response.EnderecoResponseDTO;

@Builder
@Entity
@Table(name = "endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private Integer numero;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false, length = 8)
    private String cep;


    public EnderecoResponseDTO toDTO() {
        return new EnderecoResponseDTO(
                this.id,
                this.rua,
                this.numero,
                this.cidade,
                this.estado,
                this.bairro,
                this.cep
        );
    }
}
