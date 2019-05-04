package com.example.sect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class update_s extends AppCompatActivity {

    EditText usn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_s);
        usn=findViewById(R.id.usernameid);
    }

    public void upd(View v){
        Intent intent=new Intent(this,update.class);
        intent.putExtra("un",usn.getText().toString());
        startActivity(intent);
    }
    public void canc(View v){
        Intent intent=new Intent(this,admin.class);
        startActivity(intent);
    }
}
