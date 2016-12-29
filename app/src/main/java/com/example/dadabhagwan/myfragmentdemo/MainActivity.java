package com.example.dadabhagwan.myfragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dadabhagwan.myfragmentdemo.Fragments.FragmentA;
import com.example.dadabhagwan.myfragmentdemo.Fragments.FragmentB;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    FragmentManager fragmentManager;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getFragmentManager();
        message= (TextView) findViewById(R.id.message);
        fragmentManager.addOnBackStackChangedListener(this);
    }
    public void addA(View view)
    {
       FragmentA A=new FragmentA();
       FragmentTransaction transaction=fragmentManager.beginTransaction();
       transaction.add(R.id.group,A,"A");
       transaction.addToBackStack("addA");
       transaction.commit();


    }
    public void addB(View view)
    {
        FragmentB B=new FragmentB();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.group,B,"B");
        transaction.addToBackStack("addB");
        transaction.commit();


    }
    public void removeA(View view)
    {
         FragmentA A= (FragmentA) fragmentManager.findFragmentByTag("A");
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.remove(A);
        transaction.addToBackStack("removeA");
        transaction.commit();

    }
    public void removeB(View view)
    {
        FragmentB B= (FragmentB) fragmentManager.findFragmentByTag("B");
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.remove(B);
        transaction.addToBackStack("removeB");
        transaction.commit();

    }
    public void replaceAwithB(View view)
    {
        FragmentB B=new FragmentB();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.group,B,"B");
        transaction.addToBackStack("replaceAwithB");
        transaction.commit();


    }
    public void replaceBwithA(View view)
    {
        FragmentA A=new FragmentA();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.group,A,"A");
        transaction.addToBackStack("replaceBwithA");
        transaction.commit();
    }

    public void attachA(View view)
    {
        FragmentA A= (FragmentA) fragmentManager.findFragmentByTag("A");
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.attach(A);
        transaction.addToBackStack("attachA");
        transaction.commit();
    }

    public void dettachA(View view)
    {
        FragmentA A= (FragmentA) fragmentManager.findFragmentByTag("A");
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.detach(A);
        transaction.addToBackStack("dettachA");
        transaction.commit();
    }

    public void back(View view)
    {
        fragmentManager.popBackStack();
    }
    public void popAddB(View view)
    {
        fragmentManager.popBackStack("addB",FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void onBackStackChanged() {
     message.setText(message.getText()+"\n");
     message.setText(message.getText()+"The Current Status of Back Stack:"+"\n");

     int count=fragmentManager.getBackStackEntryCount();
     for(int i=count-1;i>=0;i--)
     {
         FragmentManager.BackStackEntry entry=fragmentManager.getBackStackEntryAt(i);
         message.setText(message.getText()+" "+entry.getName()+"\n");


     }
     message.setText(message.getText()+"\n");

    }
}
