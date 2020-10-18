package br.edu.dmos5.projeto_iagorodrigues_dmos5.api;

import br.edu.dmos5.projeto_iagorodrigues_dmos5.model.Estado;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("{estado}")
    Call<Estado> getDados(@Path("estado") String uf);
}
