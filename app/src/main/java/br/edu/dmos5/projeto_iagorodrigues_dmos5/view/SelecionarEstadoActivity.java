package br.edu.dmos5.projeto_iagorodrigues_dmos5.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import br.edu.dmos5.projeto_iagorodrigues_dmos5.R;
import br.edu.dmos5.projeto_iagorodrigues_dmos5.dao.EstadoDao;
import br.edu.dmos5.projeto_iagorodrigues_dmos5.model.Estado;

public class SelecionarEstadoActivity extends AppCompatActivity {

    //Referência para o elemento de layout.
    private RecyclerView estadosReciclerView;

    //Fonte de dados, essa lista possue os dados que são apresentados
    //na tela dos dispositivo.
    private List<Estado> estadoList;

    //Um adapter é responsável pela ligação da fonte de dados com o elemento
    //de interface (ListView), é esse objeto que configura a apresentação
    //dos dados na tela do app.
    private ItemEstadoAdapter estadoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_estado);

        //Recupera a referência do elemento no layout
        estadosReciclerView = findViewById(R.id.list_estados);

        //Ao contrário do ListView um RecyclerView necessita de um LayoutManager (gerenciador de
        // layout) para gerenciar o posicionamento de seus itens. Utilizarei um LinearLayoutManager
        // que fará com que nosso RecyclerView se pareça com um ListView.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        estadosReciclerView.setLayoutManager(layoutManager);

        //Carrega a fonte de dados
        estadoList = EstadoDao.recuperateAll();

        estadoAdapter = new ItemEstadoAdapter(estadoList);
        estadosReciclerView.setAdapter(estadoAdapter);

        estadoAdapter.setClickListener(new RecyclerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String uf = estadoList.get(position).getUf();

                Intent in = new Intent(SelecionarEstadoActivity.this, EstadoActivity.class);
                in.putExtra("uf", uf);
                startActivity(in);

            }
        });
    }
}