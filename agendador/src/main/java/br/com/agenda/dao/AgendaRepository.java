package br.com.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agenda.modelo.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
