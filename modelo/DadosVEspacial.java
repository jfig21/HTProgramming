/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.time.LocalDate;
import service.ConnectBD;
import util.UtilBDConsulta;

/**
 *
 * @author Quitério
 */
public class DadosVEspacial {

    private static int nAcertos;
    private static String respostasfinal;
    private static Aluno aluno;
    private static ConnectBD ligacaoConn;
     private static Connection ligacao;

    public DadosVEspacial(Connection ligacao,ConnectBD ligacaoConn, Aluno aluno) {
        DadosVEspacial.ligacao = ligacao;
        DadosVEspacial.ligacaoConn = ligacaoConn;
        DadosVEspacial.aluno = aluno;
    }
       
    public DadosVEspacial(int nAcertos, String respostasfinal) {
        DadosVEspacial.nAcertos = nAcertos;
        DadosVEspacial.respostasfinal = respostasfinal;
        gravaDados();
    }

    private void gravaDados(){
        UtilBDConsulta.gravaRespostasVEspacial(aluno, respostasfinal, nAcertos);
        UtilBDConsulta.gravaPerfilNumeroAluno(ligacaoConn, aluno.getNumero(), nAcertos);
        UtilBDConsulta.gravarPreAtividadeResultadoNumeroAluno(ligacaoConn, aluno.getNumero(), "99999", nAcertos, respostasfinal);
        //  Quando termina deve atualizar dados
    }
    
    public static int getnAcertos() {
        return nAcertos;
    }

    public static void setnAcertos(int nAcertos) {
        DadosVEspacial.nAcertos = nAcertos;
    }

    public static String getRespostasfinal() {
        return respostasfinal;
    }

    public static void setRespostasfinal(String respostasfinal) {
        DadosVEspacial.respostasfinal = respostasfinal;
    }

    @Override
    public String toString() {
        return "DadosVEspacial{" + "nAcertos=" + nAcertos + ", respostasfinal=" + respostasfinal + '}';
    }

   
   
    
}
