package com.example.diegocg.appcontrollerbluetooth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private boolean logAttivo = true;
    private SeekBar destro;
    private SeekBar sinistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(logAttivo) Log.i("MainActivity", "onCreate");
        inizializzaView();
    }
    private void inizializzaView()
    {
        if(logAttivo)Log.i("MainActivity", "inizializzaView");
        setContentView(R.layout.activity_main);

        destro = (SeekBar) findViewById(R.id.destro);
        // Aggiungo il listener
        destro.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // Quando lo sterzo subisce dei cambiamenti elaboro il nuovo comando.
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(logAttivo)Log.i("destro", "onProgressChanged");
                elaborazione();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sinistro = (SeekBar) findViewById(R.id.sinistro);
        sinistro.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(logAttivo)Log.i("sinistro", "onProgressChanged");
                elaborazione();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private void elaborazione()
    {
        
    }
}
