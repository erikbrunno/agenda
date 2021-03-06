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
import br.com.agenda.validacao.AgendaValidador;

@RestController
@RequestMapping("/agenda/")
public class AgendaController {

    @Autowired
    private AgendaService service;

    @Autowired
    private AgendaValidador validador;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/consulta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Agenda> consultar() {
	return service.consultarAgenda();
    }

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Agenda adicionarAgenda(@RequestBody Agenda agenda) {
	validador.validar(agenda);
	service.inserir(agenda);
	return agenda;
    }

    @RequestMapping(value = "/remover", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removerAgenda(@RequestBody Agenda agenda) {
	service.remover(agenda);
    }

}
