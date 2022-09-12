/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import service.ConnectBD;
import util.UtilBDConsulta;

/**
 *
 * @author Utilizador
 */
public class DadosCAP {

    private static int id;
    private static String numero;
    private static int nRepete;
    private static String cursoAnterior;
    private static int OpcaoEntrada;
    private static double mediaCandidatura;
    private static int pc;
    private static int internet;
    private static int nivelInformatica;
    private static int nivelProgramacao;
    private static String linguagens;
    private static ConnectBD ligacaoConn;
    
    public DadosCAP() {
        this.id = 0;
        this.numero = "";
        this.nRepete = 0;
        this.cursoAnterior = "";
        this.OpcaoEntrada = 0;
        this.mediaCandidatura = 0;
        this.pc = 0;
        this.internet = 0;
        this.nivelInformatica = 0;
        this.nivelProgramacao = 0;
        this.linguagens = "";
    }
    public DadosCAP(int nRepete, String cursoAnterior, int OpcaoEntrada, double mediaCandidatura, int pc, int internet, int nivelInformatica, int nivelProgramacao, String linguagens) {
        this.id = 0;
        this.numero = numero;
        this.nRepete = nRepete;
        this.cursoAnterior = cursoAnterior;
        this.OpcaoEntrada = OpcaoEntrada;
        this.mediaCandidatura = mediaCandidatura;
        this.pc = pc;
        this.internet = internet;
        this.nivelInformatica = nivelInformatica;
        this.nivelProgramacao = nivelProgramacao;
        this.linguagens = linguagens;
        this.ligacaoConn = ligacaoConn;
       
    }
    
    public DadosCAP(ConnectBD ligacaoConn, String numero){
        this.ligacaoConn=ligacaoConn;
        this.numero = numero;
        gravarDados();
    }
    
    

    public int calculaValor(){
        int total = 0, valor = 0;
        if (nRepete==1){
            total += 2;                                 // nRepete
        }
        int ca = 0;
        if (cursoAnterior != null) {
            ca = Integer.parseInt(cursoAnterior.substring(0, cursoAnterior.indexOf("#")));
        }
        switch(ca)
        {
            case 1:
            case 5: valor = 2; break;
            case 2: valor = 1; break;
            default: valor = 0;
        }
        total += valor;                                 // cursoAnterior
        total += ((pc==1)?1:0);                         // pc
        total += ((internet==1)?1:0);                   // internet
        total += ((3*nivelInformatica)/5);              // nivel Informatica
        total += ((4*nivelProgramacao)/5);              // nivel Programacao
        int np = countWordsUsingSplit(linguagens);
        if (np>3){
            np = 3;
        }
        total += ((3*np)/3);                            // Linguagens
        valor = 0;
        if (OpcaoEntrada==1 || OpcaoEntrada==2){
            valor = 2;
        }else if (OpcaoEntrada==3){
            valor = 1;
        }
        total += valor;                                 // opcão de entrada
        valor = 0;
        if (mediaCandidatura>9 && mediaCandidatura<14){
            valor = 1;
        } else {
            valor = 2;
        }
        total += valor;                                 // Media Candidatura
        
        return total;
    }
    
    public void gravarDados(){
        int total = calculaValor();
        UtilBDConsulta.gravaRespostasCaraterizaAluno(ligacaoConn, numero, nRepete, cursoAnterior, OpcaoEntrada, 
                mediaCandidatura, pc, internet, nivelInformatica, nivelProgramacao, linguagens, total);
        UtilBDConsulta.gravarPreAtividadeResultadoNumeroAluno(ligacaoConn, numero, "99998", total, resposta());
 
    }
    
    private int countWordsUsingSplit(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] words = input.split("\\s+");
        return words.length;
    }

    public static ConnectBD getLigacaoConn() {
        return ligacaoConn;
    }

    public static void setLigacaoConn(ConnectBD ligacaoConn) {
        DadosCAP.ligacaoConn = ligacaoConn;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        DadosCAP.id = id;
    }

    public static String getNumero() {
        return numero;
    }

    public static void setNumero(String numero) {
        DadosCAP.numero = numero;
    }

    public static int getnRepete() {
        return nRepete;
    }

    public static void setnRepete(int nRepete) {
        DadosCAP.nRepete = nRepete;
    }

    public static String getCursoAnterior() {
        return cursoAnterior;
    }

    public static void setCursoAnterior(String cursoAnterior) {
        DadosCAP.cursoAnterior = cursoAnterior;
    }

    public static int getOpcaoEntrada() {
        return OpcaoEntrada;
    }

    public static void setOpcaoEntrada(int OpcaoEntrada) {
        DadosCAP.OpcaoEntrada = OpcaoEntrada;
    }

    public static double getMediaCandidatura() {
        return mediaCandidatura;
    }

    public static void setMediaCandidatura(double mediaCandidatura) {
        DadosCAP.mediaCandidatura = mediaCandidatura;
    }

    public static int getPc() {
        return pc;
    }

    public static void setPc(int pc) {
        DadosCAP.pc = pc;
    }

    public static int getInternet() {
        return internet;
    }

    public static void setInternet(int internet) {
        DadosCAP.internet = internet;
    }

    public static int getNivelInformatica() {
        return nivelInformatica;
    }

    public static void setNivelInformatica(int nivelInformatica) {
        DadosCAP.nivelInformatica = nivelInformatica;
    }

    public static int getNivelProgramacao() {
        return nivelProgramacao;
    }

    public static void setNivelProgramacao(int nivelProgramacao) {
        DadosCAP.nivelProgramacao = nivelProgramacao;
    }

    public static String getLinguagens() {
        return linguagens;
    }

    public static void setLinguagens(String linguagens) {
        DadosCAP.linguagens = linguagens;
    }

    public static String resposta(){
        String output = nRepete + ";" + cursoAnterior + ";" +
        OpcaoEntrada + ";" +
        mediaCandidatura + ";" +
        pc  + ";" +
        internet + ";" +
        nivelInformatica+ ";" +
        nivelProgramacao + ";" +
        linguagens + ";";
        return output;
    }
   
    
}
