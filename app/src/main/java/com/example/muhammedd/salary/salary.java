package com.example.muhammedd.salary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class salary extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);

        Bundle b=  getIntent().getExtras();

        textView = (TextView) findViewById(R.id.textView4);
        textView.setText(String.valueOf(b.getInt("salary"))+" LE");

    }
}
