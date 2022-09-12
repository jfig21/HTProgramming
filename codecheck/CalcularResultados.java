/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecheck;

import java.util.ArrayList;
import modelo.NumeroPerfil;

/**
 *
 * @author Utilizador
 */
public class CalcularResultados {

    public static int calculoSimples(int total, int valor, int max) {
        // Para calcular o valor de uma atividade
        // Em função do número total de respostas (total), e o número 
        //      de respostas acertadas(valor) obtidas.
        // max representa o valor total da escala (200)
        int resultado = 0;
        if (total > 0) {
            resultado = (max * valor) / total;
        }
        return resultado;
    }

    public static int calculoMetodo(ArrayList<Integer> listaResultados) {
        // Calculo de resultado de uma atividade com várias resoluções
        // Média geométrica, a primeira resolução conta mais que as seguintes. 
        int resultado = 0, soma = 0;
        int n = listaResultados.size();
        for (int i = 0, p = n; i < n; i++, p--) {
            soma = soma + listaResultados.get(i) * p;
        }
        resultado = soma / ((n * (n + 1)) / 2);
        return resultado;
    }

    public static int calculoTotalPerfil(ArrayList<NumeroPerfil> tr){
        int total = 0;
        
        if (tr.size() > 0) {

            ArrayList<Integer> t = new ArrayList<>();
            for (NumeroPerfil np : tr) {
                int existe = 0;
                for (int i = 0; i < t.size(); i++) {
                    if (np.getIdAtividade() == t.get(i)) {
                        existe = 1;
                    }
                }
                if (existe == 0) {
                    t.add(np.getIdAtividade());
                }
            }

            for (Integer i : t) {
                ArrayList<Integer> r =new ArrayList<>();
                for (NumeroPerfil np : tr) {
                    if (i == np.getIdAtividade()) {
                        r.add(np.getPerfil());
                    }
                }
                total = total + calculoMetodo(r);
            }
        }
        
        return total;
    }
}
