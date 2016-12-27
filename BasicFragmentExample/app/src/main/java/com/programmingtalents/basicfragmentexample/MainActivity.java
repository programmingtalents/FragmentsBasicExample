package com.programmingtalents.basicfragmentexample;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        FirstFragment firstFragment=new FirstFragment();
        fragmentTransaction.add(R.id.fragment_container,firstFragment);
        fragmentTransaction.addToBackStack("FirstFragment");//No hardcoding should be done, Bad Practice
        //Do like this
        //fragmentTransaction.addToBackStack(FirstFragment.FIRST_FRAGMENT);
        fragmentTransaction.commit();

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     *
     * @param uri : this is not required here, intention was just to show how to pass values
     */
    @Override
    public void onFragmentInteraction1(String uri) {
        Toast.makeText(MainActivity.this,"Callback", Toast.LENGTH_SHORT).show();

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        SecondFragment secondFragment=new SecondFragment();
        fragmentTransaction.replace(R.id.fragment_container,secondFragment);
        fragmentTransaction.addToBackStack("SecondFragment");
        fragmentTransaction.commit();

    }
    /**
     *
     * @param uri : this is not required here, intention was just to show how to pass values.
     *            You can change this parameter as per your need
     */
    @Override
    public void onFragmentInteraction2(Uri uri) {

    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager=getSupportFragmentManager();
        if(fragmentManager.getBackStackEntryCount()>1){
            fragmentManager.popBackStack();
        }else{
            super.onBackPressed();
        }

    }
}
