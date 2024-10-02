package model;

public class Ladrao extends Pessoa {
    private String planoDeFuga;

    public Ladrao() {
    }

    public Ladrao(String nome, String cabelo, String olho, String pele, boolean sexo, String planoDeFuga, int id) {
        super(nome, cabelo, olho, pele, sexo, id);
        this.planoDeFuga = planoDeFuga;
    }

    public String getPlanoDeFuga() {
        return planoDeFuga;
    }

    public void setPlanoDeFuga(String planoDeFuga) {
        this.planoDeFuga = planoDeFuga;
    }

    @Override
    public String toString() {
        return "Ladrao PlanoDeFuga=" + planoDeFuga + ", PlanoDeFuga=" + getPlanoDeFuga() +"Id=" +getId() + ", Nome="
                + getNome() + ", Cabelo=" + getCabelo() + ", Olho=" + getOlho() + ", Pele=" + getPele()
                + ", Sexo=" + isSexo() + ", PontoDeVida=" + getPontoDeVida() + "";
    }

    public String fugir() {
        return "Da no pé";
    }

    public String roubar() {
        return "Arrastão";
    }

}
