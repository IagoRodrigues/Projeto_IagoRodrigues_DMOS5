package br.edu.dmos5.projeto_iagorodrigues_dmos5.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.dmos5.projeto_iagorodrigues_dmos5.model.Estado;

public class EstadoDao {
    private SQLiteDatabase mDatabase;
    private SQLiteHelper mHelper;

    public EstadoDao(Context context) {
        mHelper = new SQLiteHelper(context);

        if(buscaTodos().size() == 0) {
            carregaBase();
        }
    }

    private void carregaBase() {
        this.adiciona((new Estado("Minas Gerais", "mg")));
        this.adiciona(new Estado("São Paulo", "sp"));
        this.adiciona(new Estado("Rio Grande do Sul", "rs"));
        this.adiciona(new Estado("Bahia", "ba"));
        this.adiciona(new Estado("Paraná", "pr"));
        this.adiciona(new Estado("Santa Catarina", "sc"));
        this.adiciona(new Estado("Goiás", "go"));
        this.adiciona(new Estado("Piauí", "pi"));
        this.adiciona(new Estado("Paraíba", "pb"));
        this.adiciona(new Estado("Maranhão", "ma"));
        this.adiciona(new Estado("Pernanbuco", "pb"));
        this.adiciona(new Estado("Ceará", "ce"));
        this.adiciona(new Estado("Rio Grande do Norte", "rn"));
        this.adiciona(new Estado("Pará", "pa"));
        this.adiciona(new Estado("Mato Grosso", "mt"));
        this.adiciona(new Estado("Tocantins", "to"));
        this.adiciona(new Estado("Alagoas", "al"));
        this.adiciona(new Estado("Rio de Janeiro", "rj"));
        this.adiciona(new Estado("Mato Grosso do Sul", "ms"));
        this.adiciona(new Estado("Espírito Santo", "es"));
        this.adiciona(new Estado("Sergipe", "se"));
        this.adiciona(new Estado("Amazonas", "am"));
        this.adiciona(new Estado("Rondônia", "ro"));
        this.adiciona(new Estado("Acre", "ac"));
        this.adiciona(new Estado("Amapá", "ap"));
        this.adiciona(new Estado("Roraima", "rr"));
    }

    public List<Estado> buscaTodos(){
        List<Estado> mLista = new ArrayList<>();
        Estado mEstado;

        // O Cursos funciona como um ResultSet, ele possui uma tabela temporária com os
        // dados que foram recuperados do banco. O ponteiro inicialmente aponta para null.
        Cursor mCursor;
        //Aqui é feita uma conexão com o banco de dados com direito de leitura.
        mDatabase = mHelper.getReadableDatabase();

        // Para definirmos quais as colunas que desejamos e a ordem de apresentação, cria-se um
        // vetor de Strings com o nome de cada coluna que será devolvida na consulta.
        String colunas[] = new String[] {
                SQLiteHelper.COLUMN_NOME,
                SQLiteHelper.COLUMN_UF
        };
        
        // A consulta no banco de dados é retornada para um Cursor. A query passada já é formatada
        // para facilitar a programação. Nesse momento estou indicando apenas o nome da tabela (
        // TABLE_NAME), as colunas da consulta e a ordenação (COLUMN_TITULO). Os demais argumentos
        // serão trabalhados no fututo.
        mCursor = mDatabase.query(
                SQLiteHelper.TABLE_NAME,
                colunas,
                null,
                null,
                null,
                null,
                SQLiteHelper.COLUMN_NOME
        );

        // O cursor consegue recuperar o tipo específico do dado, porém é preciso informar
        // qual a ordem da coluna iniciando de zero.
        // Após recuperar o dado ele é inserido na lista e devolvido como argumento.
        while (mCursor.moveToNext()){
            mEstado = new Estado(
                    mCursor.getString(0),
                    mCursor.getString(1)
            );
            mLista.add(mEstado);
        }
        mCursor.close();
        mDatabase.close();
        return mLista;
    }

    // Mais fácil que consultar é salvar um dado, basta indicar em um ContentValues ou seja, em
    // um objeto que armazena chave e valor e solicitar que os dados sejam salvos no banco de
    // dados. Atenção pois o nome das colunas deve ser sempre o mesmo.
    public void adiciona(Estado estado){
        mDatabase = mHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_NOME, estado.getNome());
        values.put(SQLiteHelper.COLUMN_UF, estado.getUf());
        
        mDatabase.insert(SQLiteHelper.TABLE_NAME, null, values);
        mDatabase.close();
    }

    // A única diferença entre salva um novo dado e editar um dado existente é a configuração
    // da clausula where que é feita em uma string.
    public void atualiza(Estado estado){
        mDatabase = mHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_UF, estado.getUf());

        String where = SQLiteHelper.COLUMN_NOME + " = '" + estado.getNome() + "'";
        mDatabase.update(SQLiteHelper.TABLE_NAME, values, where, null);
        mDatabase.close();
    }
}
