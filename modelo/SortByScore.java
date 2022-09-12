/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Comparator;

/**
 *
 * @author Utilizador
 */
public class SortByScore implements Comparator<DadosGame> { 
    
    public int compare(DadosGame a, DadosGame b) 
    { 
        return a.getScore() - b.getScore(); 
    }   
}
