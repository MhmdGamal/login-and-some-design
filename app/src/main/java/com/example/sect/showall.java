package com.example.sect;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class showall extends AppCompatActivity {

    ListView lv;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showall);
        lv=findViewById(R.id.lvid);
        db=new database(this);

        ArrayList<String> arrl=new ArrayList<>();
        ArrayAdapter<String> Arrad;
        Cursor c=db.getAllData();
        while (c.moveToNext()){
            arrl.add("ID: "+c.getString(0)+"\nName: "+c.getString(1)
            +"\nPassword: "+c.getString(2)+"\nProject Name: "+c.getString(3)
            +"\nProject Specialization: "+c.getString(4)+"\nProject Budget: "+
                    c.getString(5));
        }
        Arrad=new ArrayAdapter<String>(this,android.R.layout.activity_list_item,
                android.R.id.text1,arrl);
        lv.setAdapter(Arrad);
    }
}
