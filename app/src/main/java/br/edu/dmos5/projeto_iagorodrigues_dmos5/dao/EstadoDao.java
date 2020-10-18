package br.edu.dmos5.projeto_iagorodrigues_dmos5.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.dmos5.projeto_iagorodrigues_dmos5.model.Estado;

public class EstadoDao {

    public static final List<Estado> recuperateAll(){
        ArrayList<Estado> arrayList = new ArrayList<>(26);

        arrayList.add(new Estado("Minas Gerais", "mg"));
        arrayList.add(new Estado("São Paulo", "sp"));
        arrayList.add(new Estado("Rio Grande do Sul", "rs"));
        arrayList.add(new Estado("Bahia", "ba"));
        arrayList.add(new Estado("Paraná", "pr"));
        arrayList.add(new Estado("Santa Catarina", "sc"));
        arrayList.add(new Estado("Goiás", "go"));
        arrayList.add(new Estado("Piauí", "pi"));
        arrayList.add(new Estado("Paraíba", "pb"));
        arrayList.add(new Estado("Maranhão", "ma"));
        arrayList.add(new Estado("Pernanbuco", "pb"));
        arrayList.add(new Estado("Ceará", "ce"));
        arrayList.add(new Estado("Rio Grande do Norte", "rn"));
        arrayList.add(new Estado("Pará", "pa"));
        arrayList.add(new Estado("Mato Grosso", "mt"));
        arrayList.add(new Estado("Tocantins", "to"));
        arrayList.add(new Estado("Alagoas", "al"));
        arrayList.add(new Estado("Rio de Janeiro", "rj"));
        arrayList.add(new Estado("Mato Grosso do Sul", "ms"));
        arrayList.add(new Estado("Espírito Santo", "es"));
        arrayList.add(new Estado("Sergipe", "se"));
        arrayList.add(new Estado("Amazonas", "am"));
        arrayList.add(new Estado("Rondônia", "ro"));
        arrayList.add(new Estado("Acre", "ac"));
        arrayList.add(new Estado("Amapá", "ap"));
        arrayList.add(new Estado("Roraima", "rr"));

        return arrayList;
    }

}
