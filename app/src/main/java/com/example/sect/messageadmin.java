package com.example.sect;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Currency;

public class messageadmin extends AppCompatActivity {

    ListView lv;
    EditText msg;
    String b;
    String  k;
    database db;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messageadmin);

        db=new database(this);
        lv=findViewById(R.id.lvid);
        msg=findViewById(R.id.msgid);
        k=getIntent().getStringExtra("k");
        bt=findViewById(R.id.btnid);
        if(k.equals("i")){
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adsend(v);
                }
            });
        }else {
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    send(v);
                }
            });
        }


         b=getIntent().getStringExtra("unam");

        ArrayList<String> arrl=new ArrayList<>();
        Cursor c=db.gt_msgs(b);
        while (c.moveToNext()){
            arrl.add(c.getString(22)+"\n");
        }
        ArrayAdapter<String> arrad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,arrl);
        lv.setAdapter(arrad);


    }
    public void shm(String u){
        ArrayList<String> arrl=new ArrayList<>();
        Cursor c=db.gt_msgs(u);
        while (c.moveToNext()){
            arrl.add(c.getString(22)+"\n");
        }
        ArrayAdapter<String> arrad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,arrl);
        lv.setAdapter(arrad);
    }

    public void send(View v){

        String t=db.insermsg(b,b+": "+msg.getText().toString());
        if(t.equals("Success")){
            shm(b);
        }else {
            Toast.makeText(this,t,Toast.LENGTH_LONG).show();
        }


    }


    public void adsend(View v){
        String t=db.insermsg(b,"Admin: "+msg.getText().toString());
        if(t.equals("Success")){
            shm(b);
        }else {
            Toast.makeText(this,t,Toast.LENGTH_LONG).show();
        }

    }
}
