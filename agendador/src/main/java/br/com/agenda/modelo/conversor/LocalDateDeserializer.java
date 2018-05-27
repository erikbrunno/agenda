package br.com.agenda.modelo.conversor;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/*
 * Essa classe é usada pelo Jackson para Deserializar um objeto JSON -> java
 */
public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    protected LocalDateDeserializer() {
	super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
	String data = "";
	String dataJson = parser.readValueAs(String.class);
	for (int i = 0; i < 10; i++) {
	    data = data.concat("" + dataJson.charAt(i));
	}
	return LocalDate.parse(data);
    }
}
