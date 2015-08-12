package com.chronoplay.lolscience;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
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
public class StartFragment extends Fragment {

    TextView text=null;
    private String blogTitles;
    public StartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_start, container, false);
        final Button button = (Button) view.findViewById(R.id.button);
        final EditText eText = (EditText)view.findViewById(R.id.editText);
        text = (TextView)view.findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String summoner = eText.getText().toString();
                Log.e("summoner", summoner);
                if (checkSummoner(summoner)){
                    summoner = fixSummoner(summoner);
                    Log.e("summoner2", summoner);
                    String url = "https://eune.api.pvp.net/api/lol/eune/v1.4/summoner/by-name/"+summoner+"?api_key=e95da8f9-5b0f-4a64-acb8-81113ce2d0c4";
                    new AsyncHttpTask().execute(url);
                }else{
                    Log.e("summoner3", summoner);
                    text.setText("Please type the summoner name");
                }



            }
        });
        return view;
    }
    private boolean checkSummoner(String summoner){
        if (summoner.equals("")){
            return false;
        }else{
            return true;
        }
    }
    private String fixSummoner(String summoner){
        summoner = summoner.replace(" ","");
        return summoner;
    }
    /*public String getJSON(String address){
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(address);
        try{
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if(statusCode == 200){
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while((line = reader.readLine()) != null){
                    builder.append(line);
                }
            } else {
                Log.e(StartFragment.class.toString(), "Failedet JSON object");
            }
        }catch(ClientProtocolException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }*/






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
                Log.d("asdfsa", e.getLocalizedMessage());
            }

            return result; //"Failed to fetch data!";
        }


        @Override
        protected void onPostExecute(Integer result) {
                /* Download complete. Lets update UI */

            if(result == 1){

                text.setText(blogTitles);
            }else{
                text.setText("Failed to fetch data!");
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



                blogTitles = response.toString();



            }catch (JSONException e){
                e.printStackTrace();
            }
        }
}
