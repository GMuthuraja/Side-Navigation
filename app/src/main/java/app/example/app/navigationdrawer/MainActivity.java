package app.example.app.navigationdrawer;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar bar;
    FloatingActionButton fab_button;
    DrawerLayout side_drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        fab_button = (FloatingActionButton) findViewById(R.id.fab);
        fab_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Swipe left to open Side Nav Drawer", Snackbar.LENGTH_LONG).show();
            }
        });


        side_drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle hamburger_icon = new ActionBarDrawerToggle(this, side_drawer, bar, R.string.open_drawer, R.string.close_drawer);
        side_drawer.addDrawerListener(hamburger_icon);
        hamburger_icon.syncState();

        NavigationView navItems = (NavigationView) findViewById(R.id.nav_view);
        navItems.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.nav_camera:
                Toast.makeText(getApplicationContext(), "You Clicked Camera!", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_gallery:
                Toast.makeText(getApplicationContext(), "You Clicked Gallery!", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_slide:
                Toast.makeText(getApplicationContext(), "You Clicked Slide!", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_share:
                Toast.makeText(getApplicationContext(), "You Clicked Share!", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_send:
                Toast.makeText(getApplicationContext(), "You Clicked Send!", Toast.LENGTH_LONG).show();
                break;
        }

        side_drawer.closeDrawer(Gravity.START);
        return true;
    }
}
