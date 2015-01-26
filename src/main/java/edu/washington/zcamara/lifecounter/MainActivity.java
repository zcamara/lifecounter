package edu.washington.zcamara.lifecounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        p1Health = 20;
        p2Health = 20;
        p3Health = 20;
        p4Health = 20;
    }

    //Use onSaveInstanceState(Bundle) and onRestoreInstanceState
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putInt("p1Health", p1Health);
        savedInstanceState.putInt("p2Health", p2Health);
        savedInstanceState.putInt("p3Health", p3Health);
        savedInstanceState.putInt("p4Health", p4Health);
        savedInstanceState.putString("announcement", announcement);
        super.onSaveInstanceState(savedInstanceState);
    }
    //onRestoreInstanceState
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        p1Health = savedInstanceState.getInt("p1Health");
        p2Health = savedInstanceState.getInt("p2Health");
        p3Health = savedInstanceState.getInt("p3Health");
        p4Health = savedInstanceState.getInt("p4Health");
        announcement = savedInstanceState.getString("announcement");
        TextView p1life = (TextView) findViewById(R.id.p1life);
        p1life.setText("" + p1Health);
        TextView p2life = (TextView) findViewById(R.id.p2life);
        p2life.setText("" + p2Health);
        TextView p3life = (TextView) findViewById(R.id.p3life);
        p3life.setText("" + p3Health);
        TextView p4life = (TextView) findViewById(R.id.p4life);
        p4life.setText("" + p4Health);
        TextView death = (TextView) findViewById(R.id.death);
        death.setText(announcement);
    }

    private int p1Health;
    private int p2Health;
    private int p3Health;
    private int p4Health;
    private String announcement;

    public void onBtnClicked(View v){
        switch(v.getId()) {
            case R.id.p1gain1:
                changeHealth(1,1);
                break;
            case R.id.p1gain5:
                changeHealth(1,5);
                break;
            case R.id.p1lose1:
                changeHealth(1,-1);
                break;
            case R.id.p1lose5:
                changeHealth(1,-5);
                break;
            case R.id.p2gain1:
                changeHealth(2,1);
                break;
            case R.id.p2gain5:
                changeHealth(2,5);
                break;
            case R.id.p2lose1:
                changeHealth(2,-1);
                break;
            case R.id.p2lose5:
                changeHealth(2,-5);
                break;
            case R.id.p3gain1:
                changeHealth(3,1);
                break;
            case R.id.p3gain5:
                changeHealth(3,5);
                break;
            case R.id.p3lose1:
                changeHealth(3,-1);
                break;
            case R.id.p3lose5:
                changeHealth(3,-5);
                break;
            case R.id.p4gain1:
                changeHealth(4,1);
                break;
            case R.id.p4gain5:
                changeHealth(4,5);
                break;
            case R.id.p4lose1:
                changeHealth(4,-1);
                break;
            case R.id.p4lose5:
                changeHealth(4,-5);
                break;
        }
    }

    private void changeHealth(int player, int change) {
        switch(player) {
            case 1:
                if(p1Health != 0) {
                    p1Health += change;
                    TextView p1life = (TextView) findViewById(R.id.p1life);
                    if (p1Health <= 0) {
                        p1Health = 0;
                        announce(player, false);
                    }
                    p1life.setText("" + p1Health);
                } else
                    announce(player, true);
                break;
            case 2:
                if(p2Health != 0) {
                    p2Health += change;
                    TextView p2life = (TextView) findViewById(R.id.p2life);
                    if (p2Health <= 0) {
                        p2Health = 0;
                        announce(player, false);
                    }
                    p2life.setText("" + p2Health);
                } else
                    announce(player, true);
                break;
            case 3:
                if(p3Health != 0) {
                    p3Health += change;
                    TextView p3life = (TextView) findViewById(R.id.p3life);
                    if (p3Health <= 0) {
                        p3Health = 0;
                        announce(player, false);
                    }
                    p3life.setText("" + p3Health);
                } else
                    announce(player, true);
                break;
            case 4:
                if(p4Health != 0) {
                    p4Health += change;
                    TextView p4life = (TextView) findViewById(R.id.p4life);
                    if (p4Health <= 0) {
                        p4Health = 0;
                        announce(player, false);
                    }
                    p4life.setText("" + p4Health);
                } else
                    announce(player, true);
                break;
        }
    }

    private void announce(int player, boolean beenDead){
        TextView death = (TextView) findViewById(R.id.death);
        if(beenDead)
            announcement = "Player " + player + " is already dead!";
        else
            announcement = "Player " + player + " LOSES!";
        death.setText(announcement);
    }

}
