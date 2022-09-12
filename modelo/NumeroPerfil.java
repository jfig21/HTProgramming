/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author Utilizador
 */
public class NumeroPerfil {

    public NumeroPerfil(String numero, int perfil) {
        this.numero = numero;
        this.idAtividade = 0;
        this.perfil = perfil;
    }

    public NumeroPerfil(String numero, int idAtividade,int perfil) {
        this.numero = numero;
        this.perfil = perfil;
        this.idAtividade = idAtividade;
    }
    
       
    private String numero;
    private int perfil;
    private int idAtividade;

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }
    
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.numero);
        hash = 19 * hash + this.perfil;
        hash = 19 * hash + this.idAtividade;
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
        final NumeroPerfil other = (NumeroPerfil) obj;
        if (this.perfil != other.perfil) {
            return false;
        }
        if (this.idAtividade != other.idAtividade) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "NumeroPerfil{" + "numero=" + numero + ", perfil=" + perfil + '}';
    }

    
    
}
