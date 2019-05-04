package com.example.sect;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class usershow extends AppCompatActivity {

    ListView lv;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usershow);

        lv=findViewById(R.id.lv);
        db=new database(this);

        ArrayList<String> arrl=new ArrayList<>();
        ArrayAdapter<String> arrad;
        Cursor c=db.get_oneData(getIntent().getStringExtra("una"));
        if(c.moveToNext()){

            arrl.add("UserName: "+ c.getString(1)+"\nPassword: "+c.getString(2)+
                    "\nProject Name: "+c.getString(3)+"\nProject Specialization: "+
                    c.getString(4)+"\nProject Budget: "+c.getString(5));
        }
        arrad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,arrl);
        lv.setAdapter(arrad);
    }
}
