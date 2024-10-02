package model;

public class Guerreiro extends Pessoa {

    private String armamento;

    public Guerreiro() {
    }

    public Guerreiro(String nome, String cabelo, String olho, String pele, boolean sexo, String armamento, int id) {
        super(nome, cabelo, olho, pele, sexo,id);
        this.armamento = armamento;
    }

    public String getArmamento() {
        return armamento;
    }

    public void setArmamento(String armamento) {
        this.armamento = armamento;
    }

    @Override
    public String toString() {
        return "Guerreiro - Armamento=" + armamento + ",getId()=" + getId() +", Nome=" + getNome()
                + ", Cabelo=" + getCabelo() + ", Olho=" + getOlho() + ", Pele=" + getPele()
                + ", Sexo=" + isSexo() + ", PontoDeVida=" + getPontoDeVida() + "";
    }

    public void atacar(){
        this.dano(10);
    }

    public Guerreiro(String armamento) {
        this.armamento = armamento;
    }
    
    

}
