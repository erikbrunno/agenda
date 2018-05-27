package br.com.agenda.modelo.conversor;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/*
 * Essa classe é usada pelo Jackson para Deserializar um objeto JSON -> java
 */
public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    protected LocalDateTimeDeserializer() {
	super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
	Date data = null;
	try {
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	    data = format.parse(parser.getText());
	    data = new Date(data.getTime() - (60000 * data.getTimezoneOffset()));
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return LocalDateTime.of(LocalDate.now(), LocalTime.of(data.getHours(), data.getMinutes()));
    }
}
