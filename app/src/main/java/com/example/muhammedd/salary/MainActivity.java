package com.example.muhammedd.salary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int hour_rate = 0;
    RadioGroup radiogroup;
    RadioButton radiobtn;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    int selectedOption = radiogroup.getCheckedRadioButtonId();
                    radiobtn = (RadioButton) findViewById(selectedOption);
                    Log.i("hour rate", String.valueOf(hour_rate));
                    Log.i("text", radiobtn.getText().toString());
                    if (radiobtn.getText().equals("Security man")) {
                        hour_rate = 10;
                        Log.i("hour rate", String.valueOf(hour_rate));
                    } else if (radiobtn.getText().equals("Accountant")) {
                        hour_rate = 25;
                        Log.i("hour rate", String.valueOf(hour_rate));
                    } else if (radiobtn.getText().equals("Instructor")) {
                        hour_rate = 50;
                        Log.i("hour rate", String.valueOf(hour_rate));
                    }
                    Log.i("hour rate", String.valueOf(hour_rate));

                    int worked_hours = Integer.parseInt(editText.getText().toString()) ;
                    int salary = 0;
                    if(worked_hours<=40){
                        salary = worked_hours*hour_rate;
                        Log.i("salary",String.valueOf(salary));
                    }else{
                        salary = (int) ((worked_hours*hour_rate)*1.5);
                        Log.i("salary overtime",String.valueOf(salary));
                    }

                    Intent intent = new Intent(getApplicationContext(), com.example.muhammedd.salary.salary.class);
                    intent.putExtra("salary",salary);
                    startActivity(intent);

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Please Check the fields above!",Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
