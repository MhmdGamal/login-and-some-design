package com.example.sect;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText usn,pas;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        usn=findViewById(R.id.usernameid);
        pas=findViewById(R.id.passwordid);
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
                Toast.makeText(signup.this,"Existed ",Toast.LENGTH_LONG).show();
                return;
            }
        }


        String w=db.insert(usn.getText().toString(),pas.getText().toString(),"","","");

        Intent intent=new Intent(this,usermp.class);
        intent.putExtra("una",usn.getText().toString());
        startActivity(intent);

    }
}
