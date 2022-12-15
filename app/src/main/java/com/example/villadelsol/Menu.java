package com.example.villadelsol;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.villadelsol.databinding.ActivityMenuBinding;
import com.example.villadelsol.ui.dashboard.DashboardFragment;
import com.example.villadelsol.ui.room1.Room1Fragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class Menu extends AppCompatActivity implements android.view.Menu{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMenuBinding binding;
    private ViewFlipper v_Flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String cel= "525548876966";
        String mensaje= "Hola";

        setSupportActionBar(binding.appBarMenu.toolbar);
        binding.appBarMenu.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Redireccionando al ChatBot...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                System.out.println("Direccionar a WhatsApp");

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_VIEW);
                String uri = "whatsapp://send?phone="+cel+"&text="+mensaje;
                sendIntent.setData(Uri.parse(uri));
                startActivity(sendIntent);
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_room1, R.id.nav_room2, R.id.nav_citas, R.id.nav_admin, R.id.nav_slideshow, R.id.nav_contact)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    //@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void dashboard(View view) {
        Intent intent_dash = new Intent(this,DashboardAdmin.class);
        startActivity(intent_dash);
    }

    public void cita(View view) {
        Intent intent_cita = new Intent(this,AgeDate.class);
        startActivity(intent_cita);
    }
    /*public void whats(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String uri = "whatsapp://send?phone=525548876966";
        sendIntent.setData(Uri.parse(uri));
        startActivity(sendIntent);
    }*/
    public void irS1(View view) {
    }
    public void irS2() {
        Intent i=new Intent(this, Salon2.class);
        startActivity(i);
    }
    public void PR1(View view) {
        Intent intent_pq1 = new Intent(this,PaquetesR1.class);
        startActivity(intent_pq1);
    }
    public void PR2(View view) {
        Intent intent_pq1 = new Intent(this,PaquetesR2.class);
        startActivity(intent_pq1);
    }
    public void showRoom1Fragment(View view) {
        System.out.println("CLICK EN LA IMAGEN");
        Fragment fr= new Room1Fragment();
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        //fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.replace(R.id.nav_host_fragment_content_menu,fr);
        fragmentTransaction.commit();

    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public MenuItem add(CharSequence charSequence) {
        return null;
    }

    @Override
    public MenuItem add(int i) {
        return null;
    }

    @Override
    public MenuItem add(int i, int i1, int i2, CharSequence charSequence) {
        return null;
    }

    @Override
    public MenuItem add(int i, int i1, int i2, int i3) {
        return null;
    }

    @Override
    public SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    @Override
    public SubMenu addSubMenu(int i) {
        return null;
    }

    @Override
    public SubMenu addSubMenu(int i, int i1, int i2, CharSequence charSequence) {
        return null;
    }

    @Override
    public SubMenu addSubMenu(int i, int i1, int i2, int i3) {
        return null;
    }

    @Override
    public int addIntentOptions(int i, int i1, int i2, ComponentName componentName, Intent[] intents, Intent intent, int i3, MenuItem[] menuItems) {
        return 0;
    }

    @Override
    public void removeItem(int i) {

    }

    @Override
    public void removeGroup(int i) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void setGroupCheckable(int i, boolean b, boolean b1) {

    }

    @Override
    public void setGroupVisible(int i, boolean b) {

    }

    @Override
    public void setGroupEnabled(int i, boolean b) {

    }

    @Override
    public boolean hasVisibleItems() {
        return false;
    }

    @Override
    public MenuItem findItem(int i) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public MenuItem getItem(int i) {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean performShortcut(int i, KeyEvent keyEvent, int i1) {
        return false;
    }

    @Override
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override
    public boolean performIdentifierAction(int i, int i1) {
        return false;
    }

    @Override
    public void setQwertyMode(boolean b) {

    }
}