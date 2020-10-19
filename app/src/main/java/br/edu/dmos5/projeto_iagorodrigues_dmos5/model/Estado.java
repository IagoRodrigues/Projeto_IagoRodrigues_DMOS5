package br.edu.dmos5.projeto_iagorodrigues_dmos5.model;

import java.io.Serializable;

public class Estado implements Serializable {
    private int uid;
    private String uf;
    private String state;
    private String cases;
    private String deaths;
    private String suspects;
    private String refuses;


    public Estado(String nome, String uf) {
        this.state = nome;
        this.uf = uf;
    }

    public Estado(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return state;
    }

    public void setNome(String nome) {
        this.state = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return state;
    }

    public Estado(int uid, String uf, String state, String cases, String deaths, String suspects, String refuses) {
        this.uid = uid;
        this.uf = uf;
        this.state = state;
        this.cases = cases;
        this.deaths = deaths;
        this.suspects = suspects;
        this.refuses = refuses;
    }

    public int getUid() {
        return uid;
    }

    public String getState() {
        return state;
    }

    public String getCases() {
        return cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getSuspects() {
        return suspects;
    }

    public String getRefuses() {
        return refuses;
    }
}
