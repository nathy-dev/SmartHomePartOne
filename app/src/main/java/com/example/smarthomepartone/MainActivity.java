package com.example.smarthomepartone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create Elements
        Spinner spinner = findViewById(R.id.spinner1);
        button = (Button) findViewById(R.id.button);

        //Populate Spinner & Set Click Listener
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sToSend = String.valueOf(spinner.getSelectedItem());
                Intent intent = new Intent(MainActivity.this, VideoReview.class);
                intent.putExtra("data", sToSend);
                startActivity(intent);

            }
        });



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Button mainButton = (Button)findViewById(R.id.button);
        if(text.equals("Select A Gesture")){
                    mainButton.setEnabled(false);
        }else{
            mainButton.setEnabled(true);
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}