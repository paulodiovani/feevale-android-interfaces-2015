package dm.feevale.br.tiposinterface;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TelaEntrada extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.tela_entrada );
    }

    public void volta( View v ) {
        finish();
    }

    public void voltaComDados( View v ) {

        EditText nome = (EditText) findViewById( R.id.edtNome );
        EditText senha = (EditText) findViewById( R.id.edtSenha );

        String dsNome = nome.getText().toString();
        String dsSenha = senha.getText().toString();

        if( dsNome.trim().length() == 0 ) {

            new AlertDialog.Builder( this )
                    .setTitle( R.string.ttl_atencao )
                    .setMessage( R.string.msg_preencha_nome )
                    .setPositiveButton( "OK", null )
                    .show();
            return;
        }

        if( dsSenha.trim().length() == 0 ) {

            new AlertDialog.Builder( this )
                    .setTitle( R.string.ttl_atencao )
                    .setMessage( R.string.msg_preencha_senha )
                    .setPositiveButton( "OK", null )
                    .show();
            return;
        }

        Intent dadosVolta = new Intent();
        dadosVolta.putExtra( "nome", dsNome );
        dadosVolta.putExtra( "senha", dsSenha );
        setResult( RESULT_OK, dadosVolta );
    }
}



















