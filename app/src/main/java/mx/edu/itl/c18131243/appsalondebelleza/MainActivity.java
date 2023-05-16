package mx.edu.itl.c18131243.appsalondebelleza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Definir el manejador del onClick sobre el layout principal, cuando se de click sobre el
        // layout la clase ClickLayoutAdapter  manejará el evento
        layout = (LinearLayout) findViewById ( R.id.id_layout );
    }

    // Creamos el menu de la Actividad que aparecerá en la barra de acciones (ActionBar)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate ( R.menu.menu_main_activity, menu );
        return super.onCreateOptionsMenu(menu);
    }

    // Manejamos las selecciones en el menu de la Actividad
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch ( id ) {
            case R.id.mniDatosPersonales: {
                Intent i = new Intent ( this, DatosPersonalesActivity.class );
                startActivity ( i );
            } break;
            case R.id.mniAcercaDe: {
                Intent i = new Intent ( this, AcercaDeActivity.class );
                startActivity ( i );
            } break;
            case R.id.mniSalir      :          finish ();
            default                 :          return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onBackPressed () {
        // Hacer nada cuando se pulse el boton ATRAS del dispositivo
        Toast.makeText ( this, "Use la opcion Salir del menu", Toast.LENGTH_SHORT ).show ();
    }

    public void btnAgendarCita (View v){
        Intent intent = new Intent ( this, AgendarCitaActivity.class );
        startActivity ( intent );
    }

    public void btnVerCitas (View v) {
        Intent intent = new Intent ( this, VerCitasActivity.class );
        startActivity ( intent );
    }

    public void btnPrecios (View v) {
        Intent intent = new Intent ( this, PreciosActivity.class );
        startActivity ( intent );
    }

    public void btnVisitanos (View v) {
        Intent intent = new Intent ( this, ConocenosActivity.class );
        startActivity ( intent );
    }
}