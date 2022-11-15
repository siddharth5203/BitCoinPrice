package com.example.bitcoinprice.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bitcoinprice.R;
import com.example.bitcoinprice.dbhelper.CountryDBHelper;
import com.example.bitcoinprice.entity.Country;

public class AddDataActivity extends AppCompatActivity {

    EditText editCode,editSymbol,editRate,editDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        editCode = findViewById(R.id.editCode);
        editSymbol = findViewById(R.id.editSymbol);
        editRate = findViewById(R.id.editRate);
        editDescription = findViewById(R.id.editDescription);

    }

    public void add(View view){
        Country country = new Country(Integer.parseInt(editCode.getText().toString()),
                editSymbol.getText().toString(),
                Double.parseDouble(editRate.getText().toString()),
                editDescription.getText().toString());

        CountryDBHelper dbhelper = new CountryDBHelper(this);
        dbhelper.addData(country);
        finish();
    }
}