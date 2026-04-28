package com.example.DesafioItau.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

public class IntervaloDTO {

    @Min(60)
    private int intervalo;

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }
}
