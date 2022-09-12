/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Utilizador
 */
public class DadosCoding {

    public DadosCoding(String descricao, LocalDate data, int resultado) {
        this.descricao = descricao;
        this.data = data;
        this.resultado = resultado;
    }
    public DadosCoding(String descricao,int resultado) {
        this.descricao = descricao;
        this.data = LocalDate.now();
        this.resultado = resultado;
    }
    
    private String descricao;
    private LocalDate data;
    private int resultado;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.descricao);
        hash = 17 * hash + Objects.hashCode(this.data);
        hash = 17 * hash + this.resultado;
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
        final DadosCoding other = (DadosCoding) obj;
        if (this.resultado != other.resultado) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
    
}
