package com.rootdevs.ashish.mech2it;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.onesignal.OneSignal;

public class HomeActivity extends AppCompatActivity {
    String link = "", code = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreferences = getSharedPreferences("unique", MODE_PRIVATE);
        code = sharedPreferences.getString("code", "");
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
        setContentView(R.layout.activity_home);
        OneSignal.setEmail("intern2k18@mech2it.com");
    }

    public void loadmech(View view){
        CharSequence engines[] = new CharSequence[] {"Common","S.E", "T.E", "B.E"};

        final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setTitle("Select a Year");
        builder.setItems(engines, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SharedPreferences sharedPreferences = getSharedPreferences("rss", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(which == 0)
                    link = "https://"+code+".m2i.cloud/community/mechanical/?type=rss2&forum=26";
                else if(which == 1)
                    link = "https://"+code+".m2i.cloud/community/mechanical-se/?type=rss2&forum=27";
                else if (which == 2)
                    link= "https://"+ code +".m2i.cloud/community/mechanical-te/?type=rss2&forum=28";
                else
                    link = "https://"+code+".m2i.cloud/community/mechanical-be/?type=rss2&forum=29";

                editor.putString("link", link);
                editor.apply();
                Intent intent = new Intent(HomeActivity.this, Feeds.class);
                startActivity(intent);

            }
        });
        builder.show();
    }

    public void loadit(View view){
        CharSequence engines[] = new CharSequence[] {"Common","S.E", "T.E", "B.E"};

        final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setTitle("Select a Year");
        builder.setItems(engines, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SharedPreferences sharedPreferences = getSharedPreferences("rss", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(which == 0)
                    link = "https://"+ code +".m2i.cloud/community/information-technonogy/?type=rss2&forum=22";
                else if(which == 1)
                    link = "https://"+ code +".m2i.cloud/community/information-technonogy-se/?type=rss2&forum=23";
                else if (which == 2)
                    link= "https://"+ code +".m2i.cloud/community/information-technonogy-te/?type=rss2&forum=24";
                else
                    link = "https://"+ code +".m2i.cloud/community/information-technonogy-be/?type=rss2&forum=25";

                editor.putString("link", link);
                editor.apply();
                Intent intent = new Intent(HomeActivity.this, Feeds.class);
                startActivity(intent);

            }
        });
        builder.show();

    }

    public void loadextc(View view){
        CharSequence engines[] = new CharSequence[] {"Common", "S.E", "T.E", "B.E"};

        final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setTitle("Select a Year");
        builder.setItems(engines, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SharedPreferences sharedPreferences = getSharedPreferences("rss", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(which == 0)
                    link = "https://"+ code +".m2i.cloud/community/electronics-telecommunication/?type=rss2&forum=18";
                else if(which == 1)
                    link = "https://"+ code +".m2i.cloud/community/electronics-telecommunication-se/?type=rss2&forum=19";
                else if (which == 2)
                    link= "https://"+ code +".m2i.cloud/community/electronics-telecommunication-te/?type=rss2&forum=20";
                else
                    link = "https://"+ code +".m2i.cloud/community/electronics-telecommunication-be/?type=rss2&forum=21";

                editor.putString("link", link);
                editor.apply();
                Intent intent = new Intent(HomeActivity.this, Feeds.class);
                startActivity(intent);

            }
        });
        builder.show();

    }

    public void loadcivil(View view){
        CharSequence engines[] = new CharSequence[] {"Common", "S.E", "T.E", "B.E"};

        final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setTitle("Select a Year");
        builder.setItems(engines, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SharedPreferences sharedPreferences = getSharedPreferences("rss", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(which == 0)
                    link = "https://"+ code +".m2i.cloud/community/civil/?type=rss2&forum=10";
                else if(which == 1)
                    link = "https://"+ code +".m2i.cloud/community/civil-se/?type=rss2&forum=11";
                else if (which == 2)
                    link= "https://"+ code +".m2i.cloud/community/civil-te/?type=rss2&forum=12";
                else
                    link = "https://"+ code +".m2i.cloud/community/civil-be/?type=rss2&forum=13";

                editor.putString("link", link);
                editor.apply();
                Intent intent = new Intent(HomeActivity.this, Feeds.class);
                startActivity(intent);

            }
        });
        builder.show();

    }

    public void loadcomps(View view){
        CharSequence engines[] = new CharSequence[] {"Common", "S.E", "T.E", "B.E"};

        final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setTitle("Select a Year");
        builder.setItems(engines, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SharedPreferences sharedPreferences = getSharedPreferences("rss", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(which == 0)
                    link = "https://"+ code +".m2i.cloud/community/computer/?type=rss2&forum=14";
                else if(which == 1)
                    link = "https://"+ code +".m2i.cloud/community/computer-se/?type=rss2&forum=15";
                else if (which == 2)
                    link= "https://"+ code +".m2i.cloud/community/computer-te/?type=rss2&forum=16";
                else
                    link = "https://"+ code +".m2i.cloud/community/computer-be/?type=rss2&forum=17";

                editor.putString("link", link);
                editor.apply();
                Intent intent = new Intent(HomeActivity.this, Feeds.class);
                startActivity(intent);

            }
        });
        builder.show();

    }

    public void loadauto(View view){
        CharSequence engines[] = new CharSequence[] {"Common", "S.E", "T.E", "B.E"};

        final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setTitle("Select a Year");
        builder.setItems(engines, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SharedPreferences sharedPreferences = getSharedPreferences("rss", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(which == 0)
                    link = "https://"+ code +".m2i.cloud/community/automobile/?type=rss2&forum=6";
                else if(which == 1)
                    link = "https://"+ code +".m2i.cloud/community/se/?type=rss2&forum=7";
                else if (which == 2)
                    link= "https://"+ code +".m2i.cloud/community/te/";
                else
                    link = "https://"+ code +".m2i.cloud/community/be/?type=rss2&forum=9";

                editor.putString("link", link);
                editor.apply();
                Intent intent = new Intent(HomeActivity.this, Feeds.class);
                startActivity(intent);

            }
        });
        builder.show();

    }

    public void loadmba(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("rss", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        link = "https://"+ code +".m2i.cloud/community/mba/?type=rss2&forum=31";
        editor.putString("link", link);
        editor.apply();
        Intent intent = new Intent(HomeActivity.this, Feeds.class);
        startActivity(intent);
    }

    public void loadme(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("rss", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        link = "https://"+ code +".m2i.cloud/community/me/?type=rss2&forum=33";
        editor.putString("link", link);
        editor.apply();
        Intent intent = new Intent(HomeActivity.this, Feeds.class);
        startActivity(intent);
    }

    public void principal(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("rss", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        link = "https://"+ code +".m2i.cloud/community/principal/?type=rss2&forum=4";
        editor.putString("link", link);
        editor.apply();
        Intent intent = new Intent(HomeActivity.this, Feeds.class);
        startActivity(intent);
    }

    public void office(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("rss", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        link = "https://"+ code +".m2i.cloud/community/office/?type=rss2&forum=3";
        editor.putString("link", link);
        editor.apply();
        Intent intent = new Intent(HomeActivity.this, Feeds.class);
        startActivity(intent);
    }

    public void firstyear(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("rss", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        link = "https://"+ code +".m2i.cloud/community/first-year/?type=rss2&forum=5";
        editor.putString("link", link);
        editor.apply();
        Intent intent = new Intent(HomeActivity.this, Feeds.class);
        startActivity(intent);
    }
}
