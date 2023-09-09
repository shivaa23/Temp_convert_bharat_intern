package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText ed;
    Spinner sp;
    Button btn;
    TextView showRes, toggle;
    Double val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed = findViewById(R.id.editInput);
        sp = findViewById(R.id.spinner_id);
        btn = findViewById(R.id.button_id);
        showRes = findViewById(R.id.textResult);
        toggle = findViewById(R.id.textResultType);

        String from[] = {"Fahrenheit", "Celsius"};

        ArrayAdapter arrayAdapter = new ArrayAdapter<String >(this, R.layout.item_file, from);
        sp.setAdapter(arrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed.getText().toString().isEmpty()) showRes.setText("Please Enter A Temperature!");
                else{
                    val = Double.parseDouble(String.valueOf(ed.getText()));
                    if(sp.getSelectedItem().toString() == "Celsius") {
                        val = (val * 9) / 5 + 32;
                        toggle.setText("Fahrenheit");
                    }
                    else {
                        val = (val - 32) * 5 / 9;
                        toggle.setText("Celsius");
                    }

                    val = Math.round(val*100.0)/100.0;
                    showRes.setText(String.valueOf(val) + " ");
                }
            }
        });
    }


}