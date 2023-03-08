package entidades;

import java.util.Date;

public class Agendamento {
    private Integer idAgendamento;
    private Integer idAnimal;
    private Integer idFuncionario;
    private Integer idServico;
    private Date dataAgendamento;
    private String situacaoAgendamento;
    private String nomeAnimal;
    private String nomeFuncionario;
    private String tipoServico;

    public Agendamento(Integer idAgendamento, Integer idAnimal, Integer idFuncionario, Integer idServico,
            Date dataAgendamento, String situacaoAgendamento) {
        this.idAgendamento = idAgendamento;
        this.idAnimal = idAnimal;
        this.idFuncionario = idFuncionario;
        this.idServico = idServico;
        this.dataAgendamento = dataAgendamento;
        this.situacaoAgendamento = situacaoAgendamento;
    }
    
    public Agendamento(Integer idAgendamento, String nomeAnimal, String nomeFuncionario, String tipoServico, Date dataAgendamento, String situacaoAgendamento) {
        this.idAgendamento = idAgendamento;
        this.nomeAnimal = nomeAnimal;
        this.nomeFuncionario = nomeFuncionario;
        this.tipoServico = tipoServico;
        this.dataAgendamento = dataAgendamento;
        this.situacaoAgendamento = situacaoAgendamento;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
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
