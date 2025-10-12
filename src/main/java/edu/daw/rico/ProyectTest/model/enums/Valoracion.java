package edu.daw.rico.ProyectTest.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Valoracion {
    UNO("1"),
    DOS("2"),
    TRES("3"),
    CUATRO("4"),
    CINCO("5");

    private final String valorEnBBDD;

    // Constructor privado para el enum
    Valoracion(String valor) {
        this.valorEnBBDD = valor;
    }

    // Getter que usará JPA y Jackson (para el JSON)
    @JsonValue
    public String getValorEnBBDD() {
        return valorEnBBDD;
    }

    // Método estático para encontrar el enum a partir del valor de la BBDD
    public static Valoracion fromValorEnBBDD(String valor) {
        for (Valoracion v : values()) {
            if (v.valorEnBBDD.equals(valor)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Valoración desconocida: " + valor);
    }
}
