/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author luanf
 */
public class Agendamento2 {
    
    private Integer idAgendamento;
    private String nomeAnimal;
    private String nomeFuncionario;
    private String tipoServico;
    private Date dataAgendamento;
    private String situacaoAgendamento;

    public Agendamento2(Integer idAgendamento, String nomeAnimal, String nomeFuncionario, String tipoServico, Date dataAgendamento, String situacaoAgendamento) {
        this.idAgendamento = idAgendamento;
        this.nomeAnimal = nomeAnimal;
        this.nomeFuncionario = nomeFuncionario;
        this.tipoServico = tipoServico;
        this.dataAgendamento = dataAgendamento;
        this.situacaoAgendamento = situacaoAgendamento;
    }

    public Integer getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Integer idAgendamento) {
        this.idAgendamento = idAgendamento;
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


