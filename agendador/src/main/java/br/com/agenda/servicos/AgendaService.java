package br.com.agenda.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.agenda.dao.AgendaRepository;
import br.com.agenda.modelo.Agenda;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository repository;

    @Transactional
    public void inserir(Agenda agenda) {
	repository.save(agenda);
    }

    @Transactional
    public void remover(Agenda agenda) {
	repository.delete(agenda);
    }

    @Transactional
    public Agenda buscarPorId(Long id) {
	return repository.findOne(id);
    }

    @Transactional
    public List<Agenda> consultarAgenda() {
	return repository.findAll();
    }

}
