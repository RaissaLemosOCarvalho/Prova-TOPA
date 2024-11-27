package com.prova.topa.Prova.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartasForm {
       
    private String Tipo_Carta;
    private String Descricao;
    private Double Valor_Monetario;
    private String Impacto_Jogo;
}


