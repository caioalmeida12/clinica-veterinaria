package entidades;

import java.sql.Date;

public class Agendamento {
    Integer idAgendamento;
    Integer idAnimal;
    Integer idFuncionario;
    Integer idServico;
    Date dataAgendamento;
    String situacaoAgendamento;

    public Agendamento(Integer idAgendamento, Integer idAnimal, Integer idFuncionario, Integer idServico,
            Date dataAgendamento, String situacaoAgendamento) {
        this.idAgendamento = idAgendamento;
        this.idAnimal = idAnimal;
        this.idFuncionario = idFuncionario;
        this.idServico = idServico;
        this.dataAgendamento = dataAgendamento;
        this.situacaoAgendamento = situacaoAgendamento;
    }

    public Integer getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Integer idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getSituacaoAgendamento() {
        return situacaoAgendamento;
    }

    public void setSituacaoAgendamento(String situacaoAgendamento) {
        this.situacaoAgendamento = situacaoAgendamento;
    }

}
