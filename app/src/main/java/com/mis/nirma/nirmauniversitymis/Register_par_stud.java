package com.mis.nirma.nirmauniversitymis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register_par_stud extends AppCompatActivity {

    EditText pno,sname,sroll,pass;
    Button stud_submit,par_submit;
    TextView stuname,sturoll;
    String p_no,stu_name,stu_roll,stu_pass,par_pass;
    Boolean stat;
    datahandler_student dt;
    //datahandler_parent dtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_module);

        dt=new datahandler_student(this);
      //  dtp=new datahandler_parent(Register_par_stud.this);

        stuname=(TextView)findViewById(R.id.textView3);
        sturoll=(TextView)findViewById(R.id.textView5);
        pno=(EditText)findViewById(R.id.parent_no);
        sname=(EditText)findViewById(R.id.d_name);
        sroll=(EditText)findViewById(R.id.d_roll);
        pass=(EditText)findViewById(R.id.pass_regi);
        par_submit=(Button)findViewById(R.id.p_submit);
        stud_submit=(Button)findViewById(R.id.stud_submit);

        if(getIntent().getStringExtra("mode").equals("studentregister")){

            stud_submit.setVisibility(View.VISIBLE);
            sname.setVisibility(View.VISIBLE);
            sroll.setVisibility(View.VISIBLE);
            stud_submit.setVisibility(View.VISIBLE);
            pass.setVisibility(View.VISIBLE);
            pno.setVisibility(View.VISIBLE);
            stuname.setVisibility(View.VISIBLE);
            par_submit.setVisibility(View.INVISIBLE);
            stud_submit.setVisibility(View.VISIBLE);
            sturoll.setVisibility(View.VISIBLE);
            Toast.makeText(this, "student", Toast.LENGTH_SHORT).show();
        }
        else if(getIntent().getStringExtra("mode").equals("parentregister")){

            stud_submit.setVisibility(View.INVISIBLE);
            sname.setVisibility(View.INVISIBLE);
            sroll.setVisibility(View.VISIBLE);
            sturoll.setVisibility(View.VISIBLE);
            par_submit.setVisibility(View.VISIBLE);
            Toast.makeText(this, "parent", Toast.LENGTH_SHORT).show();
            stud_submit.setVisibility(View.INVISIBLE);
            pno.setVisibility(View.VISIBLE);
            stud_submit.setVisibility(View.INVISIBLE);
            pass.setVisibility(View.VISIBLE);
            stuname.setVisibility(View.INVISIBLE);
         }

        stud_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                p_no=pno.getText().toString();
                stu_roll=sroll.getText().toString();
                stu_pass=pass.getText().toString();
                stu_name=sname.getText().toString();

                if (TextUtils.isEmpty(p_no)) {
                    pno.setError("This cannot be empty");
                }

                if (TextUtils.isEmpty(stu_name)) {
                    sname.setError("This cannot be empty");
                }

                if (TextUtils.isEmpty(stu_roll)) {
                    sroll.setError("This cannot be empty");
                }

                stat=dt.insert(stu_name,stu_roll,stu_pass,p_no);
                Toast.makeText(Register_par_stud.this, "pass:"+stu_pass, Toast.LENGTH_SHORT).show();

                if(stat==true){
                    Toast.makeText(Register_par_stud.this, "Successfully Inserted", Toast.LENGTH_SHORT).show();
                    sname.getText().clear();
                    sroll.getText().clear();
                    pno.getText().clear();
                    pass.getText().clear();
                    Intent i =new Intent(Register_par_stud.this,LoginOptions.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Register_par_stud.this, "Unsuccessfull", Toast.LENGTH_SHORT).show();
                }
            }
        });

        par_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                p_no=pno.getText().toString();
                stu_roll=sroll.getText().toString();
                par_pass=pass.getText().toString();

                if (TextUtils.isEmpty(p_no)) {
                    pno.setError("This cannot be empty");
                }

                if (TextUtils.isEmpty(stu_name)) {
                    sname.setError("This cannot be empty");
                }

                if (TextUtils.isEmpty(stu_roll)) {
                    sroll.setError("This cannot be empty");
                }

                stat=dt.insertparent(p_no,stu_roll,par_pass);
                Toast.makeText(Register_par_stud.this, "pass:"+par_pass, Toast.LENGTH_SHORT).show();

                if(stat==true){
                    Toast.makeText(Register_par_stud.this, "Successfully Inserted", Toast.LENGTH_SHORT).show();
                    sname.getText().clear();
                    sroll.getText().clear();
                    pno.getText().clear();
                    pass.getText().clear();
                    Intent i =new Intent(Register_par_stud.this,LoginOptions.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Register_par_stud.this, "Unsuccessfull", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*
        getroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(p_no)) {
                    pno.setError("This cannot be empty");
                }
                p_no=pno.getText().toString();

                Cursor cur=dt.getdatafromParent(String.valueOf(p_no));
                if(cur.getCount() == 0){

                    Toast.makeText(Register_par_stud.this, "No Records Found", Toast.LENGTH_SHORT).show();
                    return;
                }
                while(cur.moveToNext()) {
                    Toast.makeText(Register_par_stud.this, p_no +" : "+ cur.getString(1) , Toast.LENGTH_SHORT).show();
                }
            }
        });
*/

    }
}
