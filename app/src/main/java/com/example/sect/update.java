package com.example.sect;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class update extends AppCompatActivity {

    EditText usn,pas,projn,projs,projb;
    database db;
    String xun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        usn=findViewById(R.id.usernameid);
        pas=findViewById(R.id.passwordid);
        projn=findViewById(R.id.projnid);
        projs=findViewById(R.id.projsid);
        projb=findViewById(R.id.projbid);
        db=new database(this);
        xun=getIntent().getStringExtra("un");

        usn.setText(getIntent().getStringExtra("un"));
        pas.setText(db.gt_pas(usn.getText().toString()));
        projn.setText(db.gt_pron(usn.getText().toString()));
        projs.setText(db.gt_pros(usn.getText().toString()));
        projb.setText(db.gt_prob(usn.getText().toString()));
    }

    public void upo(View v){

        if(usn.getText().toString().equals("")||pas.getText().toString().equals("")){
            Toast.makeText(this,"Username or Password is Empty",Toast.LENGTH_LONG).show();
            return;
        }
        if (usn.getText().toString().equals(xun)){
            String g=db.updat_all(xun,xun,pas.getText().toString(),projn.getText().toString(),
                    projs.getText().toString(),projb.getText().toString());

            Toast.makeText(this,g,Toast.LENGTH_LONG).show();
            return;
        }
        Cursor c=db.getAllData();
        while (c.moveToNext()){
            if(usn.getText().toString().equals(c.getString(1))){
                Toast.makeText(update.this,"Existed ",Toast.LENGTH_LONG).show();
                return;
            }
        }

            String g=db.updat_all(xun,usn.getText().toString(),pas.getText().toString(),projn.getText().toString(),
                    projs.getText().toString(),projb.getText().toString());

            Toast.makeText(this,g,Toast.LENGTH_LONG).show();

    }
}
