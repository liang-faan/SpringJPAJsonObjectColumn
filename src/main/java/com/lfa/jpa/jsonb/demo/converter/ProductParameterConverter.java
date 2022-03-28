package com.lfa.jpa.jsonb.demo.converter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lfa.jpa.jsonb.demo.entity.ProductParameter;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProductParameterConverter implements AttributeConverter<List<ProductParameter>, String> {

    ObjectMapper objectMapper = new ObjectMapper()
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .registerModule(new JavaTimeModule())
            .registerModule(new SimpleModule().addSerializer(OffsetDateTime.class, new JsonSerializer<OffsetDateTime>() {
                        @Override
                        public void serialize(OffsetDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                            gen.writeString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(value));
                        }
                    })
            );

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(List<ProductParameter> attribute) {
        return objectMapper.writeValueAsString(attribute);
    }

    @Override
    @SneakyThrows
    public List<ProductParameter> convertToEntityAttribute(String dbData) {
        return List.of(objectMapper.readValue(dbData, ProductParameter[].class));
    }
}
