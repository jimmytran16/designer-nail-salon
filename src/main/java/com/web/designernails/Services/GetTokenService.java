package com.web.designernails.Services;
import com.web.designernails.Interfaces.IGetTokenService;
import com.web.designernails.Domain.Token;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import com.google.gson.Gson;
import com.web.designernails.Domain.Token;

public class GetTokenService implements IGetTokenService{
    
    @Override 
    public Token requestForToken(String apiKey) {
        try {
            String getTokenUrl = System.getenv("GET_TOKEN_URL");

            URL url = new URL(getTokenUrl + "?apiKey=" + apiKey);
//	          URL url = new URL("http://localhost:5000/getToken?apiKey=" + apiKey);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

            String output;
            String data = "";
            System.out.println("Output from Server .... \n");
            
            while ((output = br.readLine()) != null) {
                data += output;
            }
            
            Gson gson = new Gson();
            Token token = gson.fromJson(data, Token.class);
            
            conn.disconnect();
            
            return token;

          } catch (MalformedURLException e) {

            e.printStackTrace();
            return null;

          } catch (IOException e) {

            e.printStackTrace();
            return null;

          }
    }

}
