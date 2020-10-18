package br.edu.dmos5.projeto_iagorodrigues_dmos5.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.dmos5.projeto_iagorodrigues_dmos5.R;
import br.edu.dmos5.projeto_iagorodrigues_dmos5.model.Estado;

public class ItemEstadoAdapter extends RecyclerView.Adapter<ItemEstadoAdapter.EstadoViewHolder> {

    //A fonte de dados da implementação
    private List<Estado> estadoList;

    //Aqui implementamos um objeto que será responsável pelo tratamento do clique
    //no item de nosso RecyclerView
    private static RecyclerItemClickListener clickListener;

    //Construtor da classe
    public ItemEstadoAdapter(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }

    //Método setClickListener receberá a implamentação do clique no elemento da lista.
    //Essa implementação é forncedida MainActivity, por exemplo.
    public void setClickListener(RecyclerItemClickListener clickListener) {
        ItemEstadoAdapter.clickListener = clickListener;
    }

    /*
     Esse método precisa ser sobrescrito para que o tratamento adequado dos itens da RecyclerView
     seja realizado. Aqui configuraremos qual o layout que será utilizado e inflaremos esse layout.
     Tudo aqui é definido no ViewHolder.
    */
    @NonNull
    @Override
    public EstadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_estado, parent, false);

        EstadoViewHolder viewHolder = new EstadoViewHolder(view);

        return viewHolder;
    }

    /*
     Esse método é chamado sempre que um item do RecyclerView é apresentado, assim ele é responsável
     por reciclar os elementos de layout e configurar o que será apresentado na tela do aplicativo.
     */
    @Override
    public void onBindViewHolder(@NonNull EstadoViewHolder holder, final int position) {
        holder.textView_nomeEstado.setText(estadoList.get(position).getNome());
    }

    /*
     Como a fonte de dados não está na classe pai nosso adapter é quem deve devolver a quantidade
     de elementos. Esse método é que define o tamanho de nossa RecyclerView e é consultado sempre
     que a lista é rolada. Definir um valor inválido aqui pode causar falhas graves em nosso app.
     */
    @Override
    public int getItemCount() {
        return estadoList.size();
    }

    /*
     A inner class SitesViewHolder continua seguindo o mesmo padrão de projeto, contudo agora
     ela deve estender a classe ViewHolder do pacote RecyclerView.
     */
    /*
     Como queremos tratar o clique no item da RecyclerView temos que implementar o OnClickListener
     do pacote View.
     */
    public static class EstadoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView_nomeEstado;

        public EstadoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_nomeEstado = itemView.findViewById(R.id.text_estado);

            itemView.setOnClickListener(this);
        }

        /*
         Aqui tratamos o clique no item e não em elementos do item.
         */
        @Override
        public void onClick(View view) {
            if (clickListener != null)
                clickListener.onItemClick(getAdapterPosition());
        }
    }
}
