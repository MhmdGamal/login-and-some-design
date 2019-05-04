package com.example.sect;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class showone extends AppCompatActivity {

    EditText usn;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showone);

        usn=findViewById(R.id.usernameid);
        db=new database(this);
    }

    public void showo(View v){
        Cursor c=db.get_oneData(usn.getText().toString());

        if(c.moveToNext() == true) {
            AlertDialog.Builder alrt = new AlertDialog.Builder(this);
            alrt.setTitle(usn.getText().toString())
                    .setMessage("ID: " + c.getString(0) + "\nName: " + c.getString(1)
                            + "\nPassword: " + c.getString(2) + "\nProject Name: " + c.getString(3)
                            + "\nProject Specialization: " + c.getString(4) + "\nProject Budget: " +
                            c.getString(5))
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                        }
                    });
            alrt.create().show();
        }
        else
            Toast.makeText(this,"No Move to next ",Toast.LENGTH_LONG).show();
    }

    public void cancel(View v){
        Intent intent=new Intent(this,admin.class);
        startActivity(intent);
    }
}
