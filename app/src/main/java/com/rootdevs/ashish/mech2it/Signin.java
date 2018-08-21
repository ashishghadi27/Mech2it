package com.rootdevs.ashish.mech2it;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Signin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        SharedPreferences sharedPreferences = getSharedPreferences("unique", MODE_PRIVATE);


        if(sharedPreferences.getString("code", "").equals("")) {

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(Signin.this);
            alertDialog.setTitle("Enter Unique Code");

            // Setting Dialog Message
            // alertDialog.setMessage("Enter Password");
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(50, 0, 30, 0);

            final EditText input = new EditText(Signin.this);
            layout.addView(input, params);

            alertDialog.setView(layout);
            alertDialog.setCancelable(false);
            // Setting Icon to Dialog

            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String code = input.getText().toString();
                            if (isNetworkAvailable()) {

                                String type = "login";
                                Background_Worker background_worker = new Background_Worker(Signin.this);
                                background_worker.execute(type, code);

                            } else
                                Toast.makeText(Signin.this, "Check Your connection", Toast.LENGTH_SHORT).show();


                        }
                    });
            // Setting Negative "NO" Button


            // Showing Alert Message
            alertDialog.show();
        }
    }

    public void loadnotice(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void loaderp(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
