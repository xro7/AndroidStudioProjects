package com.chronoplay.lolscience;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * A placeholder fragment containing a simple view.
 */
public class SummonerFragment extends Fragment {

    private String[] names1 = new String[5];
    private String[] names2 = new String[5];
    private String[] champid1 =  new String[5];
    private String[] champid2 = new String[5];
    private String[] champnames1 = new String[5];
    private String[] champnames2 = new String[5];
    private String[] sumspellid1 = new String[5];
    private String[] sumspellid2 = new String[5];
    private String[] sumspellid12 = new String[5];
    private String[] sumspellid22 = new String[5];
    private String[] spellnames1 = new String[5];
    private String[] spellnames2 = new String[5];
    private String[] spellnames12 = new String[5];
    private String[] spellnames22 = new String[5];
    private String[][] masteriesIds =new String[30][5];
    private int[][] rank =new int[30][5];
    private String[][] masteriesIds2 = new String[30][5];
    private int[][] rank2 =new int[30][5];
    private int[] offense = {0,0,0,0,0,0,0,0,0,0};
    private int[] defense = {0,0,0,0,0,0,0,0,0,0};
    private int[] utility = {0,0,0,0,0,0,0,0,0,0};


    TextView sum1,sum2,sum3,sum4,sum5,sum6,sum7,sum8,sum9,sum10;
    ImageView champ1,champ2,champ3,champ4,champ5,champ6,champ7,champ8,champ9,champ10;
    ImageView champ1ss1,champ1ss2,champ2ss1,champ2ss2,champ3ss1,champ3ss2,champ4ss1,champ4ss2,champ5ss1,champ5ss2,champ6ss1,champ6ss2,champ7ss1,champ7ss2,champ8ss1,champ8ss2,champ9ss1,champ9ss2,champ10ss1,champ10ss2;
    public static final boolean DEBUG = false;

    public SummonerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summoner, container, false);  //can import different layouts depending on what game is played. should check it before though.
        sum1 = (TextView)view.findViewById(R.id.sum1);
        sum2 = (TextView)view.findViewById(R.id.sum2);
        sum3 = (TextView)view.findViewById(R.id.sum3);
        sum4 = (TextView)view.findViewById(R.id.sum4);
        sum5 = (TextView)view.findViewById(R.id.sum5);
        sum6 = (TextView)view.findViewById(R.id.sum6);
        sum7 = (TextView)view.findViewById(R.id.sum7);
        sum8 = (TextView)view.findViewById(R.id.sum8);
        sum9 = (TextView)view.findViewById(R.id.sum9);
        sum10 = (TextView)view.findViewById(R.id.sum10);

        champ1 = (ImageView)view.findViewById(R.id.champ1);
        champ2 = (ImageView)view.findViewById(R.id.champ2);
        champ3 = (ImageView)view.findViewById(R.id.champ3);
        champ4 = (ImageView)view.findViewById(R.id.champ4);
        champ5 = (ImageView)view.findViewById(R.id.champ5);
        champ6 = (ImageView)view.findViewById(R.id.champ6);
        champ7 = (ImageView)view.findViewById(R.id.champ7);
        champ8 = (ImageView)view.findViewById(R.id.champ8);
        champ9 = (ImageView)view.findViewById(R.id.champ9);
        champ10 = (ImageView)view.findViewById(R.id.champ10);

        champ1ss1 = (ImageView)view.findViewById(R.id.champ1ss1);
        champ1ss2 = (ImageView)view.findViewById(R.id.champ1ss2);
        champ2ss1 = (ImageView)view.findViewById(R.id.champ2ss1);
        champ2ss2 = (ImageView)view.findViewById(R.id.champ2ss2);
        champ3ss1 = (ImageView)view.findViewById(R.id.champ3ss1);
        champ3ss2 = (ImageView)view.findViewById(R.id.champ3ss2);
        champ4ss1 = (ImageView)view.findViewById(R.id.champ4ss1);
        champ4ss2 = (ImageView)view.findViewById(R.id.champ4ss2);
        champ5ss1 = (ImageView)view.findViewById(R.id.champ5ss1);
        champ5ss2 = (ImageView)view.findViewById(R.id.champ5ss2);
        champ6ss1 = (ImageView)view.findViewById(R.id.champ6ss1);
        champ6ss2 = (ImageView)view.findViewById(R.id.champ6ss2);
        champ7ss1 = (ImageView)view.findViewById(R.id.champ7ss1);
        champ7ss2 = (ImageView)view.findViewById(R.id.champ7ss2);
        champ8ss1 = (ImageView)view.findViewById(R.id.champ8ss1);
        champ8ss2 = (ImageView)view.findViewById(R.id.champ8ss2);
        champ9ss1 = (ImageView)view.findViewById(R.id.champ9ss1);
        champ9ss2 = (ImageView)view.findViewById(R.id.champ9ss2);
        champ10ss1 = (ImageView)view.findViewById(R.id.champ10ss1);
        champ10ss2 = (ImageView)view.findViewById(R.id.champ10ss2);


        Intent intent = getActivity().getIntent();   // need to get acrivity's intent
        String name = intent.getStringExtra("name");
        String id = intent.getStringExtra("id");
        if (DEBUG){

        }else {
            String url = "https://eune.api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/EUN1/" + id + "?api_key=e95da8f9-5b0f-4a64-acb8-81113ce2d0c4";
            new AsyncHttpTask().execute(url);
        }

        return view;
    }



    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected Integer doInBackground(String... params) {
            InputStream inputStream = null;
            Integer result = 0;
            try {
                    /* create Apache HttpClient */
                HttpClient httpclient = new DefaultHttpClient();

                    /* HttpGet Method */
                HttpGet httpGet = new HttpGet(params[0]);
                Log.e("http",params[0]);


                    /* optional request header */
                httpGet.setHeader("Content-Type", "application/json");


                    /* optional request header */
                httpGet.setHeader("Accept", "application/json");

                    /* Make http request call */
                HttpResponse httpResponse = httpclient.execute(httpGet);


                int statusCode = httpResponse.getStatusLine().getStatusCode();

                    /* 200 represents HTTP OK */
                if (statusCode ==  200) {

                        /* receive response as inputStream */
                    inputStream = httpResponse.getEntity().getContent();

                    String response = convertInputStreamToString(inputStream);

                    parseResult(response);

                    result = 1; // Successful

                }else{
                    result = 0; //"Failed to fetch data!";

                }

            } catch (Exception e) {
                Log.e("asdfsa", e.getLocalizedMessage());
            }

            return result; //"Failed to fetch data!";
        }


        @Override
        protected void onPostExecute(Integer result) {
                /* Download complete. Lets update UI */

            if(result == 1){

                setSummonerNames();
                findChampFromId();
                setChampionImages();
                findSummonerSpellFromID();
                setSummonerSpellImages();
                computeMasteries();



            }else{
                Log.e("ERROR", "Failed to fetch data!");
            }
        }
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));

        String line = "";
        String result = "";

        while((line = bufferedReader.readLine()) != null){
            result += line;
        }

                /* Close Stream */
        if(null!=inputStream){
            inputStream.close();
        }

        return result;
    }

    private void parseResult(String result) {
        try{
            JSONObject response = new JSONObject(result);
            JSONArray arr = response.getJSONArray("participants");
            JSONArray mastarray ;
            int t1 = 0,t2 = 0;

            for (int i=0;i<arr.length();i++){

                if ( Integer.parseInt(arr.getJSONObject(i).getString("teamId"))==100){
                    //champion names
                    names1[t1] = arr.getJSONObject(i).getString("summonerName");
                    Log.d("team1",names1[t1]+"");
                    champid1[t1] = arr.getJSONObject(i).getString("championId");
                    //summoner spells
                    sumspellid1[t1] =  arr.getJSONObject(i).getString("spell1Id");
                    sumspellid2[t1] =  arr.getJSONObject(i).getString("spell2Id");
                    //masteries
                    mastarray = arr.getJSONObject(i).getJSONArray("masteries");
                    Log.e("aray length",mastarray.length()+"");
                    for(int j=0;j<mastarray.length();j++){
                        masteriesIds[j][t1] = mastarray.getJSONObject(j).getString("masteryId");
                        rank[j][t1] = mastarray.getJSONObject(j).getInt("rank");
                        System.out.println(masteriesIds[j][t1] +" "+rank[j][t1]);

                    }
                    Log.d("spells",sumspellid1[t1]+" "+sumspellid2[t1]);
                    Log.d("cid",champid1[t1]+"");


                    t1++;
                }else{
                    //champion names
                    names2[t2] = arr.getJSONObject(i).getString("summonerName");
                    Log.d("team2",names2[t2]+"");
                    champid2[t2] = arr.getJSONObject(i).getString("championId");
                    //summoner spells
                    sumspellid12[t2] =  arr.getJSONObject(i).getString("spell1Id");
                    sumspellid22[t2] =  arr.getJSONObject(i).getString("spell2Id");
                    //masteries
                    mastarray = arr.getJSONObject(i).getJSONArray("masteries");
                    for(int j=0;j<mastarray.length();j++){
                        masteriesIds2[j][t2] = mastarray.getJSONObject(j).getString("masteryId");
                        rank2[j][t2] = mastarray.getJSONObject(j).getInt("rank");
                        System.out.println(masteriesIds[j][t2] +" "+rank[j][t2]);
                    }
                    Log.d("spells",sumspellid12[t2]+" "+sumspellid22[t2]);
                    Log.d("cid",champid2[t2]+"");
                    t2++;
                }


            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset(String file) {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void findChampFromId(){

        String json = loadJSONFromAsset("championids.json");

        try {
            JSONObject jsonObj = new JSONObject(json);
            for(int i=0;i<5;i++){
                champnames1[i] = jsonObj.getJSONObject("data").getJSONObject(champid1[i]).getString("key");
                Log.d("champname", champnames1[i]);
                champnames2[i] = jsonObj.getJSONObject("data").getJSONObject(champid2[i]).getString("key");
                Log.d("champname",champnames2[i]);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



    public void setSummonerNames(){

        sum1.setText(names1[0]);
        sum3.setText(names1[1]);
        sum5.setText(names1[2]);
        sum7.setText(names1[3]);
        sum9.setText(names1[4]);
        sum2.setText(names2[0]);
        sum4.setText(names2[1]);
        sum6.setText(names2[2]);
        sum8.setText(names2[3]);
        sum10.setText(names2[4]);

    }

    public void setChampionImages(){
        int[] id = new int[5];
        int[] id2 = new int[5];
        for (int i = 0;i<5;i++){
            id[i] = getResources().getIdentifier(champnames1[i].toLowerCase(),"drawable",getActivity().getPackageName());
            id2[i] = getResources().getIdentifier(champnames2[i].toLowerCase(),"drawable",getActivity().getPackageName());

        }

        champ1.setImageResource(id[0]);
        champ2.setImageResource(id2[0]);
        champ3.setImageResource(id[1]);
        champ4.setImageResource(id2[1]);
        champ5.setImageResource(id[2]);
        champ6.setImageResource(id2[2]);
        champ7.setImageResource(id[3]);
        champ8.setImageResource(id2[3]);
        champ9.setImageResource(id[4]);
        champ10.setImageResource(id2[4]);

    }

    public void findSummonerSpellFromID(){
        String json = loadJSONFromAsset("SummonerSpells.json");

        try {
            JSONObject jsonObj = new JSONObject(json);
            for(int i=0;i<5;i++){
                spellnames1[i] = jsonObj.getJSONObject("data").getJSONObject(sumspellid1[i]).getString("key");
                spellnames2[i] = jsonObj.getJSONObject("data").getJSONObject(sumspellid2[i]).getString("key");
                spellnames12[i] = jsonObj.getJSONObject("data").getJSONObject(sumspellid12[i]).getString("key");
                spellnames22[i] = jsonObj.getJSONObject("data").getJSONObject(sumspellid22[i]).getString("key");



            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setSummonerSpellImages(){

        int[] ss1 = new int[5];
        int[] ss2 = new int[5];
        int[] ss12 = new int[5];
        int[] ss22 = new int[5];
        for (int i = 0;i<5;i++){
            ss1[i] = getResources().getIdentifier(spellnames1[i].toLowerCase(),"drawable",getActivity().getPackageName());
            ss2[i] = getResources().getIdentifier(spellnames2[i].toLowerCase(),"drawable",getActivity().getPackageName());
            ss12[i] = getResources().getIdentifier(spellnames12[i].toLowerCase(),"drawable",getActivity().getPackageName());
            ss22[i] = getResources().getIdentifier(spellnames22[i].toLowerCase(),"drawable",getActivity().getPackageName());

        }
        champ1ss1.setImageResource(ss1[0]);
        champ1ss2.setImageResource(ss2[0]);
        champ2ss1.setImageResource(ss12[0]);
        champ2ss2.setImageResource(ss22[0]);
        champ3ss1.setImageResource(ss1[1]);
        champ3ss2.setImageResource(ss2[1]);
        champ4ss1.setImageResource(ss12[1]);
        champ4ss2.setImageResource(ss22[1]);
        champ5ss1.setImageResource(ss1[2]);
        champ5ss2.setImageResource(ss2[2]);
        champ6ss1.setImageResource(ss12[2]);
        champ6ss2.setImageResource(ss22[2]);
        champ7ss1.setImageResource(ss1[3]);
        champ7ss2.setImageResource(ss2[3]);
        champ8ss1.setImageResource(ss12[3]);
        champ8ss2.setImageResource(ss22[3]);
        champ9ss1.setImageResource(ss1[4]);
        champ9ss2.setImageResource(ss2[4]);
        champ10ss1.setImageResource(ss12[4]);
        champ10ss2.setImageResource(ss22[4]);




    }

    public void computeMasteries(){

        String json = loadJSONFromAsset("masteries.json");

        try {
            JSONObject jsonObj = new JSONObject(json);
            for (int i=0;i<5;i++){
                for (int j = 0; j < 30; j++) {
                    if (masteriesIds[j][i]!=null) {

                        if (jsonObj.getJSONObject("data").getJSONObject(masteriesIds[j][i]).getString("masteryTree").equals("Offense")) {
                            offense[i] = offense[i] + rank[j][i];

                        }else if (jsonObj.getJSONObject("data").getJSONObject(masteriesIds[j][i]).getString("masteryTree").equals("Defense")){
                            defense[i] = defense[i] + rank[j][i];
                        }else{
                            utility[i] = utility[i] + rank[j][i];
                        }
                    }

                    if (masteriesIds2[j][i]!=null) {

                        if (jsonObj.getJSONObject("data").getJSONObject(masteriesIds2[j][i]).getString("masteryTree").equals("Offense")) {
                            offense[i+5] = offense[i+5] + rank2[j][i];

                        }else if (jsonObj.getJSONObject("data").getJSONObject(masteriesIds2[j][i]).getString("masteryTree").equals("Defense")){
                            defense[i+5] = defense[i+5] + rank2[j][i];
                        }else{
                            utility[i+5] = utility[i+5] + rank2[j][i];
                        }
                    }

                }
                Log.e("masteries",offense[i]+"/"+defense[i]+"/"+utility[i]);
                Log.e("masteries",offense[i+5]+"/"+defense[i+5]+"/"+utility[i+5]);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}
