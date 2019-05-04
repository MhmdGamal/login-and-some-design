package com.example.sect;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class msgsd extends AppCompatActivity {


    ListView lv;
    EditText un;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msgsd);
        db=new database(this);
        lv=findViewById(R.id.lvd);
        un=findViewById(R.id.unid);

        ArrayList<String> arrl=new ArrayList<>();
        Cursor c=db.gt_allmsgs();
        while (c.moveToNext()){
            if(c.getString(22).substring(0,5).equals("Admin")){
                arrl.add(c.getString(12)+"\n");
            }else {
                arrl.add(c.getString(12)+" Message "+"\n");
            }
        }
        ArrayAdapter<String> arrad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,arrl);
        lv.setAdapter(arrad);



    }

    public void ms(View v){
        if (un.getText().toString().equals("")){
            Toast.makeText(this,"Empty",Toast.LENGTH_LONG).show();
        }else {
            Cursor c=db.gt_allmsgs();
            while (c.moveToNext()){
                if (un.getText().toString().equals(c.getString(12))){
                    Intent intent=new Intent(msgsd.this,messageadmin.class);
                    intent.putExtra("k","i");
                    intent.putExtra("unam",un.getText().toString());
                    startActivity(intent);
                    return;
                }
            }

            Toast.makeText(msgsd.this,"Not Found",Toast.LENGTH_LONG).show();
        }
    }
}
