package com.prova.topa.Prova.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartasDTO {
    
    private Long id;
    private String Tipo_Carta;
    private String Descricao;
    private Double Valor_Monetario;
    private String Impacto_Jogo;
    
}
