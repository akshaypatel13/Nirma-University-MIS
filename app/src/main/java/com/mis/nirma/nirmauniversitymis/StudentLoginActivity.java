package com.mis.nirma.nirmauniversitymis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.HashMap;


public class StudentLoginActivity extends AppCompatActivity {

    String TTDataString;
    String subcode,sub,faculty,day,stime,etime,classroom;
    public static int cnt=0;
    String TAG = "Response";
    Button student_login_button,student_reg_button,parent_login_button,parent_reg_button;
    EditText username,password;
    String user,pass,p_no;
    SoapPrimitive personalInfoData, ResultData, AttendanceData,TTData;
    datahandler_student dt;
    public static String val="no";
    ProgressBar loginprogress;

    public static String Name = "";
    public static String RegistrationNo = "";
    public static String ProgramBranch = "";
    public static String Semester = "";
    public static String DateOfBirth = "";
    public static String BloodGroup = "";

    public static String StudentEmailID = "";
    public static String StudentContactNumber = "";
    //public static String ParentEmailID = "Parent Email-ID:-\t\t\t";
    public static String ParentContactNumber = "";

    //public static String PermanentAddress = "Permanent Address:-\t\t\t";
    public static String CurrentAddress = "";


    public  static  String ActualName = " ";

    public static ArrayList<ArrayList<String>> semesters = new ArrayList<>();

    public static ArrayList<ArrayList<String>> subjects = new ArrayList<>();

    static HashMap < String , HashMap<String,Integer>> subject = new HashMap<String , HashMap<String, Integer> >();

    public static ArrayList<ArrayList<String>> schedule = new ArrayList<>();

    static String[][] monarr=new String[6][5];

    static String[][] tuearr=new String[6][5];

    static String[][] wedarr=new String[6][5];

    static String[][] thurarr=new String[6][5];

    static String[][] friarr=new String[6][5];


    public static ArrayList<String> mon = new ArrayList<>();

    public static ArrayList<String> tue = new ArrayList<>();

    public static ArrayList<String> wed = new ArrayList<>();

    public static ArrayList<String> thur = new ArrayList<>();

    public static ArrayList<String> fri = new ArrayList<>();


    public static String[][] getmonarr(){
        return monarr;
    }

    public static String[][] gettuearr(){
        return tuearr;
    }

    public static String[][] getwedarr(){
        return wedarr;
    }

    public static String[][] getthurarr(){
        return thurarr;
    }

    public static String[][] getfriarr(){
        return friarr;
    }

    public static String getName(){
        return Name;
    }

    public static String getRegistrationNo(){
        return RegistrationNo;
    }

    public static String getDateOfBirth(){
        return DateOfBirth;
    }

    public static String getProgramBranch(){
        return ProgramBranch;
    }

    public static String getSemester(){
        return Semester;
    }

    public static String getBloodGroup(){
        return BloodGroup;
    }

    public static String getStudentEmailID(){
        return StudentEmailID;
    }

    public static String getStudentContactNumber(){
        return StudentContactNumber;
    }

    /*public static String getParentEmailID(){
        return ParentEmailID;
    } */

    public static String getParentContactNumber(){
        return ParentContactNumber;
    }

    /*public static String getPermanentAddress(){
        return PermanentAddress;
    } */

    public static String getCurrentAddress(){
        return CurrentAddress;
    }

    public  static  String getActualName(){
        return ActualName;
    }

    public static ArrayList getSemesters(){
        return semesters;
    }

    public static HashMap<String, HashMap<String,Integer>> getSubject(){
        return subject;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        dt=new datahandler_student(this);
        loginprogress = (ProgressBar) findViewById(R.id.login_progress);

        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.password);
        student_reg_button = (Button) findViewById(R.id.student_register);
        student_login_button = (Button) findViewById(R.id.student_login);
        parent_reg_button = (Button) findViewById(R.id.parent_register);
        parent_login_button = (Button) findViewById(R.id.parent_login);

        username.setVisibility(View.VISIBLE);
        username.requestFocus();
        if(getIntent().getStringExtra("id").equals("student") ) {

            parent_reg_button.setVisibility(View.INVISIBLE);
            parent_login_button.setVisibility(View.INVISIBLE);
            student_reg_button.setVisibility(View.VISIBLE);
            student_login_button.setVisibility(View.VISIBLE);
            username.setHint("Roll No");
            getSupportActionBar().setTitle("Student Login");

        }
        else{// if(getIntent().getStringExtra("id").equals("parent") ) {

            student_reg_button.setVisibility(View.INVISIBLE);
            student_login_button.setVisibility(View.INVISIBLE);
            parent_reg_button.setVisibility(View.VISIBLE);
            parent_login_button.setVisibility(View.VISIBLE);
            username.setHint("Parent No");
            getSupportActionBar().setTitle("Parent Login");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.package.ACTION_LOGOUT");
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("onReceive", "Logout in progress");
                semesters.clear();
                subject.clear();
                mon.clear();

                finish();
            }
        }, intentFilter);
        student_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isNetworkAvailable(getApplicationContext())) {

                    user = username.getText().toString();
                    pass = password.getText().toString();

                    if (TextUtils.isEmpty(user)) {
                        Toast.makeText(StudentLoginActivity.this, "Any of the fields cannot be empty", Toast.LENGTH_SHORT).show();
                    } else {

                        /*
                        datahandler_student dt = new datahandler_student(StudentLoginActivity.this);
                        Cursor cur = dt.getdatafromRoll(user);

                        if (cur.getCount() == 0) {

                            Toast.makeText(StudentLoginActivity.this, "No Records Found", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        String db_pass="";
                        while (cur.moveToNext()) {

                            db_pass = cur.getString(2);
                            Toast.makeText(StudentLoginActivity.this, user + " : " + cur.getString(0) , Toast.LENGTH_SHORT).show();
                        }
                        */
                        AsyncCallWS task = new AsyncCallWS();
                        task.execute();
                        loginprogress.setVisibility(View.VISIBLE);
                        password.setVisibility(View.INVISIBLE);
                        student_reg_button.setVisibility(View.INVISIBLE);
                        student_login_button.setVisibility(View.GONE);
                        username.setVisibility(View.GONE);

                        /*
                        if (pass.equals(db_pass)) {
                            AsyncCallWS task = new AsyncCallWS();
                            task.execute();
                            loginprogress.setVisibility(View.VISIBLE);
                            password.setVisibility(View.INVISIBLE);
                            student_reg_button.setVisibility(View.INVISIBLE);
                            student_login_button.setVisibility(View.GONE);
                            username.setVisibility(View.GONE);
                        }
                        else{
                            Toast.makeText(StudentLoginActivity.this, "Password Incorrect.", Toast.LENGTH_SHORT).show();
                        }
                        */
                    }

                } else {
                    Toast.makeText(getApplicationContext(),"No Internet Connection.Try Again.",Toast.LENGTH_SHORT).show();
                }


            }
        });

        student_reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(StudentLoginActivity.this,Register_par_stud.class);
                i.putExtra("mode","studentregister");
                startActivity(i);

            }
        });

        parent_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isNetworkAvailable(getApplicationContext())) {

                    p_no = username.getText().toString();
                    pass = password.getText().toString();

                    if (TextUtils.isEmpty(p_no) || TextUtils.isEmpty(pass)) {
                        Toast.makeText(StudentLoginActivity.this, "Any of the fields cannot be empty", Toast.LENGTH_SHORT).show();
                    } else {

                        Cursor cur = dt.getdatafromParentNo(p_no);

                        if (cur.getCount() == 0) {

                            Toast.makeText(StudentLoginActivity.this, "No Records Found", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        String db_pass="";
                        while (cur.moveToNext()) {

                            db_pass = cur.getString(2);
                            user = cur.getString(1);
                            Toast.makeText(StudentLoginActivity.this,"Pass  : " + cur.getString(2) , Toast.LENGTH_SHORT).show();
                        }

                        if (pass.equals(db_pass)) {

                                /*while (cur.moveToNext()) {

                                    user = cur.getString(1);
                                    Toast.makeText(StudentLoginActivity.this,"Roll : " + cur.getString(1) , Toast.LENGTH_SHORT).show();
                                }*/

                            AsyncCallWS task = new AsyncCallWS();
                            task.execute();
                            loginprogress.setVisibility(View.VISIBLE);
                            password.setVisibility(View.INVISIBLE);
                            student_reg_button.setVisibility(View.INVISIBLE);
                            student_login_button.setVisibility(View.GONE);
                            parent_reg_button.setVisibility(View.INVISIBLE);
                            parent_login_button.setVisibility(View.GONE);
                            username.setVisibility(View.GONE);

                        }
                        else{
                            Toast.makeText(StudentLoginActivity.this, "Password Incorrect.", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {
                    Toast.makeText(getApplicationContext(),"No Internet Connection.Try Again.",Toast.LENGTH_SHORT).show();
                }


            }
        });

        parent_reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(StudentLoginActivity.this,Register_par_stud.class);
                i.putExtra("mode","parentregister");
                startActivity(i);

            }
        });



    }

    private class AsyncCallWS extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
        }

        @Override
        protected Void doInBackground(Void... params) {
            Log.i(TAG, "doInBackground");
            //requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
            //setProgressBarIndeterminateVisibility(true);

            calculateInfo();
            getTT();
            calculateResult();
            getAttendance();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
            //setProgressBarIndeterminateVisibility(false);
            loginprogress.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(),"You are logged in.",Toast.LENGTH_SHORT).show();
            Toast.makeText(StudentLoginActivity.this, ""+TTDataString, Toast.LENGTH_SHORT).show();
            Toast.makeText(StudentLoginActivity.this, ""+val+" "+cnt, Toast.LENGTH_SHORT).show();
if(!(val.equals("no"))) {
/*    for(int i=0;i<6;i++) {
        Toast.makeText(StudentLoginActivity.this, "" + mon.get(i), Toast.LENGTH_SHORT).show();
        Toast.makeText(StudentLoginActivity.this, "Mon : " +monarr[i][0]+" : "+ monarr[i][2], Toast.LENGTH_SHORT).show();
        Toast.makeText(StudentLoginActivity.this, "Tue : " +tuearr[i][0]+" : "+ tuearr[i][2], Toast.LENGTH_SHORT).show();
        Toast.makeText(StudentLoginActivity.this, "Wed : " +wedarr[i][0]+" : "+ wedarr[i][2], Toast.LENGTH_SHORT).show();
        Toast.makeText(StudentLoginActivity.this, "Thur : " +thurarr[i][0]+" : "+ thurarr[i][2], Toast.LENGTH_SHORT).show();
        Toast.makeText(StudentLoginActivity.this, "Fri : " +friarr[i][0]+" : "+ friarr[i][2], Toast.LENGTH_SHORT).show();

   } */
    Toast.makeText(StudentLoginActivity.this, "Data Received", Toast.LENGTH_SHORT).show();

}
            Intent i = new Intent(getApplicationContext(), NavigationActivity.class);
            startActivity(i);

        }

    }

    public boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public void calculateInfo() {
        String SOAP_ACTION_INFO = "http://tempuri.org/getStudentInformation";
        String METHOD_NAME_INFO = "getStudentInformation";
        String NAMESPACE = "http://tempuri.org/";
        String URL = "http://apps.nirmauni.ac.in/misservice/MISservicePK.asmx";

        try {
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME_INFO);

            Request.addProperty("Rollno", user);

            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = true;
            soapEnvelope.setOutputSoapObject(Request);

            HttpTransportSE transport = new HttpTransportSE(URL);

            transport.call(SOAP_ACTION_INFO, soapEnvelope);

            personalInfoData = (SoapPrimitive) soapEnvelope.getResponse();
            String personalInfoDataString = personalInfoData.toString();
            JSONArray arrayarray = new JSONArray(personalInfoDataString);
            for(int i=0;i<arrayarray.length();i++) {
                JSONObject jsonObject = arrayarray.getJSONObject(i);
                Name = "Name:-\t\t\t" + jsonObject.getString("NAME");
                ActualName = jsonObject.getString("NAME");
                RegistrationNo = "Registration No.:-\t\t\t" + jsonObject.getString("ENROLLMENTNO");
                ProgramBranch = "Program/Branch:-\t\t\t" + jsonObject.getString("PROGRAMCODE") + "/" + jsonObject.getString("BRANCHCODE");
                Semester = "Semester:-\t\t\t" + jsonObject.getString("STYNUMBER");
                DateOfBirth = "Date of Birth:-\t\t\t" + jsonObject.getString("DATEOFBIRTH");
                BloodGroup = "BloodGroup:-\t\t\t" + jsonObject.getString("BLOODGROUP");
                StudentEmailID = "Student Email-ID:-\t\t\t" + jsonObject.getString("SEMAILID");
                StudentContactNumber = "Student Contact Number:-\t\t\t" + jsonObject.getString("SCELLNO");
                ParentContactNumber = "Parent Contact Number:-\t\t\t" + jsonObject.getString("PCELLNO");
                Toast.makeText(StudentLoginActivity.this, ""+jsonObject.getString("Rollno"), Toast.LENGTH_SHORT).show();
                String tempc1, tempc2, tempc3, tempcc;
                tempc1 = jsonObject.getString("CADDRESS1");
                tempc2 = jsonObject.getString("CADDRESS2");
                tempc3 = jsonObject.getString("CADDRESS3");
                tempcc = jsonObject.getString("CCITYNAME");
                if(tempc1.equals("null"))
                    tempc1="";
                if(tempc2.equals("null"))
                    tempc2="";
                if(tempc3.equals("null"))
                    tempc3="";
                if(tempcc.equals("null"))
                    tempcc="";
                CurrentAddress =  tempc1 + ", " + tempc2 + ", " + tempc3 + ", " + tempcc;

            }

        } catch (Exception ex) {
            Log.e(TAG, "Error: " + ex.getMessage());
        }
    }

    public void calculateResult() {
        String SOAP_ACTION_RESULT = "http://tempuri.org/getStudentExaminationResult";
        String METHOD_NAME_RESULT = "getStudentExaminationResult";
        String NAMESPACE = "http://tempuri.org/";
        String URL = "http://apps.nirmauni.ac.in/misservice/MISservicePK.asmx";

        try {
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME_RESULT);

            Request.addProperty("Rollno", user);

            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = true;
            soapEnvelope.setOutputSoapObject(Request);

            HttpTransportSE transport = new HttpTransportSE(URL);

            transport.call(SOAP_ACTION_RESULT, soapEnvelope);

            ResultData = (SoapPrimitive) soapEnvelope.getResponse();
            String ResultDataString = ResultData.toString();
            JSONArray arrayarray = new JSONArray(ResultDataString);

            String stemp, ctemp, gtemp, ttemp;

            int curr = 1;
            semesters.add(new ArrayList<String>());
            for(int i=0;i<arrayarray.length();i++) {
                JSONObject jsonObject = arrayarray.getJSONObject(i);
                stemp = jsonObject.getString("STYNUMBER");
                int stempint = Integer.parseInt(stemp);
                if(stempint==curr)
                {
                    ctemp = jsonObject.getString("SUBJCECTCODE");
                    gtemp = jsonObject.getString("GRADE");
                    ttemp = ctemp + "\t - \t" + gtemp;
                    semesters.get(curr-1).add(ttemp);
                }
                else
                {
                    while(stempint!=curr){
                        curr++;
                        semesters.add(new ArrayList<String>());}
                    ctemp = jsonObject.getString("SUBJCECTCODE");
                    gtemp = jsonObject.getString("GRADE");
                    ttemp = ctemp + "\t - \t" + gtemp;
                    semesters.get(curr-1).add(ttemp);
                }
            }
        } catch (Exception ex) {
            Log.e(TAG, "Error: " + ex.getMessage());
        }
    }

    public void getAttendance()
    {
        String SOAP_ACTION = "http://tempuri.org/getStudentAttendanceDeatils";
        String METHOD_NAME = "getStudentAttendanceDeatils";
        String NAMESPACE = "http://tempuri.org/";
        String URL = "http://apps.nirmauni.ac.in/misservice/MISservicePK.asmx";

        String SUBJECTCODE = "SUBJECTCODE";
        String SUBJECTCOMPONENTCODE = "SUBJECTCOMPONENTCODE";
        String PRESENT = "PRESENT";
        String TCOUNT = "TCOUNT";


        try {
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
            Request.addProperty("Rollno", user);

            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = true;
            soapEnvelope.setOutputSoapObject(Request);

            HttpTransportSE transport = new HttpTransportSE(URL);

            transport.call(SOAP_ACTION, soapEnvelope);
            AttendanceData = (SoapPrimitive) soapEnvelope.getResponse();
            String AttendanceDataString = AttendanceData.toString();
            JSONArray attendanceArray = new JSONArray(AttendanceDataString);
            //System.out.println(AttendanceDataString);
            for(int i=0;i<attendanceArray.length();i++) {

                JSONObject jsonObject = attendanceArray.getJSONObject(i);


                String sub_code = jsonObject.getString(SUBJECTCODE);
                HashMap < String, Integer > map ;
                if(!subject.containsKey(sub_code))
                {
                    map = new HashMap<String, Integer>();
                    subject.put(sub_code,map);
                }
                else
                    map = subject.get(sub_code);
                String key  = jsonObject.getString(SUBJECTCOMPONENTCODE)+jsonObject.getString(PRESENT);
                Integer count  = Integer.parseInt(jsonObject.getString(TCOUNT));
                System.out.println(key + "  "+ count);
                map.put(key,count);
            }

        } catch (Exception ex) {
            Log.e(TAG, "Error: " + ex.getMessage());
        }
    }
    public void getTT() {
        String SOAP_ACTION_INFO = "http://tempuri.org/getStudentTimeTableDeatils";
        String METHOD_NAME_INFO = "getStudentTimeTableDeatils";
        String NAMESPACE = "http://tempuri.org/";
        String URL = "http://apps.nirmauni.ac.in/misservice/MISservicePK.asmx";


        try {
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME_INFO);

            Request.addProperty("Rollno", user);
            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = true;
            soapEnvelope.setOutputSoapObject(Request);

            HttpTransportSE transport = new HttpTransportSE(URL);

            transport.call(SOAP_ACTION_INFO, soapEnvelope);
            TTData = (SoapPrimitive) soapEnvelope.getResponse();
            TTDataString = TTData.toString();
            JSONArray TTArray = new JSONArray(TTDataString);
//            cnt=TTArray.length();


            String current=" ";
            for(int i=0;i<TTArray.length();i++) {

                JSONObject jsonObject = TTArray.getJSONObject(i);
                String subjectcode = jsonObject.getString("SUBJECT");

                if(!(subjectcode.equals(current))) {

                    schedule.add(new ArrayList<String>());

                    subcode =jsonObject.getString("SUBJECT");
                    val = subcode + " " + TTArray.length();

                    sub = jsonObject.getString("SUBJECT");
                    faculty = jsonObject.getString("STAFFNAME");
                    day = jsonObject.getString("ALLOCATIONDAY");
                    stime = jsonObject.getString("FROMSESSIONTIME");
                    etime = jsonObject.getString("TOSESSIONTIME");
                    classroom = jsonObject.getString("CLASSROOM");
                    schedule.get(cnt).add(sub);
                    schedule.get(cnt).add(faculty);
                    schedule.get(cnt).add(day);
                    schedule.get(cnt).add(stime);
                    schedule.get(cnt).add(etime);
                    schedule.get(cnt).add(classroom);
                    cnt++;

                }else{
                    JSONObject jsonObj = TTArray.getJSONObject(i);
                    current = jsonObj.getString("SUBJECT");
                    System.out.println(current);
                    //schedule.get(cnt).add(current);
                    val = subcode + " " + TTArray.length();

                    sub = jsonObject.getString("SUBJECT");
                    faculty = jsonObject.getString("STAFFNAME");
                    day = jsonObject.getString("ALLOCATIONDAY");
                    stime = jsonObject.getString("FROMSESSIONTIME");
                    etime = jsonObject.getString("TOSESSIONTIME");
                    classroom = jsonObject.getString("CLASSROOM");

                    schedule.get(cnt).add(sub);
                    schedule.get(cnt).add(faculty);
                    schedule.get(cnt).add(day);
                    schedule.get(cnt).add(stime);
                    schedule.get(cnt).add(etime);
                    schedule.get(cnt).add(classroom);

                }
            }


            for(int i=0;i<TTArray.length();i++) {

                JSONObject jsonObject = TTArray.getJSONObject(i);
                String inday = jsonObject.getString("ALLOCATIONDAY");

                sub = jsonObject.getString("SUBJECT");
                faculty = jsonObject.getString("STAFFNAME");
                day = jsonObject.getString("ALLOCATIONDAY");
                stime = jsonObject.getString("FROMSESSIONTIME");
                etime = jsonObject.getString("TOSESSIONTIME");
                classroom = jsonObject.getString("CLASSROOM");
                if(inday.equals("MON")){

                    if(stime.equals("09:00 AM")){
                        monarr[0][0]="09:00";
                        monarr[0][1]="09:50";
                        monarr[0][2]=sub;
                        monarr[0][3]=faculty;
                        monarr[0][4]=classroom;

                    }else if(stime.equals("09:50 AM")){
                        monarr[1][0]="09:50";
                        monarr[1][1]="10:50";
                        monarr[1][2]=sub;
                        monarr[1][3]=faculty;
                        monarr[1][4]=classroom;
                    }
                    else if(stime.equals("11:15 AM")){
                        monarr[2][0]="11:15";
                        monarr[2][1]="12:15";
                        monarr[2][2]=sub;
                        monarr[2][3]=faculty;
                        monarr[2][4]=classroom;
                    }
                    else if(stime.equals("12:15 PM")) {
                        monarr[3][0] = "12:15";
                        monarr[3][1] = "1:15";
                        monarr[3][2] = sub;
                        monarr[3][3] = faculty;
                        monarr[3][4]=classroom;
                    }
                    else if(stime.equals("02:00 PM")) {
                        monarr[4][0] = "02:00";
                        monarr[4][1] = "03:00";
                        monarr[4][2] = sub;
                        monarr[4][3] = faculty;
                        monarr[4][4]=classroom;
                    }
                    else if(stime.equals("03:00 PM")){
                        monarr[5][0]="03:00";
                        monarr[5][1]="04:00";
                        monarr[5][2]=sub;
                        monarr[5][3]=faculty;
                        monarr[5][4]=classroom;
                    }
                    mon.add(sub);
                    mon.add(faculty);
                    mon.add(day);
                    mon.add(stime);
                    mon.add(etime);
                    mon.add(classroom);
                }else if(inday.equals("TUE")){

                    if(stime.equals("09:00 AM")){
                        tuearr[0][0]="09:00";
                        tuearr[0][1]="09:50";
                        tuearr[0][2]=sub;
                        tuearr[0][3]=faculty;
                        tuearr[0][4]=classroom;
                    }else if(stime.equals("09:50 AM")){
                        tuearr[1][0]="09:50";
                        tuearr[1][1]="10:50";
                        tuearr[1][2]=sub;
                        tuearr[1][3]=faculty;
                        tuearr[1][4]=classroom;
                    }
                    else if(stime.equals("11:15 AM")){
                        tuearr[2][0]="11:15";
                        tuearr[2][1]="12:15";
                        tuearr[2][2]=sub;
                        tuearr[2][3]=faculty;
                        tuearr[2][4]=classroom;
                    }
                    else if(stime.equals("12:15 PM")) {
                        tuearr[3][0] = "12:15";
                        tuearr[3][1] = "1:15";
                        tuearr[3][2] = sub;
                        tuearr[3][3] = faculty;
                        tuearr[3][4]=classroom;
                    }
                    else if(stime.equals("02:00 PM")) {
                        tuearr[4][0] = "02:00";
                        tuearr[4][1] = "03:00";
                        tuearr[4][2] = sub;
                        tuearr[4][3] = faculty;
                        tuearr[4][4]=classroom;
                    }
                    else if(stime.equals("03:00 PM")){
                        tuearr[5][0]="03:00";
                        tuearr[5][1]="04:00";
                        tuearr[5][2]=sub;
                        tuearr[5][3]=faculty;
                        tuearr[5][4]=classroom;
                    }
                    tue.add(sub);
                    tue.add(faculty);
                    tue.add(day);
                    tue.add(stime);
                    tue.add(etime);
                    tue.add(classroom);
                }else if(inday.equals("WED")){

                    if(stime.equals("09:00 AM")){
                        wedarr[0][0]="09:00";
                        wedarr[0][1]="09:50";
                        wedarr[0][2]=sub;
                        wedarr[0][3]=faculty;
                        wedarr[0][4]=classroom;
                    }else if(stime.equals("09:50 AM")){
                        wedarr[1][0]="09:50";
                        wedarr[1][1]="10:50";
                        wedarr[1][2]=sub;
                        wedarr[1][3]=faculty;
                        wedarr[1][4]=classroom;
                    }
                    else if(stime.equals("11:15 AM")){
                        wedarr[2][0]="11:15";
                        wedarr[2][1]="12:15";
                        wedarr[2][2]=sub;
                        wedarr[2][3]=faculty;
                        wedarr[2][4]=classroom;
                    }
                    else if(stime.equals("12:15 PM")) {
                        wedarr[3][0] = "12:15";
                        wedarr[3][1] = "1:15";
                        wedarr[3][2] = sub;
                        wedarr[3][3] = faculty;
                        wedarr[3][4]=classroom;
                    }
                    else if(stime.equals("02:00 PM")) {
                        wedarr[4][0] = "02:00";
                        wedarr[4][1] = "03:00";
                        wedarr[4][2] = sub;
                        wedarr[4][3] = faculty;
                        wedarr[4][4]=classroom;
                    }
                    else if(stime.equals("03:00 PM")){
                        wedarr[5][0]="03:00";
                        wedarr[5][1]="04:00";
                        wedarr[5][2]=sub;
                        wedarr[5][3]=faculty;
                        wedarr[5][4]=classroom;
                    }

                    wed.add(sub);
                    wed.add(faculty);
                    wed.add(day);
                    wed.add(stime);
                    wed.add(etime);
                    wed.add(classroom);
                }else if(inday.equals("THU")){

                    if(stime.equals("09:00 AM")){
                        thurarr[0][0]="09:00";
                        thurarr[0][1]="09:50";
                        thurarr[0][2]=sub;
                        thurarr[0][3]=faculty;
                        thurarr[0][4]=classroom;
                    }else if(stime.equals("09:50 AM")){
                        thurarr[1][0]="09:50";
                        thurarr[1][1]="10:50";
                        thurarr[1][2]=sub;
                        thurarr[1][3]=faculty;
                        thurarr[1][4]=classroom;
                    }
                    else if(stime.equals("11:15 AM")){
                        thurarr[2][0]="11:15";
                        thurarr[2][1]="12:15";
                        thurarr[2][2]=sub;
                        thurarr[2][3]=faculty;
                        thurarr[2][4]=classroom;
                    }
                    else if(stime.equals("12:15 PM")) {
                        thurarr[3][0] = "12:15";
                        thurarr[3][1] = "1:15";
                        thurarr[3][2] = sub;
                        thurarr[3][3] = faculty;
                        thurarr[3][4]=classroom;
                    }
                    else if(stime.equals("02:00 PM")) {
                        thurarr[4][0] = "02:00";
                        thurarr[4][1] = "03:00";
                        thurarr[4][2] = sub;
                        thurarr[4][3] = faculty;
                        thurarr[4][4]=classroom;
                    }
                    else if(stime.equals("03:00 PM")){
                        thurarr[5][0]="03:00";
                        thurarr[5][1]="04:00";
                        thurarr[5][2]=sub;
                        thurarr[5][3]=faculty;
                        thurarr[5][4]=classroom;
                    }

                    thur.add(sub);
                    thur.add(faculty);
                    thur.add(day);
                    thur.add(stime);
                    thur.add(etime);
                    thur.add(classroom);
                }else if(inday.equals("FRI")){

                    if(stime.equals("09:00 AM")){
                        friarr[0][0]="09:00";
                        friarr[0][1]="09:50";
                        friarr[0][2]=sub;
                        friarr[0][3]=faculty;
                        friarr[0][4]=classroom;
                    }else if(stime.equals("09:50 AM")){
                        friarr[1][0]="09:50";
                        friarr[1][1]="10:50";
                        friarr[1][2]=sub;
                        friarr[1][3]=faculty;
                        friarr[1][4]=classroom;
                    }
                    else if(stime.equals("11:15 AM")){
                        friarr[2][0]="11:15";
                        friarr[2][1]="12:15";
                        friarr[2][2]=sub;
                        friarr[2][3]=faculty;
                        friarr[2][4]=classroom;
                    }
                    else if(stime.equals("12:15 PM")) {
                        friarr[3][0] = "12:15";
                        friarr[3][1] = "1:15";
                        friarr[3][2] = sub;
                        friarr[3][3] = faculty;
                        friarr[3][4]=classroom;
                    }
                    else if(stime.equals("02:00 PM")) {
                        friarr[4][0] = "02:00";
                        friarr[4][1] = "03:00";
                        friarr[4][2] = sub;
                        friarr[4][3] = faculty;
                        friarr[4][4]=classroom;
                    }
                    else if(stime.equals("03:00 PM")){
                        friarr[5][0]="03:00";
                        friarr[5][1]="04:00";
                        friarr[5][2]=sub;
                        friarr[5][3]=faculty;
                        friarr[5][4]=classroom;
                    }

                    fri.add(sub);
                    fri.add(faculty);
                    fri.add(day);
                    fri.add(stime);
                    fri.add(etime);
                    fri.add(classroom);
                }

            }
        }catch (Exception ex) {
            Log.e(TAG, "Error: " + ex.getMessage());
        }

    }
}

