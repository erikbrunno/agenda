package br.com.agenda.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.modelo.Agenda;
import br.com.agenda.servicos.AgendaService;

@RestController
@RequestMapping("/agenda/")
public class AgendaController {

    @Autowired
    private AgendaService service;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/consulta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Agenda> consultar() {
	return service.consultarAgenda();
    }

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Agenda adicionarAgenda(@RequestBody Agenda agenda) {
	// FALTA FAZER A VALIDACAO

	service.inserir(agenda);
	return agenda;
    }

}
