package com.example.modernartui2;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.Random;


public class MainActivity extends Activity {

    int randomColor;
    int randomTime;
    android.os.Handler customHandler = new android.os.Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final View view1 = (View) findViewById(R.id.view1);
        final View view2 = (View) findViewById(R.id.view2);
        final View view3 = (View) findViewById(R.id.view3);
        final View view4 = (View) findViewById(R.id.view4);
        final View view5 = (View) findViewById(R.id.view5);
        final View view6 = (View) findViewById(R.id.view6);
        final View view7 = (View) findViewById(R.id.view7);
        final View view8 = (View) findViewById(R.id.view8);
        final View view9 = (View) findViewById(R.id.view9);
        final View view10 = (View) findViewById(R.id.view10);
        final View view11 = (View) findViewById(R.id.view11);
        final View view12 = (View) findViewById(R.id.view12);
        final View view13 = (View) findViewById(R.id.view13);


        view1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                randomColor = getRandomColor();
                view1.setBackgroundColor(randomColor);
            }


        });
        view2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                randomColor = getRandomColor();
                view2.setBackgroundColor(randomColor);
            }


        });
        view3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                randomColor = getRandomColor();
                view3.setBackgroundColor(randomColor);
            }


        });
        view4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                randomColor = getRandomColor();
                view4.setBackgroundColor(randomColor);
            }


        });
        view5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                randomColor = getRandomColor();
                view5.setBackgroundColor(randomColor);
            }


        });
        view6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                randomColor = getRandomColor();
                view6.setBackgroundColor(randomColor);
            }


        });
        view7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                randomColor = getRandomColor();
                view7.setBackgroundColor(randomColor);
            }


        });
        view8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                randomColor = getRandomColor();
                view8.setBackgroundColor(randomColor);
            }


        });
        view9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                randomColor = getRandomColor();
                view9.setBackgroundColor(randomColor);
            }


        });
        view10.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                randomColor = getRandomColor();
                view10.setBackgroundColor(randomColor);
            }


        });
        view11.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                randomColor = getRandomColor();
                view11.setBackgroundColor(randomColor);
            }


        });
        view12.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                randomColor = getRandomColor();
                view12.setBackgroundColor(randomColor);
            }


        });
        view13.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                randomColor = getRandomColor();
                view13.setBackgroundColor(randomColor);
            }


        });




        customHandler.postDelayed(new Runnable() {

            public void run() {
                randomColor = getRandomColor();
                randomTime = getRandomTime();
                view1.setBackgroundColor(randomColor);
                customHandler.postDelayed(this, randomTime);
            }
        }, 0);

        customHandler.postDelayed(new Runnable() {

            public void run() {
                randomColor = getRandomColor();
                randomTime = getRandomTime();
                view2.setBackgroundColor(randomColor);
                customHandler.postDelayed(this, randomTime);
            }
        }, 0);

        customHandler.postDelayed(new Runnable() {

            public void run() {
                randomColor = getRandomColor();
                randomTime = getRandomTime();
                view3.setBackgroundColor(randomColor);
                customHandler.postDelayed(this, randomTime);
            }
        }, 0);

        customHandler.postDelayed(new Runnable() {

            public void run() {
                randomTime = getRandomTime();
                randomColor = getRandomColor();
                view4.setBackgroundColor(randomColor);
                customHandler.postDelayed(this, randomTime);
            }
        }, 0);

        customHandler.postDelayed(new Runnable() {

            public void run() {
                randomColor = getRandomColor();
                randomTime = getRandomTime();
                view5.setBackgroundColor(randomColor);
                customHandler.postDelayed(this, randomTime);
            }
        }, 0);

        customHandler.postDelayed(new Runnable() {

            public void run() {
                randomTime = getRandomTime();
                randomColor = getRandomColor();
                view6.setBackgroundColor(randomColor);
                customHandler.postDelayed(this, randomTime);
            }
        }, 0);

        customHandler.postDelayed(new Runnable() {

            public void run() {
                randomTime = getRandomTime();
                randomColor = getRandomColor();
                view7.setBackgroundColor(randomColor);
                customHandler.postDelayed(this, randomTime);
            }
        }, 0);

        customHandler.postDelayed(new Runnable() {

            public void run() {
                randomTime = getRandomTime();
                randomColor = getRandomColor();
                view8.setBackgroundColor(randomColor);
                customHandler.postDelayed(this, randomTime);
            }
        }, 0);

        customHandler.postDelayed(new Runnable() {

            public void run() {
                randomTime = getRandomTime();
                randomColor = getRandomColor();
                view9.setBackgroundColor(randomColor);
                customHandler.postDelayed(this, randomTime);
            }
        }, 0);

        customHandler.postDelayed(new Runnable() {

            public void run() {
                randomTime = getRandomTime();
                randomColor = getRandomColor();
                view10.setBackgroundColor(randomColor);
                customHandler.postDelayed(this, randomTime);
            }
        }, 0);

        customHandler.postDelayed(new Runnable() {

            public void run() {
                randomTime = getRandomTime();
                randomColor = getRandomColor();
                view11.setBackgroundColor(randomColor);
                customHandler.postDelayed(this, randomTime);
            }
        }, 0);

        customHandler.postDelayed(new Runnable() {

            public void run() {
                randomTime = getRandomTime();
                randomColor = getRandomColor();
                view12.setBackgroundColor(randomColor);
                customHandler.postDelayed(this, randomTime);
            }
        }, 0);

        customHandler.postDelayed(new Runnable() {

            public void run() {
                randomTime = getRandomTime();
                randomColor = getRandomColor();
                view13.setBackgroundColor(randomColor);
                customHandler.postDelayed(this, randomTime);
            }
        }, 0);









    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
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


    public int getRandomColor(){
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((16 - 1) + 1) + 1;

        if (randomNum == 1){
            return getResources().getColor(R.color.white);
        }else if (randomNum == 2){
            return getResources().getColor(R.color.yellow);
        }else if (randomNum == 3){
            return getResources().getColor(R.color.fuchsia);
        }else if (randomNum == 4){
            return getResources().getColor(R.color.red);
        }else if (randomNum == 5){
            return getResources().getColor(R.color.silver);
        }else if (randomNum == 6){
            return getResources().getColor(R.color.gray);
        }else if (randomNum == 7){
            return getResources().getColor(R.color.olive);
        }else if (randomNum == 8){
            return getResources().getColor(R.color.purple);
        }else if (randomNum == 9){
            return getResources().getColor(R.color.maroon);
        }else if (randomNum == 10){
            return getResources().getColor(R.color.aqua);
        }else if (randomNum == 11){
            return getResources().getColor(R.color.lime);
        }else if (randomNum == 12){
            return getResources().getColor(R.color.teal);
        }else if (randomNum == 13){
            return getResources().getColor(R.color.green);
        }else if (randomNum == 14){
            return getResources().getColor(R.color.blue);
        }else if (randomNum == 15){
            return getResources().getColor(R.color.navy);
        }else
            return getResources().getColor(R.color.black);
    }

    public int getRandomTime() {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((15 - 5) + 1) + 5;
        return randomNum*1000;
    }


}
