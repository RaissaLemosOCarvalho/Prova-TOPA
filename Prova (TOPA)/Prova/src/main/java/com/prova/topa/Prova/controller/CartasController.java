package com.prova.topa.Prova.controller;

import com.prova.topa.Prova.model.CartasEntity;
import com.prova.topa.Prova.repository.CartasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.prova.topa.Prova.form.CartasForm;

@RestController
@RequestMapping("/cartas")
public class CartasController {

    @Autowired
    private CartasRepository repository;


    @PostMapping
    public ResponseEntity<CartasEntity> criarCarta(@RequestBody CartasForm cartas) {
       
        if ("Evento de Mercado".equals(cartas.getTipo()) && cartas.getValor_Monetario()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null); 
        }

        CartasEntity novaCarta = CartasRepository.save(carta);
        return new ResponseEntity<>(novaCarta, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CartasEntity> buscarTodasCartas() {
        return cartaRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<CartasEntity> buscarCartaPorId(@PathVariable Long id) {
        Optional<CartasEntity> carta = cartaRepository.findById(id);
        if (carta.isPresent()) {
            return ResponseEntity.ok(carta.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartasEntity> atualizarCarta(@PathVariable Long id, @RequestBody CartasForm cartas) {
        Optional<CartasEntity> cartaExistente = cartaRepository.findById(id);
        if (cartaExistente.isPresent()) {
            if ("Evento de Mercado".equals(carta.getTipo()) && carta.getValorMonetario() != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(null); 
            }
            carta.setId(id);
            CartasEntity cartaAtualizada = cartaRepository.save(carta);
            return ResponseEntity.ok(cartaAtualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCarta(@PathVariable Long id) {
        if (cartaRepository.existsById(id)) {
            cartaRepository.deleteById(id);
            return ResponseEntity.ok("Carta excluída com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carta não encontrada.");
        }
    }
}