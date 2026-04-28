package com.example.DesafioItau.Model;

import jakarta.validation.constraints.PositiveOrZero;
import org.jspecify.annotations.NonNull;

import java.time.OffsetDateTime;

public class TransacaoDTO {

    @PositiveOrZero
    private double valor;

    @NonNull
    private OffsetDateTime dataHora;

    public TransacaoDTO() {}

    public TransacaoDTO(double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
