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
public class LeagueGame {

    public LeagueGame(int idGame, String season, LocalDate data, int round, String equipa1, int result1, String equipa2, int result2, String activity) {
        this.idGame = idGame;
        this.season = season;
        this.data = data;
        this.round = round;
        this.equipa1 = equipa1;
        this.result1 = result1;
        this.equipa2 = equipa2;
        this.result2 = result2;
        this.activity = activity;
    }

    private int idGame;
    private String season;
    private LocalDate data;
    private int round;
    private String equipa1;
    private int result1;
    private String equipa2;
    private int result2;
    private String activity;

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getEquipa1() {
        return equipa1;
    }

    public void setEquipa1(String equipa1) {
        this.equipa1 = equipa1;
    }

    public int getResult1() {
        return result1;
    }

    public void setResult1(int result1) {
        this.result1 = result1;
    }

    public String getEquipa2() {
        return equipa2;
    }

    public void setEquipa2(String equipa2) {
        this.equipa2 = equipa2;
    }

    public int getResult2() {
        return result2;
    }

    public void setResult2(int result2) {
        this.result2 = result2;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

}
