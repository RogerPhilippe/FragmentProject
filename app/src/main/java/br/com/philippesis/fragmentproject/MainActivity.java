package br.com.philippesis.fragmentproject;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements FragmentMain.OnFragmentInteractionListener,
        FragmentSecondary.OnFragmentInteractionListener, View.OnClickListener{

    // Fragments
    private FragmentMain fragmentMain;
    private FragmentSecondary fragmentSecondary;

    // Fagments managers
    private FragmentManager fragmentManager;

    private FragmentTransaction fragmentTransaction;

    private Bundle msavedInstanceState;

    // Menu
    private TextView idtxPrincipal;
    private TextView idtxSecondary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.msavedInstanceState = savedInstanceState;
        this.setupUI();
        this.setListeners();

        fragmentManager = getSupportFragmentManager();

    }

    private void setupUI() {
        idtxPrincipal = findViewById(R.id.idtxPrincipal);
        idtxSecondary = findViewById(R.id.idtxSecondary);
    }

    private void setListeners() {
        idtxPrincipal.setOnClickListener(this);
        idtxSecondary.setOnClickListener(this);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {
        if (this.msavedInstanceState == null) {
            if (v == idtxPrincipal) {
                fragmentMain = new FragmentMain();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.idFrameLayoutMain, fragmentMain, "mainFragment");
                fragmentTransaction.commit();
            } else if (v == idtxSecondary) {
                fragmentSecondary = new FragmentSecondary();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.idFrameLayoutMain, fragmentSecondary, "secondaryFragment");
                fragmentTransaction.commit();
            }
        }
    }
}
