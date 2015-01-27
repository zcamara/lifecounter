package zcamara.washington.edu.lifecounter;

import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.animation.AnimationUtils;

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
        setContentView(R.layout.activity_main);
        p1Health = 20;
        p2Health = 20;
        p3Health = 20;
        p4Health = 20;
        p5Health = 20;
        p6Health = 20;
        p7Health = 20;
        p8Health = 20;
        numPlayers = 0;
        while(numPlayers < 2)
            addPlayer();
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
        TableRow player = (TableRow) findViewById(R.id.p1);
        switch (numPlayers){
            case 2:
                player = (TableRow) findViewById(R.id.p2);
                break;
            case 3:
                player = (TableRow) findViewById(R.id.p3);
                break;
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
        player.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
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
                p1Health = changeHealth(1,1,R.id.p1life,p1Health);
                break;
            case R.id.p1gain5:
                p1Health = changeHealth(1,5,R.id.p1life,p1Health);
                break;
            case R.id.p1lose1:
                p1Health = changeHealth(1,-1,R.id.p1life,p1Health);
                break;
            case R.id.p1lose5:
                p1Health = changeHealth(1,-5,R.id.p1life,p1Health);
                break;
            case R.id.p2gain1:
                p2Health = changeHealth(2,1,R.id.p2life,p2Health);
                break;
            case R.id.p2gain5:
                p2Health = changeHealth(2,5,R.id.p2life,p2Health);
                break;
            case R.id.p2lose1:
                p2Health = changeHealth(2,-1,R.id.p2life,p2Health);
                break;
            case R.id.p2lose5:
                p2Health = changeHealth(2,-5,R.id.p2life,p2Health);
                break;
            case R.id.p3gain1:
                p3Health = changeHealth(3,1,R.id.p3life,p3Health);
                break;
            case R.id.p3gain5:
                p3Health = changeHealth(3,5,R.id.p3life,p3Health);
                break;
            case R.id.p3lose1:
                p3Health = changeHealth(3,-1,R.id.p3life,p3Health);
                break;
            case R.id.p3lose5:
                p3Health = changeHealth(3,-5,R.id.p3life,p3Health);
                break;
            case R.id.p4gain1:
                p4Health = changeHealth(4,1,R.id.p4life,p4Health);
                break;
            case R.id.p4gain5:
                p4Health = changeHealth(4,5,R.id.p4life,p4Health);
                break;
            case R.id.p4lose1:
                p4Health = changeHealth(4,-1,R.id.p4life,p4Health);
                break;
            case R.id.p4lose5:
                p4Health = changeHealth(4,-5,R.id.p4life,p4Health);
                break;
            case R.id.p5gain1:
                p5Health = changeHealth(5,1,R.id.p5life,p5Health);
                break;
            case R.id.p5gain5:
                p5Health = changeHealth(5,5,R.id.p5life,p5Health);
                break;
            case R.id.p5lose1:
                p5Health = changeHealth(5,-1,R.id.p5life,p5Health);
                break;
            case R.id.p5lose5:
                p5Health = changeHealth(5,-5,R.id.p5life,p5Health);
                break;
            case R.id.p6gain1:
                p6Health = changeHealth(6,1,R.id.p6life,p6Health);
                break;
            case R.id.p6gain5:
                p6Health = changeHealth(6,5,R.id.p6life,p6Health);
                break;
            case R.id.p6lose1:
                p6Health = changeHealth(6,-1,R.id.p6life,p6Health);
                break;
            case R.id.p6lose5:
                p6Health = changeHealth(6,-5,R.id.p6life,p6Health);
                break;
            case R.id.p7gain1:
                p7Health = changeHealth(7,1,R.id.p7life,p7Health);
                break;
            case R.id.p7gain5:
                p7Health = changeHealth(7,5,R.id.p7life,p7Health);
                break;
            case R.id.p7lose1:
                p7Health = changeHealth(7,-1,R.id.p7life,p7Health);
                break;
            case R.id.p7lose5:
                p7Health = changeHealth(7,-5,R.id.p7life,p7Health);
                break;
            case R.id.p8gain1:
                p8Health = changeHealth(8,1,R.id.p8life,p8Health);
                break;
            case R.id.p8gain5:
                p8Health = changeHealth(8,5,R.id.p8life,p8Health);
                break;
            case R.id.p8lose1:
                p8Health = changeHealth(8,-1,R.id.p8life,p8Health);
                break;
            case R.id.p8lose5:
                p8Health = changeHealth(8,-5,R.id.p8life,p8Health);
                break;
        }
    }

    private int changeHealth(int player, int change, int life, int health) {
        if(health != 0) {
            health += change;
            TextView plife = (TextView) findViewById(life);
            if (health <= 0) {
                health = 0;
                announce("Player " + player + " LOSES!");
            }
            plife.setText("" + health);
            plife.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        } else {
            announce("Player " + player + " is already dead!");
        }
        return health;
    }

    private void announce(String msg) {
        TextView death = (TextView) findViewById(R.id.death);
        announcement = msg;
        death.setText(announcement);
        death.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
