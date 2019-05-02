package com.juicebox.amazingfacts;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    String Items[] = {"Animal Facts", "Brain Facts", "Car Facts", "Computer Facts", "Food Facts", "History", "Internet Facts", "Marijuana Facts", "Maths Facts", "Movie Facts", "Ocean Facts", "Random Facts", "Sleep Facts", "Sport Facts", "Technology Facts", "Universe Facts"};
    int Images[] = {R.drawable.golden_retreiver, R.drawable.brain, R.drawable.car, R.drawable.computer, R.drawable.food1, R.drawable.julius_caesar, R.drawable.internet, R.drawable.marijuana, R.drawable.mathsimage, R.drawable.movies, R.drawable.oceanimage, R.drawable.random, R.drawable.sleepimage, R.drawable.sportimage, R.drawable.tech, R.drawable.earth3};

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Turn on data", Toast.LENGTH_LONG).show();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new adapter(this, Items, Images));

        drawerLayout = findViewById(R.id.home);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setNavigationViewListener();
    }




    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;

    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(toggle.onOptionsItemSelected(item)){return true;}

        /*switch(id){
            case R.id.rate:
                try{
                    startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                    return true;
                }catch(ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + "com.android.chrome")));
                            return true;
                }
            case R.id.share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = "Radical Facts brings you interesting facts form a wide range of topics in real-time.\n" + "http://play.google.com/store/apps/details?id="  + getPackageName();
                String shareSubject = "Download the Radical Facts App from PlayStore\n";
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(intent, "Share Using"));
            default:
                return super.onOptionsItemSelected(item);
        }*/
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.rate:
                try{
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                    return true;
                }catch(ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + "com.android.chrome")));
                    return true;
                }

            case R.id.share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = "Radical Facts brings you interesting facts form a wide range of topics in real-time.\n" + "http://play.google.com/store/apps/details?id="  + getPackageName();
                String shareSubject = "Download the Radical Facts App from PlayStore\n";
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(intent, "Share Using"));
                break;

                //drawerLayout.closeDrawer(GravityCompat.START);
            default:
                return onNavigationItemSelected(menuItem);

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setNavigationViewListener(){
        NavigationView navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
    }
}
