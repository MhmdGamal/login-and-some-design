package com.example.sect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class usermp extends AppCompatActivity {

    database db;
    String un;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermp);

        db=new database(this);
        un=getIntent().getStringExtra("una");
        Toast.makeText(this,"Welcome "+un,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void sh(View v){
        Intent intent=new Intent(this,usershow.class);
        intent.putExtra("una",un);
        startActivity(intent);
    }
    public void up(View v){
        Intent intent=new Intent(this,userupdate.class);
        intent.putExtra("una",un);
        startActivity(intent);
    }
    public void de(View v){
        db.delete_one(un);
        Toast.makeText(this,"Your Account is Deleted ",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
    public void msgd(View v){
        Intent intent=new Intent(this,messageadmin.class);
        intent.putExtra("unam",un);
        intent.putExtra("k","o");
        startActivity(intent);
    }
}
