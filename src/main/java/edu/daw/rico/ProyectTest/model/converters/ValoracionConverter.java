package edu.daw.rico.ProyectTest.model.converters;


import edu.daw.rico.ProyectTest.model.enums.Valoracion;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ValoracionConverter implements AttributeConverter<Valoracion, String> {

    @Override
    public String convertToDatabaseColumn(Valoracion valoracion) {
        // Simplemente llama al getter de nuestro enum enriquecido
        return (valoracion == null) ? null : valoracion.getValorEnBBDD();
    }

    @Override
    public Valoracion convertToEntityAttribute(String dbData) {
        // Llama al método estático de nuestro enum enriquecido
        return (dbData == null) ? null : Valoracion.fromValorEnBBDD(dbData);
    }
}