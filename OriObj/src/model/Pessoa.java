package model;

public class Pessoa {

    private String nome;
    private String cabelo;
    private String olho;
    private String pele;
    private boolean sexo;
    private int pontoDeVida = 100;
    private int id;

    public Pessoa() {
    }

    public Pessoa(String nome, String cabelo, String olho, String pele, boolean sexo, int id) {
        
        this.nome = nome;
        this.cabelo = cabelo;
        this.olho = olho;
        this.pele = pele;
        this.sexo = sexo;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCabelo() {
        return cabelo;
    }

    public void setCabelo(String cabelo) {
        this.cabelo = cabelo;
    }

    public String getOlho() {
        return olho;
    }

    public void setOlho(String olho) {
        this.olho = olho;
    }

    public String getPele() {
        return pele;
    }

    public void setPele(String pele) {
        this.pele = pele;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public int getPontoDeVida() {
        return pontoDeVida;
    }

    public void setPontoDeVida(int pontoDeVida) {
        this.pontoDeVida = pontoDeVida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cabelo=" + cabelo + ", olho=" + olho + ", pele=" + pele + ", sexo=" + sexo
                + ", pontoDeVida=" + pontoDeVida + "]";
    }

    public void dano(int dano) {
        this.pontoDeVida = this.pontoDeVida - dano;
    }

    public boolean gameOver() {
        if (this.pontoDeVida < 0) {
            return true;
        } else {
            return false;
        }
    }
}
