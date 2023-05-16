/*------------------------------------------------------------------------------------------
:*                              TECNOLOGICO NACIONAL DE MEXICO
:*                                      CAMPUS LA LAGUNA
:*                          INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                                  DESARROLLO EN ANDROID "A"
:*
:*                           SEMESTRE: ENE-JUN/2022 HORA: 10-11 HRS
:*
:*                    Clase que muestra en pantalla un splash durante 3 segundos
:*
:* Archivo : SplashActivity.java
:* Autor : Gómez Montes Zaida Sugey 18131243
:* Fecha : 03/mar/2022
:* Compilador : Android Studio Artic Fox 2020.3
:* Descripci�n : Esta clase muestra un splash y hace la transición al siguiente activity
:*                despues de 3 segundos con ayuda de la clase Handler usando el método PostDelay().
:* Ultima modif:
:* Fecha Modific� Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c18131243.appsalondebelleza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {
    //----------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //La pantalla de splash se presentará en orientacion vertical y en pantallla completa
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        //Ocultar la barra de acciones ActionBar
        this.getSupportActionBar().hide();

        setContentView(R.layout.activity_splash);
        //------------------------------------------------------------------------------------------
        //Hacer la transicion al siguiente Activity despues de 3 segs.
        new Handler().postDelayed ( new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent (SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); //indicar que termine despues de ejecutarse
            }
        }, 3000);
    }

}