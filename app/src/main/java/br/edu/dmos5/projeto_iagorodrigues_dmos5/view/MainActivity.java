package br.edu.dmos5.projeto_iagorodrigues_dmos5.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.dmos5.projeto_iagorodrigues_dmos5.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Constantes
    private static final int REQUEST_PERMISSION = 64;
    private static final int REQUEST_ESTADO = 98;

    //Elementos de layout
    private TextView infos;
    private Button buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLayoutElements();
    }


    private void getLayoutElements() {
        //O texto de informações começa visível
        this.infos = findViewById(R.id.infos);
        this.infos.setVisibility(View.VISIBLE);

        this.buscar = findViewById(R.id.button_buscar);
        this.buscar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_buscar) {
            if (temPermissao()) {
                buscarEstado();
            } else {
                solicitaPermissao();
            }
        }
    }

    private boolean temPermissao(){
        System.out.println("tem Permissão");

        return ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED;
    }

    private void solicitaPermissao(){
        System.out.println("solicitaPermissao");

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET)) {
            System.out.println("solicitaPermissao if1");
            final Activity activity = this;
            new AlertDialog.Builder(this)
                    .setMessage(R.string.explicacao_permissao)
                    .setPositiveButton(R.string.botao_fornecer, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.INTERNET}, REQUEST_PERMISSION);
                        }
                    })
                    .setNegativeButton(R.string.botao_nao_fornecer, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
        } else {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{
                            Manifest.permission.INTERNET
                    },
                    REQUEST_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        System.out.println("onRequestPermissionsResult");

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION) {
            for (int i = 0; i < permissions.length; i++) {
                System.out.println("onRequestPermissionsResult if1");

                if (permissions[i].equalsIgnoreCase(Manifest.permission.INTERNET) && grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    System.out.println("onRequestPermissionsResult if2");
                    buscarEstado();
                }

            }
        }
    }

    private void buscarEstado() {
        System.out.println("Chamou estado");

        Intent in = new Intent(this, SelecionarEstadoActivity.class);
        startActivityForResult(in, REQUEST_ESTADO);
    }

}