package com.example.DesafioItau.Controller;

import com.example.DesafioItau.Model.EstatisticaDTO;
import com.example.DesafioItau.Model.IntervaloDTO;
import com.example.DesafioItau.Model.Transacao;
import com.example.DesafioItau.Model.TransacaoDTO;
import com.example.DesafioItau.Repository.TransacaoDB;
import com.example.DesafioItau.Service.Mapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
    private final Mapper mapper;

    public TransacaoController() {
        mapper = new Mapper();
    }

    @PostMapping("/transacao")
    public ResponseEntity<?> create(@Valid @RequestBody TransacaoDTO transacaoDTO) {
        try {
            Transacao transacao = mapper.toTransacao(transacaoDTO);
            TransacaoDB.getInstance().addTransacao(transacao);
        }
        catch (IllegalArgumentException iae) {
            return ResponseEntity.status(HttpStatusCode.valueOf(422)).build();
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).build();
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<?> clear() {
        TransacaoDB.getInstance().clearTransacao();
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }

    @GetMapping("/estatistica")
    public ResponseEntity<?> getEstatistica(@RequestBody IntervaloDTO intervaloDTO) {
        Integer intervalo = intervaloDTO.getIntervalo();
        EstatisticaDTO stat;
        try {
            stat = TransacaoDB.getInstance().getStatsInInterval(intervalo);
        }
        catch (IllegalArgumentException iae) {
            return ResponseEntity.status(HttpStatusCode.valueOf(422)).build();
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(stat);
    }
}
