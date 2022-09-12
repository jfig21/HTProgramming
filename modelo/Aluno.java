/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

/**
 *
 * @author Quitério
 */
public class Aluno {

    public Aluno(int idAluno, String numero, String nome, String curso, 
            String unidadeCurricular, LocalDate dataNascimento,
            String localidade, byte sexo, BufferedImage foto, 
            String email, String login, String passwd, int perfil) {
        this.idAluno = idAluno;
        this.numero = numero;
        this.nome = nome;
        this.curso = curso;
        this.unidadeCurricular = unidadeCurricular;
        this.dataNascimento = dataNascimento;
        this.localidade = localidade;
        this.sexo = sexo;
        this.foto = foto;
        this.email = email;
        this.login = login;
        this.passwd = passwd;
        this.perfil = perfil;
    }


    
    public Aluno() {
        this.idAluno = 0;
        this.numero = "";
        this.nome = "";
        this.curso = "";
        this.unidadeCurricular = "";
        this.dataNascimento = null;
        this.localidade = "";
        this.sexo = -1; // -1 Falta de Informação 1 - masculino, 0 - feminino
        this.foto = null;
    }

    public Aluno(String numero, String nome, LocalDate dataNascimento, String localidade, byte sexo, String email) {
        this.numero = numero;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.localidade = localidade;
        this.sexo = sexo;
        this.email = email;
    }
    
    
    
    public Aluno(String numero, String nome,  BufferedImage foto) {
        this.idAluno = 0;
        this.numero = numero;
        this.nome = nome;
        this.curso = "";
        this.unidadeCurricular = "";
        this.dataNascimento = null;
        this.localidade = "";
        this.sexo = -1;  // -1 Falta de Informação 1 - masculino, 0 - feminino
        this.foto = foto;
    }
    
     public Aluno(String numero, String nome, String curso, 
                String unidadeCurricular, LocalDate dataNascimento, 
                String localidade, byte sexo, BufferedImage foto, int ano) {
        this.idAluno = 0;
        this.numero = numero;
        this.nome = nome;
        this.curso = curso;
        this.unidadeCurricular = unidadeCurricular;
        this.dataNascimento = dataNascimento;
        this.localidade = localidade;
        this.sexo = sexo;
        this.foto = foto;
        this.anoletivo = ano;
    }
    public Aluno(int idAluno, String numero, String nome, String curso, 
                String unidadeCurricular, LocalDate dataNascimento, 
                String localidade, byte sexo, BufferedImage foto) {
        this.idAluno = idAluno;
        this.numero = numero;
        this.nome = nome;
        this.curso = curso;
        this.unidadeCurricular = unidadeCurricular;
        this.dataNascimento = dataNascimento;
        this.localidade = localidade;
        this.sexo = sexo;
        this.foto = foto;
    }

    public Aluno(String numero, String nome, String curso, 
            String unidadeCurricular, LocalDate dataNascimento, 
            String localidade, byte sexo, BufferedImage foto, 
            String email, String login, String passwd) {
        this.numero = numero;
        this.nome = nome;
        this.curso = curso;
        this.unidadeCurricular = unidadeCurricular;
        this.dataNascimento = dataNascimento;
        this.localidade = localidade;
        this.sexo = sexo;
        this.foto = foto;
        this.email = email;
        this.login = login;
        this.passwd = passwd;
    }

    public Aluno(String numero, String nome, String login, String passwd) {
        this.numero = numero;
        this.nome = nome;
        this.curso = "";
        this.unidadeCurricular = "";
        this.dataNascimento = null;
        this.localidade = "";
        this.sexo = -1;
        this.foto = null;
        this.email = "";
        this.login = login;
        this.passwd = passwd;
    }

    public Aluno(String numero, String nome, String curso, String unidadeCurricular,
            LocalDate dataNascimento, String localidade, byte sexo, String email, String login, String passwd,
            int perfil) {
         this.numero = numero;
        this.nome = nome;
        this.curso = curso;
        this.unidadeCurricular = unidadeCurricular;
        this.dataNascimento = dataNascimento;
        this.localidade = localidade;
        this.sexo = sexo;
        this.email = email;
        this.login = login;
        this.passwd = passwd;
        this.perfil = perfil;
    }
    public Aluno(String numero, String nome, String curso, String unidadeCurricular,
            LocalDate dataNascimento, String localidade, byte sexo, String email, String login, String passwd,
            int perfil, int anoletivo) {
         this.numero = numero;
        this.nome = nome;
        this.curso = curso;
        this.unidadeCurricular = unidadeCurricular;
        this.dataNascimento = dataNascimento;
        this.localidade = localidade;
        this.sexo = sexo;
        this.email = email;
        this.login = login;
        this.passwd = passwd;
        this.perfil = perfil;
        this.anoletivo = anoletivo;
    }
    
    
         
    private int idAluno;
    private String numero;
    private String nome;
    private String curso;
    private String unidadeCurricular;
    private LocalDate dataNascimento;
    private String localidade;
    private byte sexo;
    private BufferedImage foto;
    private String email;
    private String login;
    private String passwd;
    private int perfil;
    private int anoletivo;

    public int getAnoletivo() {
        return anoletivo;
    }

    public void setAnoletivo(int anoletivo) {
        this.anoletivo = anoletivo;
    }

    
    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }
    
    
/**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @return the idAluno
     */
    public int getIdAluno() {
        return idAluno;
    }

    /**
     * @param idAluno the idAluno to set
     */
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the unidadeCurricular
     */
    public String getUnidadeCurricular() {
        return unidadeCurricular;
    }

    /**
     * @param unidadeCurricular the unidadeCurricular to set
     */
    public void setUnidadeCurricular(String unidadeCurricular) {
        this.unidadeCurricular = unidadeCurricular;
    }

    /**
     * @return the dataNascimento
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the localidade
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * @param localidade the localidade to set
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     * @return the foto
     */
    public BufferedImage getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(BufferedImage foto) {
        this.foto = foto;
    }

    /**
     * @return the sexo
     */
    public byte getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(byte sexo) {
        this.sexo = sexo;
    }
    
    
}
