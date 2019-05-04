package com.example.sect;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usna,pass;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usna=findViewById(R.id.usernameid);
        pass=findViewById(R.id.passwordid);
        db=new database(this);
    }

    public void login(View v){
        if(usna.getText().toString().equals("")|| pass.getText().toString().equals("") ){
            Toast.makeText(this,"Username or Password is Empty",Toast.LENGTH_LONG).show();
            return ;
        }

        if(usna.getText().toString().equals("Mohamed G")){
            if(pass.getText().toString().equals("123450")){
                Intent intent=new Intent(this,admin.class);
                startActivity(intent);
                return;
            }else {
                Toast.makeText(this,"Incorrect Password",Toast.LENGTH_LONG).show();
                return;
            }
        }
        Cursor c=db.getAllData();
        while (c.moveToNext()){
            if(c.getString(1).equals(usna.getText().toString())){
                if(c.getString(2).equals(pass.getText().toString())){

                    Intent intent=new Intent(this,usermp.class);
                    intent.putExtra("una",c.getString(1));
                    startActivity(intent);
                    return;
                    ////////////////////
                }else {
                    Toast.makeText(this,"Incorrect Password",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
        Toast.makeText(this,"Incorrect Email",Toast.LENGTH_LONG).show();
    }

    public void signup(View v){
        Intent intent=new Intent(this,signup.class);
        startActivity(intent);

    }
}
