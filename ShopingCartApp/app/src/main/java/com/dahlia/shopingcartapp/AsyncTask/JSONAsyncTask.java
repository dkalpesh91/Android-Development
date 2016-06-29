package com.dahlia.shopingcartapp.AsyncTask;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Admin on 10-06-2016.
 */
public class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {


    String mUrl = null;


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Boolean doInBackground(String... urls) {

        URL obj = null;
        mUrl = urls[0];
        try {
            obj = new URL(mUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + mUrl);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    protected void onPostExecute(Boolean result) {
        new JSONImageDownloadAsyncTask().execute(mUrl);
    }
}
