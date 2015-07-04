package dm.feevale.br.tiposinterface;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class InterfacePrincipal extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_principal);
    }

    public void executaLogin( View v ) {

        EditText nome = (EditText) findViewById( R.id.edtNome );
        EditText senha = (EditText) findViewById( R.id.edtSenha );

        if( nome.getText().toString().equals( "malu" ) ) {

            if( senha.getText().toString().equals( "111" ) ) {
                Toast.makeText( this,
                        getText( R.string.msg_bemvinda ) + nome.getText().toString(),
                        Toast.LENGTH_LONG ).show();
                return;
            }
        }

/*
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Atenção" );
        builder.setMessage( "Usuário ou Senha inválida" );
        builder.setPositiveButton( "OK", null );
        builder.show();
*/
        new AlertDialog.Builder( this )
            .setTitle( "Atenção" )
            .setMessage( "Usuário ou Senha inválida" )
            .setPositiveButton( "OK", null )
            .show();

    }

    public void vai( View v ) {
        setContentView(R.layout.tela_dois);
    }

    public void volta( View v ) {
        setContentView(R.layout.activity_interface_principal);
    }

    public void trocaActivity( View v ) {

        Intent i = new Intent( this, TelaEntrada.class );
        startActivity( i );
    }

    public void buscaCampos( View v ) {

        Intent i = new Intent( this, TelaEntrada.class );
        startActivityForResult( i, 1 );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if( requestCode == 1 ) {

            if( resultCode == RESULT_OK ) {

                String dsNome = data.getExtras().getString( "nome" );
                String dsSenha = data.getExtras().getString( "senha" );

                EditText nome = (EditText) findViewById( R.id.edtNome );
                EditText senha = (EditText) findViewById( R.id.edtSenha );

                nome.setText( dsNome );
                senha.setText( dsSenha );
            }
        }

    }
}





















