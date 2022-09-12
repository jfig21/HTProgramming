/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Quitério
 */
public class Questionario {

    public Questionario(int idPergunta,String pergunta, ArrayList<Resposta> resposta, String tema) {
        this.idPergunta = idPergunta;
        this.pergunta = pergunta;
        this.respostas = resposta;
        this.tema = tema;
    }

    public Questionario(int idPergunta,String pergunta, String tema) {
        this.idPergunta = idPergunta;
        this.pergunta = pergunta;
        this.respostas = new ArrayList<>();
        this.tema = tema;
    }
    public Questionario() {
        this.idPergunta = 0;
        this.pergunta = "";
        this.respostas = new ArrayList<>();
        this.tema = "";
    }
    
    public Questionario(Questionario q) {
        this.idPergunta = q.idPergunta;
        this.pergunta = q.getPergunta();
        this.respostas = q.getRespostas();
        this.tema = q.getTema();
    }
    
        
    private int idPergunta;
    private String pergunta;
    private ArrayList<Resposta> respostas;
    private String tema;

    public int getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

       
    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }

    public ArrayList<Resposta> trocarOrdemRespostas() {
        List<Resposta> list = new ArrayList(respostas);
        Collections.shuffle(list);
        Collections.shuffle(list);
        return new ArrayList(Arrays.asList(list));
    }

    public String getRespostaNumero(int index) {
        return respostas.get(index).getDescricao();
    }

    public int getRespostaCorreta(ArrayList<Resposta> tr) {
        for (int i = 0; i < tr.size(); i++) {
            Resposta r = tr.get(i);
            if (r.getValor() > 0) {
                return r.getValor();
            }
        }
        return 0;
    }

    /**
     * @return the pergunta
     */
    public String getPergunta() {
        return pergunta;
    }

    /**
     * @param pergunta the pergunta to set
     */
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

        /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

}
