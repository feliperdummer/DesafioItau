package com.example.DesafioItau.Service;

import com.example.DesafioItau.Model.Transacao;
import com.example.DesafioItau.Model.TransacaoDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public TransacaoDTO toDTO(Transacao transacao) {
        return new TransacaoDTO(transacao.getValor(), transacao.getDataHora());
    }

    public Transacao toTransacao(TransacaoDTO dto) {
        return new Transacao(dto.getValor(), dto.getDataHora());
    }
}
