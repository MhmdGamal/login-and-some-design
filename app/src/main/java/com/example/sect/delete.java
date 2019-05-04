package com.example.sect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends AppCompatActivity {

    EditText usn;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        usn=findViewById(R.id.usernameid);
        db=new database(this);
    }

    public void delt(View v){

        String n=db.delete_one(usn.getText().toString());
        Toast.makeText(this,n,Toast.LENGTH_LONG).show();
    }
    public void cance(View v){
        Intent intent=new Intent(this,admin.class);
        startActivity(intent);
    }
}
