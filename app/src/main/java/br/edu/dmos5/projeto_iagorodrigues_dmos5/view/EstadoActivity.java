package br.edu.dmos5.projeto_iagorodrigues_dmos5.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.dmos5.projeto_iagorodrigues_dmos5.R;
import br.edu.dmos5.projeto_iagorodrigues_dmos5.api.RetrofitService;
import br.edu.dmos5.projeto_iagorodrigues_dmos5.model.Estado;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EstadoActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String BASE_URL = "https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/";

    //Elementos de layout
    private TextView infos;
    private TextView estado;
    private TextView casos;
    private TextView mortes;
    private TextView suspeitos;
    private TextView negativos;

    private Button seguir;

    //Necessário para a API
    private Retrofit mRetrofit;
    private String uf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado);

        this.uf = getIntent().getStringExtra("uf");

        realizaBusca();

        getLayoutElements();
    }

    private void realizaBusca() {
        mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService mRetrofitService = mRetrofit.create(RetrofitService.class);

        Call<Estado> call = mRetrofitService.getDados(this.uf);
        
        call.enqueue(new Callback<Estado>() {
            @Override
            public void onResponse(Call<Estado> call, Response<Estado> response) {
                if(response.isSuccessful()){
                    Estado meuEstado = response.body();
                    updateUI(meuEstado);
                }
            }

            @Override
            public void onFailure(Call<Estado> call, Throwable t) {
                Toast.makeText(EstadoActivity.this, getString(R.string.erro_api), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateUI(Estado meuEstado) {
        if(meuEstado != null){
            System.out.println(meuEstado);

            estado.setText(meuEstado.getNome());
            casos.setText(meuEstado.getCases());
            mortes.setText(meuEstado.getDeaths());
            suspeitos.setText(meuEstado.getSuspects());
            negativos.setText(meuEstado.getRefuses());
        }
    }

    private void getLayoutElements() {
        this.estado = findViewById(R.id.textView_estado);
        this.casos = findViewById(R.id.textView_casos);
        this.mortes = findViewById(R.id.textView_mortes);
        this.suspeitos = findViewById(R.id.textView_suspeitos);
        this.negativos = findViewById(R.id.textView_nagativos);

        this.seguir = findViewById(R.id.button_follow);
        this.seguir.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}