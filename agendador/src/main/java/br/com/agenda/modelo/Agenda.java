package br.com.agenda.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.agenda.modelo.conversor.LocalDateAttributeConverter;
import br.com.agenda.modelo.conversor.LocalDateDeserializer;
import br.com.agenda.modelo.conversor.LocalDateTimeAttributeConverter;
import br.com.agenda.modelo.conversor.LocalDateTimeDeserializer;

@Entity
@Table(name = "AGC_AGENDA_COMPROMISSO")
public class Agenda implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3877767414166603294L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AGC_ID")
    private Long id;

    @Column(name = "AGC_NOME")
    @NotNull
    @Size(max = 500)
    private String nome;

    @Column(name = "AGC_DT_INICIO")
    @NotNull
    @Convert(converter = LocalDateAttributeConverter.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dataInicio;

    @Column(name = "AGC_DT_FIM")
    @NotNull
    @Convert(converter = LocalDateAttributeConverter.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dataFim;

    @Column(name = "AGC_HR_INICIO")
    @NotNull
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime horaInicio;

    @Column(name = "AGC_HR_FIM")
    @NotNull
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime horaFim;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public LocalDate getDataInicio() {
	return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
	this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
	return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
	this.dataFim = dataFim;
    }

    public LocalDateTime getHoraInicio() {
	return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
	this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraFim() {
	return horaFim;
    }

    public void setHoraFim(LocalDateTime horaFim) {
	this.horaFim = horaFim;
    }
}
