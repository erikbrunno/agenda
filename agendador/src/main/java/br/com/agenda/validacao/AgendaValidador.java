package br.com.agenda.validacao;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;

import br.com.agenda.modelo.Agenda;
import br.com.agenda.util.ConstanteUtil;

@Service
public class AgendaValidador {

    public void validar(Agenda agenda) {
	validarCamposObrigatorios(agenda);

	if (agenda.getDataInicio().compareTo(agenda.getDataFim()) > 0) {
	    throw new NegocioException(ConstanteUtil.MSG_DATA_INICIO_MAIOR_DATA_FIM);
	}

	if (agenda.getDataInicio().equals(agenda.getDataFim())
		&& agenda.getHoraInicio().compareTo(agenda.getHoraFim()) > 0) {
	    throw new NegocioException(ConstanteUtil.MSG_HORA_INICIO_MAIOR_HORA_FIM);
	}
    }

    private void validarCamposObrigatorios(Agenda agenda) {
	if (agenda.getNome() == null || agenda.getNome().isEmpty()) {
	    throw new NegocioException(MessageFormat.format(ConstanteUtil.MSG_CAMPO_VAZIO, ConstanteUtil.NOME));
	}

	if (agenda.getDataInicio() == null) {
	    throw new NegocioException(MessageFormat.format(ConstanteUtil.MSG_CAMPO_VAZIO, ConstanteUtil.DATA_INICIO));
	}

	if (agenda.getDataFim() == null) {
	    throw new NegocioException(MessageFormat.format(ConstanteUtil.MSG_CAMPO_VAZIO, ConstanteUtil.DATA_FIM));
	}

	if (agenda.getHoraInicio() == null) {
	    throw new NegocioException(MessageFormat.format(ConstanteUtil.MSG_CAMPO_VAZIO, ConstanteUtil.HORA_INICIO));
	}

	if (agenda.getHoraFim() == null) {
	    throw new NegocioException(MessageFormat.format(ConstanteUtil.MSG_CAMPO_VAZIO, ConstanteUtil.HORA_FIM));
	}
    }

}
