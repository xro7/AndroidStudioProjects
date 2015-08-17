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
import java.util.ArrayList;
import java.util.List;


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
    private String[][] runesIds =new String[30][5];
    private int[][] count =new int[30][5];
    private String[][] runesIds2 = new String[30][5];
    private int[][] count2 =new int[30][5];
    private int[] offense = {0,0,0,0,0,0,0,0,0,0};
    private int[] defense = {0,0,0,0,0,0,0,0,0,0};
    private int[] utility = {0,0,0,0,0,0,0,0,0,0};

    SummonerData[] summonerData = new SummonerData[10];


    TextView masteries1;
    TextView[] summonerTextViews = new TextView[10];
    ImageView[] championImage = new ImageView[10];
    ImageView[] summonerSpell1 = new ImageView[10];
    ImageView[] summonerSpell2 = new ImageView[10];

    public static final boolean DEBUG = false;

    public SummonerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summoner, container, false);  //can import different layouts depending on what game is played. should check it before though.

        for (int i =0;i<summonerTextViews.length;i++){
            int id = i+1;
            summonerTextViews[i] = (TextView) view.findViewById(getResources().getIdentifier("sum"+id,"id",getActivity().getPackageName()));
        }

        for (int i =0;i<championImage.length;i++){
            int id = i+1;
            championImage[i] = (ImageView) view.findViewById(getResources().getIdentifier("champ"+id,"id",getActivity().getPackageName()));
        }

     //   masteries1 = (TextView)view.findViewById(R.id.masteries1);

        for (int i =0;i<10;i++){
            int id = i+1;
            Log.e("id","champ"+id+"ss1");
            summonerSpell1[i] = (ImageView) view.findViewById(getResources().getIdentifier("champ"+id+"ss1","id",getActivity().getPackageName()));
        }


        for (int i =0;i<10;i++){
            int id = i+1;
            summonerSpell2[i] = (ImageView) view.findViewById(getResources().getIdentifier("champ"+id+"ss2","id",getActivity().getPackageName()));
        }



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
                findSummonerSpellFromId();
                setSummonerSpellImages();
                //computeMasteries();
                //setMasteries();
                //computeRunes();



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
            JSONArray array = response.getJSONArray("participants");
            JSONArray mastarray,runesarray ;
            List<Masteries> masteries = new ArrayList<Masteries>();
            Masteries mastery = new Masteries();
            List<Runes> runes = new ArrayList<Runes>();
            Runes rune = new Runes();
           // int t1 = 0,t2 = 0;

            for (int i=0;i<array.length();i++){
                summonerData[i] = new SummonerData();
                summonerData[i].setSummonerName(array.getJSONObject(i).getString("summonerName"));
                //Log.e("name",summonerData[i].getSummonerName());
                summonerData[i].setTeamId(array.getJSONObject(i).getInt("teamId"));
                summonerData[i].setChampionId(array.getJSONObject(i).getString("championId"));
                summonerData[i].setSummonerSpellId1(array.getJSONObject(i).getString("spell1Id"));
                summonerData[i].setSummonerSpellId2(array.getJSONObject(i).getString("spell2Id"));
                mastarray = array.getJSONObject(i).getJSONArray("masteries");
                for(int j=0;j<mastarray.length();j++){
                    mastery.setMasteryId(mastarray.getJSONObject(j).getString("masteryId"));
                    mastery.setRank(mastarray.getJSONObject(j).getInt("rank"));
                    masteries.add(mastery);
                }
                summonerData[i].setMasteries(masteries);
                runesarray = array.getJSONObject(i).getJSONArray("runes");
                for(int j=0;j<runesarray.length();j++){
                    rune.setRuneId(runesarray.getJSONObject(j).getString("runeId"));
                    rune.setCount(runesarray.getJSONObject(j).getInt("count"));
                    runes.add(rune);
                }
                summonerData[i].setRunes(runes);

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
            for(int i=0;i<10;i++){
                summonerData[i].setChampionName(jsonObj.getJSONObject("data").getJSONObject(summonerData[i].getChampionId()).getString("key"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void setSummonerNames(){

        for (int i = 0;i<10;i++){
            summonerTextViews[i].setText(summonerData[i].getSummonerName());
        }

    }

    public void setChampionImages(){
        int[] id = new int[10];

        for (int i = 0;i<10;i++){
            id[i] = getResources().getIdentifier(summonerData[i].getChampionName().toLowerCase(),"drawable",getActivity().getPackageName());

        }
        for (int i = 0;i<10;i++){
            championImage[i].setImageResource(id[i]);
        }
    }

    public void findSummonerSpellFromId(){
        String json = loadJSONFromAsset("SummonerSpells.json");

        try {
            JSONObject jsonObj = new JSONObject(json);
            for(int i=0;i<10;i++){
                summonerData[i].setSummonerSpell1(jsonObj.getJSONObject("data").getJSONObject(summonerData[i].getSummonerSpellId1()).getString("key"));
                summonerData[i].setSummonerSpell2(jsonObj.getJSONObject("data").getJSONObject(summonerData[i].getSummonerSpellId2()).getString("key"));


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setSummonerSpellImages(){

        int[] ss1 = new int[10];
        int[] ss2 = new int[10];

        for (int i = 0;i<10;i++){

            ss1[i] = getResources().getIdentifier(summonerData[i].getSummonerSpell1().toLowerCase(),"drawable",getActivity().getPackageName());
            ss2[i] = getResources().getIdentifier(summonerData[i].getSummonerSpell2().toLowerCase(),"drawable",getActivity().getPackageName());

        }

        for (int i = 0;i<10;i++){
            summonerSpell1[i].setImageResource(ss1[i]);
            summonerSpell2[i].setImageResource(ss2[i]);
        }




    }

    public void computeMasteries(){

        String json = loadJSONFromAsset("masteries.json");

        try {
            JSONObject jsonObj = new JSONObject(json);
            for (int i=0;i<5;i++){
                for (int j = 0; j < 30; j++) {
                  /*  if (masteriesIds[j][i]!=null) {

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
                    }*/

                }
                Log.e("masteries",offense[i]+"/"+defense[i]+"/"+utility[i]);
                Log.e("masteries",offense[i+5]+"/"+defense[i+5]+"/"+utility[i+5]);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void setMasteries(){

        masteries1.setText(offense[0]+"/"+defense[0]+"/"+utility[0]);

    }

    public  void computeRunes(){

        String json = loadJSONFromAsset("runes.json");
        String[][] description = new String[30][5];

        try {
            JSONObject jsonObj = new JSONObject(json);
            for (int i=0;i<5;i++){
                for (int j = 0; j < 30; j++) {
                    if (runesIds[j][i]!=null) {

                        description[j][i] = jsonObj.getJSONObject("data").getJSONObject(runesIds[j][i]).getString("description");
                        Log.e("Runes:",count[j][i]+" * "+description[j][i]);
                    }


                }


            }

            for (int i=0;i<5;i++){
                for (int j = 0; j < 30; j++) {
                    if (runesIds2[j][i]!=null) {

                        description[j][i] = jsonObj.getJSONObject("data").getJSONObject(runesIds2[j][i]).getString("description");

                        Log.e("Runes:",count2[j][i]+" * "+description[j][i]);
                    }


                }


            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        runesIds =null;
        runesIds2 = null;
        count =null;
        count2 =null;

    }


}
