package mx.edu.itl.c18131243.appsalondebelleza;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GridViewDetalleActivity extends AppCompatActivity {

    private ImageView imgvSesionDetalle;

    private ListView lstvPrecios;

    // Creamos los arreglos para cada una de las sesiones:

    //SESIÓN APLICACIÓN DE UÑAS
    private final String [] precios1 = { "Uñas Acrílicas",
                                      "Aplicación de gelish",
                                      "Uñas esculturales",
                                      "Relleno acrílico",
                                      "Relleno acabado en gelish" };
    private final String [] descripciones1 = { "Cualquier diseño y largo en $250.00",
                "Decoración en manos y pies en $150.00",
                "Cualquier diseño y largo en $300.00",
                "Decorado sencillo en $100.00",
                "Decorado y largo en $80.00"
    };
    private final int [] logos1 = { R.drawable.unhas1,
                R.drawable.unhas2,
                R.drawable.unhas3,
                R.drawable.unhas4,
                R.drawable.unhas5
    };

    //SESIÓN MANICURE Y PEDICURE
    private final String [] precios2 = { "Manicure", "Pedicure"};
    private final String [] descripciones2 = { "Tiene un costo de $230.00",
                                              "Tiene un costo de $350.00"};
    private final int [] logos2 = { R.drawable.manicure, R.drawable.pedicure};

    //MAQUILLAJE Y PEINADOS
    private final String [] precios3 = { "Maquillaje sencillo y peinado recogido",
            "Maquillaje para fiesta y peinado con ondas",
            "Maquillaje y peinado profesional",
            "Maquillaje y peinado practicante"
    };
    private final String [] descripciones3 = { "Tiene un costo de $200.00",
            "Incluye pestaña 3D mink en $500.00",
            "Maquillistas con más de 1 año trabajando en el studio incluye pestañas y accesorios " +
                    "del cabello en $950.00",
            "Maquillistas nuevas trabajando en el studio incluye pestañas en $350.00"
    };
    private final int [] logos3 = { R.drawable.maq1,
            R.drawable.maq2,
            R.drawable.maq3,
            R.drawable.maq4
    };

    //TINTES Y CORTES DE CABELLO
    private final String [] precios4 = { "Tinte en cabello corto",
            "Tinte en cabello largo",
            "Tinte con retoque de raíz",
            "Tinte con baño de color",
            "Corte de cabello"
    };
    private final String [] descripciones4 = { "Tiene un costo de $200.00",
            "Tiene un costo de $350.00",
            "Tiene un costo de $150.00",
            "Tiene un costo de $120.00",
            "Cualquier largo en $100.00"
    };
    private final int [] logos4 = { R.drawable.tin1,
            R.drawable.tin2,
            R.drawable.tin3,
            R.drawable.tin4,
            R.drawable.tin5,
    };

    //------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_detalle);
        getSupportActionBar().hide();

        lstvPrecios = findViewById  ( R.id.lstvPrecios );
        imgvSesionDetalle = findViewById ( R.id.imgvSesionDetalle);

        // Recuperamos de los argumentos del activity el ID del drawable de la sesion a mostrar
        int sesion = getIntent().getIntExtra("sesion", 0);

        int variable = getIntent().getIntExtra("variable", 0);

        // Cargar el recurso ImageView
        imgvSesionDetalle.setImageResource ( sesion );

        switch(variable){
                case 0: {
                    // Establecemos el Adapter para el ListView, el adapter será un objeto MiAdaptador
                    MiAdaptador adaptador = new MiAdaptador(this, precios1, descripciones1, logos1);
                    lstvPrecios.setAdapter(adaptador);

                    // Establecemos el listener para el evento OnItemClick  del ListView
                    lstvPrecios.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick ( AdapterView<?> adapterView, View view, int i, long l) {

                            Toast.makeText(getApplicationContext(), descripciones1[i] , Toast.LENGTH_SHORT).show();
                        }
                    });
                } break;
                case 1: {
                    // Establecemos el Adapter para el ListView, el adapter será un objeto MiAdaptador
                    MiAdaptador adaptador = new MiAdaptador(this, precios2, descripciones2, logos2);
                    lstvPrecios.setAdapter(adaptador);

                    // Establecemos el listener para el evento OnItemClick  del ListView
                    lstvPrecios.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick ( AdapterView<?> adapterView, View view, int i, long l) {

                            Toast.makeText(getApplicationContext(), descripciones2[i] , Toast.LENGTH_SHORT).show();
                        }
                    });
                } break;
                case 2: {
                    // Establecemos el Adapter para el ListView, el adapter será un objeto MiAdaptador
                    MiAdaptador adaptador = new MiAdaptador(this, precios3, descripciones3, logos3);
                    lstvPrecios.setAdapter(adaptador);

                    // Establecemos el listener para el evento OnItemClick  del ListView
                    lstvPrecios.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick ( AdapterView<?> adapterView, View view, int i, long l) {

                            Toast.makeText(getApplicationContext(), descripciones3[i] , Toast.LENGTH_SHORT).show();
                        }
                    });
                } break;
                case 3: {
                    // Establecemos el Adapter para el ListView, el adapter será un objeto MiAdaptador
                    MiAdaptador adaptador = new MiAdaptador(this, precios4, descripciones4, logos4);
                    lstvPrecios.setAdapter(adaptador);

                    // Establecemos el listener para el evento OnItemClick  del ListView
                    lstvPrecios.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick ( AdapterView<?> adapterView, View view, int i, long l) {

                            Toast.makeText(getApplicationContext(), descripciones4[i] , Toast.LENGTH_SHORT).show();
                        }
                    });
                } break;
        }

    }

    //----------------------------------------------------------------------------------------------
    class MiAdaptador extends ArrayAdapter {
        private Context contexto;
        private String [] precios;
        private String [] descripciones;
        private int [] logos;

        public MiAdaptador ( Context contexto, String [] precios, String [] descripciones, int [] logos){
            super(contexto, R.layout.list_fila_texto_imagen, R.id.txtvTitulo, precios);
            this.contexto = contexto;
            this.precios = precios;
            this.descripciones = descripciones;
            this.logos = logos;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if(convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater)
                        contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.list_fila_texto_imagen,
                        parent, false);
            }

            ImageView logo = convertView.findViewById( R.id.imgvLogo);
            TextView titulo = convertView.findViewById(R.id.txtvTitulo);
            TextView subtitulo = convertView.findViewById(R.id.txtvSubtitulo);

            // Poner nuestros recursos en los Views
            logo.setImageResource(logos [position]);
            titulo.setText(precios [position]);
            subtitulo.setText(descripciones[position]);

            return convertView;

            //return super.getView(position, convertView, parent);
        }
    }
}