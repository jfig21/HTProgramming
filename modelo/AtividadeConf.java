/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Utilizador
 */
public class AtividadeConf {

    public AtividadeConf() {
        this.idAtividade = 0;
        this.numeroAtv = "";
        this.dataAtividade = null;
        this.enunciado = "";
        this.nInput = 0;
        this.output = new ArrayList();
        this.nTest = 0;
        this.commentKey = new ArrayList();
    }
    public AtividadeConf(String numeroAtv, LocalDate dataAtividade, String enunciado, int nInput, ArrayList<String> output, int nTest, ArrayList<String> commentKey) {
        this.idAtividade = 0;
        this.numeroAtv = numeroAtv;
        this.dataAtividade = dataAtividade;
        this.enunciado = enunciado;
        this.nInput = nInput;
        this.output = output;
        this.nTest = nTest;
        this.commentKey = commentKey;
    }
    public AtividadeConf(int idAtividade, String numeroAtv, LocalDate dataAtividade, String enunciado, int nInput, ArrayList<String> output, int nTest, ArrayList<String> commentKey) {
        this.idAtividade = idAtividade;
        this.numeroAtv = numeroAtv;
        this.dataAtividade = dataAtividade;
        this.enunciado = enunciado;
        this.nInput = nInput;
        this.output = output;
        this.nTest = nTest;
        this.commentKey = commentKey;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.numeroAtv);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AtividadeConf other = (AtividadeConf) obj;
        if (!Objects.equals(this.numeroAtv, other.numeroAtv)) {
            return false;
        }
        return true;
    }
    
    
    private int idAtividade;
    private String numeroAtv;
    private LocalDate dataAtividade;
    private String enunciado;
    private int nInput;
    private ArrayList<String> output;
    private int nTest;
    private ArrayList<String> commentKey;

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getNumeroAtv() {
        return numeroAtv;
    }

    public void setNumeroAtv(String numeroAtv) {
        this.numeroAtv = numeroAtv;
    }

    public LocalDate getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(LocalDate dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getnInput() {
        return nInput;
    }

    public void setnInput(int nInput) {
        this.nInput = nInput;
    }

    public ArrayList<String> getOutput() {
        return output;
    }

    public void setOutput(ArrayList<String> output) {
        this.output = output;
    }

    public int getnTest() {
        return nTest;
    }

    public void setnTest(int nTest) {
        this.nTest = nTest;
    }

    public ArrayList<String> getCommentKey() {
        return commentKey;
    }

    public void setCommentKey(ArrayList<String> commentKey) {
        this.commentKey = commentKey;
    }
    
    
}
