package com.mis.nirma.nirmauniversitymis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 */

public class datahandler_student extends SQLiteOpenHelper {

    static final String DATABASE_NAME="localstudentdata.db";
    static final  int DATABASE_VERSION=1;
    public static final String COLUMN_NAME ="name";
    public static final String COLUMN_ROLL = "roll";
    public static final String COLUMN_PNO = "parent_no";
    public static final String COLUMN_PASS = "password";
    public static final String TABLE_NAME = "student_personalinfo";

    public static final String PCOLUMN_PNO = "p_no";
    public static final String PCOLUMN_PASS = "password";
    public static final String PCOLUMN_ROLL = "roll";
    public static final String PTABLE_NAME = "parent_info";

    public datahandler_student(Context context) {

        // TODO Auto-generated constructor stub
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
       // String s="create table if not Exists student_personalinfo(name varchar(50),programcode varchar(15),branchcode varchar(15),bloodgroup varchar(5),dateofbirth varchar(10),semester varchar(3),studentno varchar(12),parentno varchar(12),studentemail varchar(25),add_one varchar(50),add_two varchar(50),add_three varchar(50),add_city varchar(15))";
       String s="create table if not Exists "+TABLE_NAME+" (name varchar(50),roll varchar(15),password varchar(20),parent_no varchar(10))";
        String s2="create table if not Exists "+PTABLE_NAME+"(p_no varchar(10),roll varchar(15),password varchar(10))";
        db.execSQL(s);
        db.execSQL(s2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

    }

    public boolean insert(String name,String roll,String pass,String pno){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_ROLL, roll);
        contentValues.put(COLUMN_PASS, pass);
        contentValues.put(COLUMN_PNO, pno);
        long result=db.insert(TABLE_NAME, null, contentValues);
        //db.close();

        if(result==-1){
            return false;

        }
        else
            return true;
    }

    public boolean insertparent(String pno,String roll,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PCOLUMN_PNO, pno);
        contentValues.put(PCOLUMN_ROLL, roll);
        contentValues.put(PCOLUMN_PASS, pass);

        long result=db.insert(PTABLE_NAME, null, contentValues);
        //db.close();

        if(result==-1){
            return false;

        }
        else
            return true;
    }

    /*  public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Contact Name
        values.put(KEY_PH_NO, contact.getPhoneNumber()); // Contact Phone Number

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
    */
    public Cursor getdatafromParentNo(String p_no){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+PTABLE_NAME+" WHERE "+PCOLUMN_PNO+" = '"+p_no+"'";
        Cursor c = db.rawQuery(sql, null);
       // c.close();
        return c;
    }

    public Cursor getdatafromRoll(String roll){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_ROLL+" = '"+roll+"'";
        Cursor c = db.rawQuery(sql, null);
        // c.close();
        return c;
    }
   /* public Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return contact;
    }
*/
}
