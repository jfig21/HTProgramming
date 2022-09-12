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
public class DadosGame {

    public DadosGame(String number, int score) {
        this.number = number;
        this.score = score;
    }
    
    private String number;
    private int score;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.number);
        hash = 41 * hash + this.score;
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
        final DadosGame other = (DadosGame) obj;
        if (this.score != other.score) {
            return false;
        }
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        return true;
    }

    
    
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
