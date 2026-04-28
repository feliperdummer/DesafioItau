package com.example.DesafioItau.Repository;

import com.example.DesafioItau.Model.EstatisticaDTO;
import com.example.DesafioItau.Model.Transacao;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoDB {
    private static TransacaoDB instance;

    private List<Transacao> lista;

    private TransacaoDB() {
        lista = new ArrayList<>();
    }

    public static TransacaoDB getInstance() {
        if (instance==null) {
            instance = new TransacaoDB();
        }
        return instance;
    }

    public List<Transacao> getLista() {
        return lista;
    }

    public void addTransacao(Transacao transacao) {
        if (transacao==null) {
            throw new IllegalArgumentException("transacao deve ser !null");
        }
        lista.add(transacao);
    }

    public void clearTransacao() {
        lista.clear();
    }

    public EstatisticaDTO getStatsInInterval(Integer intervalo) {
        if (intervalo < 60) {
            throw new IllegalArgumentException("intervalo minimo: 60 segundos");
        }
        long count = 0;
        Double sum = 0.0, avg = 0.0, minValue = Double.MAX_VALUE, maxValue = Double.MIN_VALUE;
        OffsetDateTime now = OffsetDateTime.parse("2026-04-28T15:30:59+02:00");
        for (Transacao transacao : lista) {
            if (Duration.between(now, transacao.getDataHora()).abs().getSeconds() <= intervalo) {
                count++;
                sum += transacao.getValor();
                minValue = Math.min(minValue, transacao.getValor());
                maxValue = Math.max(maxValue, transacao.getValor());
            }
        }
        avg = count!=0 ? sum / count : 0.0;
        return new EstatisticaDTO(count, sum, avg,
                minValue==Double.MAX_VALUE ? 0.0 : minValue,
                maxValue==Double.MIN_VALUE ? 0.0 : maxValue);
    }
}
