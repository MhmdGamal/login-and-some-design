package com.example.sect;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class insert extends AppCompatActivity {

    EditText usn,pas,projn,projs,projb;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        usn=findViewById(R.id.usernameid);
        pas=findViewById(R.id.passwordid);
        projn=findViewById(R.id.projnid);
        projs=findViewById(R.id.projsid);
        projb=findViewById(R.id.projbid);
        db=new database(this);
    }

    public void ins(View v){
        if(usn.getText().toString().equals("")||pas.getText().toString().equals("")){
            Toast.makeText(this,"Username or Password is Empty",Toast.LENGTH_LONG).show();
            return;
        }
        Cursor c=db.getAllData();
        while (c.moveToNext()){
            if(usn.getText().toString().equals(c.getString(1))){
                Toast.makeText(insert.this,"Existed ",Toast.LENGTH_LONG).show();
                return;
            }
        }


            String k=db.insert(usn.getText().toString(),pas.getText().toString(),projn.getText().toString(),
                    projs.getText().toString(),projb.getText().toString() );
            if(k.equals("Welcome ")){
                Toast.makeText(this,"Successful Operation",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
            }

    }
}
