package com.example.sect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {

    public static String dbname="pro_sec";
    public static String tablename="nsb";
    public static String table2name="msg";
    public static String col0="id";
    public static String col1="username";
    public static String col2="password";
    public static String col3="pro_name";
    public static String col4="pro_spec";
    public static String col5="pro_bud";
    public static String col02="id";
    public static String col12="username";
    public static String col22="message";

    public database(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+tablename+" ( "+col0+" INTEGER PRIMARY KEY AUTOINCREMENT , "+
                col1+" TEXT  , "+col2+" TEXT  ,"+col3+" TEXT , "+col4+" TEXT , "+
                col5+" TEXT )");
        db.execSQL("CREATE TABLE "+table2name+"( "+col02+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+col12+"TEXT ,"+
                col22+"TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tablename);
        db.execSQL("DROP TABLE IF EXISTS "+table2name);
        onCreate(db);
    }

    public String insert(String un,String pas,String pro_n,String pro_s,String pro_b){

        try {

            ContentValues con=new ContentValues();
            con.put(col1,un);
            con.put(col2,pas);
            con.put(col3,pro_n);
            con.put(col4,pro_s);
            con.put(col5,pro_b);
            SQLiteDatabase db= this.getWritableDatabase();
            db.insert(tablename,null,con);
            return "Welcome ";
        }catch (Exception e){
            return "Error";
        }
    }

    public String delete_one(String un){

        try {
            SQLiteDatabase db=this.getWritableDatabase();
            db.delete(tablename,col1 +"=\""+un+"\"",null);
            return "Deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    /*public String delete_one(int i){

        try {
            SQLiteDatabase db=this.getWritableDatabase();
            db.execSQL("DELETE  FROM "+tablename+" WHERE "+col0+" = "+i);
            return "Deleted";
        }catch (Exception e){
            return "Error";
        }
    }*/

    public String Delete_all(){
        try {
            SQLiteDatabase db=this.getWritableDatabase();
            db.delete(tablename,null,null);
            return "Deleted";
        }catch (Exception e){
            return "Error";
        }
    }
    public String gt_id(String un){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+tablename+" WHERE "+col1+" = \""+un+"\"",null);
        if ((c.moveToNext())){
            return c.getString(0);
        }
        return "error";

    }
    public String gt_pas(String un){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+tablename+" WHERE "+col1+" = \""+un+"\"",null);
        if ((c.moveToNext())){
            return c.getString(2);
        }
        return "error";

    }
    public String gt_pron(String un){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT *  FROM "+tablename+" WHERE "+col1+" = \""+un+"\"",null);
        if ((c.moveToNext())){
            return c.getString(3);
        }
        return "error";

    }
    public String gt_pros(String un){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+tablename+" WHERE "+col1+" = \""+un+"\"",null);
        if ((c.moveToNext())){
            return c.getString(4);
        }
        return "error";

    }
    public String gt_prob(String un){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+tablename+" WHERE "+col1+" = \""+un+"\"",null);
        if ((c.moveToNext())){
            return c.getString(5);
        }
        return "error";
    }
    public Cursor get_oneData(String un){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+tablename+" WHERE "+col1+" = \""+un+"\"" ,null);
        return c;
    }
    public Cursor get_oneData(int i){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+tablename+" WHERE "+col0+" = "+i,null);
        return c;
    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+tablename,null);
        return c;
    }


    public String updat_all(String xun,String un,String pas,String pro_n,String pro_s,String pro_b){

        try {





            ContentValues con=new ContentValues();
            con.put(col1,un);
            con.put(col2,pas);
            con.put(col3,pro_n);
            con.put(col4,pro_s);
            con.put(col5,pro_b);
            String c=gt_id(xun);

            SQLiteDatabase db=this.getWritableDatabase();
            db.update(tablename,con,col0+" = "+ c,null);

            return "successful update";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String insermsg(String un,String msg){
        try {
            ContentValues con=new ContentValues();
            con.put(col12,un);
            con.put(col22,msg);
            SQLiteDatabase db=this.getWritableDatabase();
            db.insert(table2name,null,con);
            return "Success";

        }catch (Exception e){
            return e.getMessage();
        }
    }

    public Cursor gt_msgs(String un){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+table2name+"WHERE "+col12+"= \""+un+"\"",null);
        return c;
    }
    public  Cursor gt_allmsgs(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+table2name,null);
        return c;
    }


}
