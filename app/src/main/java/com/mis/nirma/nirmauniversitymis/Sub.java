package com.mis.nirma.nirmauniversitymis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sub extends AppCompatActivity {

    public final static int SUCCESS_RETURN_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final EditText editText3 = (EditText) findViewById(R.id.editText3);
        final EditText editText4 = (EditText) findViewById(R.id.editText4);
        final EditText editText5 = (EditText) findViewById(R.id.editText5);
        final EditText editText6 = (EditText) findViewById(R.id.editText6);
        final EditText editText7 = (EditText) findViewById(R.id.editText7);
        final EditText editText8 = (EditText) findViewById(R.id.editText8);
        final EditText editText9 = (EditText) findViewById(R.id.editText9);
        //final EditText editText10 = (EditText) findViewById(R.id.editText10);
        //final EditText editText11 = (EditText) findViewById(R.id.editText11);
        //final EditText editText12 = (EditText) findViewById(R.id.editText12);

        Button sendb = (Button) findViewById(R.id.sendb);

        sendb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle b = new Bundle();
                b.putString("Name", editText.getText().toString());
                b.putString("RollNumber", editText2.getText().toString());
                b.putString("Sem", editText3.getText().toString());
                b.putString("Birthdate", editText4.getText().toString());
                b.putString("StudentEmail", editText5.getText().toString());
                b.putString("StudentContactNumber", editText6.getText().toString());
                b.putString("PAddress", editText7.getText().toString());
                b.putString("semcount", editText8.getText().toString());
                b.putString("subcount", editText9.getText().toString());

                intent.putExtras(b);
                setResult(SUCCESS_RETURN_CODE, intent);
                finish();
            }
        });
    }
}
