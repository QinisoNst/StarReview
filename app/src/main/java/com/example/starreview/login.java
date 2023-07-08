package com.example.starreview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    //initialise variables
    EditText etUsename,etPassword;
Button btSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //link variables with layout Id elements
        etUsename = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btSubmit = findViewById(R.id.bt_submit);
        //to hide the status bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create a username and password
                if(etUsename.getText().toString().equals("Qiniso")&&etPassword.getText().toString().equals("12345"))
                {
                   // Creating AlertDialog variables
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            login.this

                    );
                    //Setting AlertDialog's Icon ,Title and Message
                    builder.setIcon(R.drawable.ic_check);
                    builder.setTitle("Loing Succesfully !!!");
                    builder.setMessage("Welcome to Android Coding...");

                    builder.setNegativeButton("YES" , new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog , int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    startActivity(new Intent(getApplicationContext(), nana.class));}
                else
                    {
                        //Setting AlertDialog's Icon ,Title and Message
                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                login.this

                        );
                        //Setting AlertDialog's Icon ,Title and Message
                        builder.setIcon(R.drawable.ic_remove);
                        builder.setTitle("Loing Unsuccesfully !!!");
                        builder.setMessage("Try again");

                        builder.setNegativeButton("YES" , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog , int which) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
            }
        });

    }
}
