package edu.washington.zcamara.lifecounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity
{

    private int p1Health;
    private int p2Health;
    private int p3Health;
    private int p4Health;
    private int p5Health;
    private int p6Health;
    private int p7Health;
    private int p8Health;
    private int numPlayers;
    private String announcement;

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
        p5Health = 20;
        p6Health = 20;
        p7Health = 20;
        p8Health = 20;
        numPlayers = 2;
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
        savedInstanceState.putInt("p5Health", p5Health);
        savedInstanceState.putInt("p6Health", p6Health);
        savedInstanceState.putInt("p7Health", p7Health);
        savedInstanceState.putInt("p8Health", p8Health);
        savedInstanceState.putInt("numPlayers", numPlayers);
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
        p5Health = savedInstanceState.getInt("p5Health");
        p6Health = savedInstanceState.getInt("p6Health");
        p7Health = savedInstanceState.getInt("p7Health");
        p8Health = savedInstanceState.getInt("p8Health");
        int playersToAdd = savedInstanceState.getInt("numPlayers");
        announcement = savedInstanceState.getString("announcement");
        TextView p1life = (TextView) findViewById(R.id.p1life);
        p1life.setText("" + p1Health);
        TextView p2life = (TextView) findViewById(R.id.p2life);
        p2life.setText("" + p2Health);
        TextView p3life = (TextView) findViewById(R.id.p3life);
        p3life.setText("" + p3Health);
        TextView p4life = (TextView) findViewById(R.id.p4life);
        p4life.setText("" + p4Health);
        TextView p5life = (TextView) findViewById(R.id.p5life);
        p5life.setText("" + p5Health);
        TextView p6life = (TextView) findViewById(R.id.p6life);
        p6life.setText("" + p6Health);
        TextView p7life = (TextView) findViewById(R.id.p7life);
        p7life.setText("" + p7Health);
        TextView p8life = (TextView) findViewById(R.id.p8life);
        p8life.setText("" + p8Health);
        while(playersToAdd > numPlayers)
            addPlayer();
        announce(announcement);
    }

    private void addPlayer() {
        numPlayers++;
        TableRow player = (TableRow) findViewById(R.id.p3);;
        switch (numPlayers){
            case 4:
                player = (TableRow) findViewById(R.id.p4);
                break;
            case 5:
                player = (TableRow) findViewById(R.id.p5);
                break;
            case 6:
                player = (TableRow) findViewById(R.id.p6);
                break;
            case 7:
                player = (TableRow) findViewById(R.id.p7);
                break;
            case 8:
                player = (TableRow) findViewById(R.id.p8);
                break;
        }
        player.setVisibility(View.VISIBLE);
    }

    public void onBtnClicked(View v){
        switch(v.getId()) {
            case R.id.addPlayer:
                if(numPlayers < 8)
                    addPlayer();
                else
                    announce("You've reached the 8 player limit!");
                break;
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
            case R.id.p5gain1:
                changeHealth(5,1);
                break;
            case R.id.p5gain5:
                changeHealth(5,5);
                break;
            case R.id.p5lose1:
                changeHealth(5,-1);
                break;
            case R.id.p5lose5:
                changeHealth(5,-5);
                break;
            case R.id.p6gain1:
                changeHealth(6,1);
                break;
            case R.id.p6gain5:
                changeHealth(6,5);
                break;
            case R.id.p6lose1:
                changeHealth(6,-1);
                break;
            case R.id.p6lose5:
                changeHealth(6,-5);
                break;
            case R.id.p7gain1:
                changeHealth(7,1);
                break;
            case R.id.p7gain5:
                changeHealth(7,5);
                break;
            case R.id.p7lose1:
                changeHealth(7,-1);
                break;
            case R.id.p7lose5:
                changeHealth(7,-5);
                break;
            case R.id.p8gain1:
                changeHealth(8,1);
                break;
            case R.id.p8gain5:
                changeHealth(8,5);
                break;
            case R.id.p8lose1:
                changeHealth(8,-1);
                break;
            case R.id.p8lose5:
                changeHealth(8,-5);
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
            case 5:
                if(p5Health != 0) {
                    p5Health += change;
                    TextView p5life = (TextView) findViewById(R.id.p5life);
                    if (p5Health <= 0) {
                        p5Health = 0;
                        announce(player, false);
                    }
                    p5life.setText("" + p5Health);
                } else
                    announce(player, true);
                break;
            case 6:
                if(p6Health != 0) {
                    p6Health += change;
                    TextView p6life = (TextView) findViewById(R.id.p6life);
                    if (p6Health <= 0) {
                        p6Health = 0;
                        announce(player, false);
                    }
                    p6life.setText("" + p6Health);
                } else
                    announce(player, true);
                break;
            case 7:
                if(p7Health != 0) {
                    p7Health += change;
                    TextView p7life = (TextView) findViewById(R.id.p7life);
                    if (p7Health <= 0) {
                        p7Health = 0;
                        announce(player, false);
                    }
                    p7life.setText("" + p7Health);
                } else
                    announce(player, true);
                break;
            case 8:
                if(p8Health != 0) {
                    p8Health += change;
                    TextView p8life = (TextView) findViewById(R.id.p8life);
                    if (p8Health <= 0) {
                        p8Health = 0;
                        announce(player, false);
                    }
                    p8life.setText("" + p8Health);
                } else
                    announce(player, true);
                break;
        }
    }

    private void announce(String msg) {
        TextView death = (TextView) findViewById(R.id.death);
        announcement = msg;
        death.setText(announcement);
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
