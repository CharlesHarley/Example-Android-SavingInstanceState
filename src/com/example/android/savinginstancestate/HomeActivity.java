package com.example.android.savinginstancestate;

import android.app.Activity;
import android.os.Bundle;
import android.widget.NumberPicker;

public class HomeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        NumberPicker numberPicker1 = (NumberPicker) findViewById(R.id.number1);
        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(10);

        NumberPicker numberPicker2 = (NumberPicker) findViewById(R.id.number2);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(10);

        NumberPicker numberPicker3 = (NumberPicker) findViewById(R.id.number3);
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(10);
    }

}
