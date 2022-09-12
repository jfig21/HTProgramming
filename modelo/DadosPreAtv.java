/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Utilizador
 */
public class DadosPreAtv {

    public DadosPreAtv() {
        this.nome = "";
        this.data = LocalDate.now();
        this.score = 0;
    }
    public DadosPreAtv(String nome, LocalDate data, int score) {
        this.nome = nome;
        this.data = data;
        this.score = score;
    }
    
    private String nome;
    private LocalDate data;
    private int score;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
}
