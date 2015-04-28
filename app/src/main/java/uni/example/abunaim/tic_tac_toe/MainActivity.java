package uni.example.abunaim.tic_tac_toe;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
Button a1,a2,a3,b1,b2,b3,c1,c2,c3;
    TextView reslview;
    Button []barray;
    boolean turn_flage=true;
    int turn_count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a1=(Button)findViewById(R.id.button1);
        a2=(Button)findViewById(R.id.button2);
        a3=(Button)findViewById(R.id.button3);

        b1=(Button)findViewById(R.id.button4);
        b2=(Button)findViewById(R.id.button5);
        b3=(Button)findViewById(R.id.button6);

        c1=(Button)findViewById(R.id.button7);
        c2=(Button)findViewById(R.id.button8);
        c3=(Button)findViewById(R.id.button9);
        reslview=(TextView)findViewById(R.id.rsltmsg);
        barray=new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};

        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        reslview.setOnClickListener(this);

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

    @Override
    public void onClick(View v )
    {
        reslview.setClickable(false);
        Button b= (Button)v;
        buttonclicked(b);


    }


    public void buttonclicked(Button b) {
        if (turn_flage) {//X Turn
            b.setText("X");
            turn_count++;

        } else { // O Turn
            b.setText("O");
            turn_count++;
        }



        b.setClickable(false);
        turn_flage = !turn_flage;
        check_winner();
    }

    public void check_winner() {
        boolean winner_flage = false;
        //to check the horezintal
        if (a1.getText() == a2.getText() && a2.getText() == a3.getText()&& !a1.isClickable())
            winner_flage = true;

        if (b1.getText() == b2.getText() && b2.getText() == b3.getText()&& !b1.isClickable())
            winner_flage = true;

            if (c1.getText() == c2.getText() && c2.getText() == c3.getText()&& !c1.isClickable())
                winner_flage = true;
            else if (a1.getText() == b1.getText() && b1.getText() == c1.getText()
                    && !a1.isClickable())
                winner_flage = true;
            else if (a2.getText() == b2.getText() && b2.getText() == c2.getText()
                    && !b2.isClickable())
                winner_flage = true;
            else if (a3.getText() == b3.getText() && b3.getText() == c3.getText()
                    && !c3.isClickable())
                winner_flage = true;

                // diagonal:
            else if (a1.getText() == b2.getText() && b2.getText() == c3.getText()
                    && !a1.isClickable())
                winner_flage = true;
            else if (a3.getText() == b2.getText() && b2.getText() == c1.getText()
                    && !b2.isClickable())
                winner_flage = true;





        if (winner_flage) {
            if (!turn_flage) {
                reslview.setText("X wins");
            } else  {
                reslview.setText("O wins");
            }
            disable_enable(false);
        }
        else if  (turn_count == 9){
                reslview.setText("Draw!");

        }

        }

    public void disable_enable(boolean en){
        for(Button b:barray)
        {
            b.setClickable(en);
        }



    }










}
