package com.prova.topa.Prova.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class CartasEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    private Long id;
    private String Tipo_Carta;
    private String Descricao;
    private Double Valor_Monetario;
    private String Impacto_Jogo;

}
