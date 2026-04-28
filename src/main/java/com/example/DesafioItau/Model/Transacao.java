package com.example.DesafioItau.Model;

import java.time.OffsetDateTime;

public class Transacao {
    private double valor;
    private OffsetDateTime dataHora;

    public Transacao() {}

    public Transacao(double valor, OffsetDateTime dataHora) {
        if (valor < 0.0) {
            throw new IllegalArgumentException("valor precisa ser >= 0.0");
        }
        if (dataHora == null) {
            throw new IllegalArgumentException("data e hora necessarias");
        }
        if (dataHora.isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("data e hora não podem ser futuras");
        }
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public void setValor(double valor) {
        if (valor < 0.0) {
            throw new IllegalArgumentException("valor precisa ser >= 0.0");
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        if (dataHora==null) {
            throw new IllegalArgumentException("data e hora necessarias");
        }
        this.dataHora = dataHora;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
