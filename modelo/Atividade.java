/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.time.LocalDate;

/**
 *
 * @author Utilizador
 */
public class Atividade {

    public Atividade(int idatividade, LocalDate dataAtividade, String descricao) {
        this.idatividade = idatividade;
        this.dataAtividade = dataAtividade;
        this.descricao = descricao;
    }

    public Atividade(int idatividade, LocalDate dataAtividade, String descricao, File file) {
        this.idatividade = idatividade;
        this.dataAtividade = dataAtividade;
        this.descricao = descricao;
        this.file = file;
    }
  
    private int idatividade;
    private LocalDate dataAtividade;
    private String descricao;
    private File file;
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    
    
    public int getIdatividade() {
        return idatividade;
    }

    public void setIdatividade(int idatividade) {
        this.idatividade = idatividade;
    }

    public LocalDate getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(LocalDate dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
