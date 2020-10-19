package br.edu.dmos5.projeto_iagorodrigues_dmos5.model;

public class Contagem {
    private String data;
    private String casos;

    public Contagem(String data, String casos) {
        this.data = data;
        this.casos = casos;
    }

    public String getData() {
        return data;
    }

    public String getCasos() {
        return casos;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setCasos(String casos) {
        this.casos = casos;
    }
}
