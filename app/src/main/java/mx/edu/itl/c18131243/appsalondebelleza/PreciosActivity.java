package mx.edu.itl.c18131243.appsalondebelleza;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class PreciosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    final Integer [] sesiones = { R.drawable.aplicacionunhas, R.drawable.manicuraypedicura,
            R.drawable.maquillajeypeinados,   R.drawable.tintesycortes};

    private GridView grdvPrecios;
    private GridAdaptador  adaptador;

    //------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView ( R.layout.activity_grid_view);

        // Crear el Adapter y establecerlo como adapter en el GridView
        grdvPrecios = findViewById(R.id.grdvPrecios);
        adaptador = new GridAdaptador(this, R.layout.gridview_item_imagen, sesiones);
        grdvPrecios.setAdapter(adaptador);
        grdvPrecios.setOnItemClickListener(this);
    }

    //------------------------------------------------------------------------------------------

    @Override
    public void onItemClick (AdapterView<?> adapterView, View view, int i, long l ) {
        Intent intent = new Intent( this, GridViewDetalleActivity.class );

        // Pasamos como argumento al otro activity el ID del recurso drawable de la sesion seleccionada
        intent.putExtra ( "sesion", sesiones [ i ] );
        intent.putExtra ( "variable", i);
        startActivity ( intent );
    }

    //------------------------------------------------------------------------------------------

    public class GridAdaptador extends ArrayAdapter {
        private Integer [] sesiones;
        private int        layoutResId;
        private LayoutInflater inflater;

        //------------------------------------------------------------------------------------------
        // Constructor

        public GridAdaptador(@NonNull Context context, int resource, @NonNull Integer [] sesiones ) {
            // Llamar al constructor de la clase padre y guardar los argumentos en variables de la clase
            super(context, resource, sesiones);
            this.sesiones = sesiones;
            layoutResId = resource;
            inflater = LayoutInflater.from(context);
        }

        //------------------------------------------------------------------------------------------

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // Implementar la personalizacion de convertView inflando primero el layout que va a utilizar
            if (convertView == null) {
                convertView = inflater.inflate(layoutResId, parent, false);
            }

            ImageView imgSesiones = convertView.findViewById(R.id.imgvSesion);
            imgSesiones.setScaleType(ImageView.ScaleType.FIT_XY);

            //Si al hacer deslizamiento por las imagenes se alenta se debera sustituir la forma
            // tradicional de cargar el drawable por una forma mas eficiente , por ejemplo con la
            //libreria Glide de BumpTech.
            imgSesiones.setImageResource(sesiones [position] );
            //Glide.with (imgEscudo.getContext() ).load (escudos [position] ).into (imgEscudo);
            return convertView;
        }

        //------------------------------------------------------------------------------------------
    }
}