package com.web.designernails.Services;
import com.web.designernails.Interfaces.IConfirmationService;
import com.web.designernails.Interfaces.IGetTokenService;
import com.web.designernails.Domain.Email;
import com.web.designernails.Domain.Token;
import java.net.URL;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import com.google.gson.Gson;
import com.web.designernails.Domain.Token;

public class ConfirmationService implements IConfirmationService{
    
	@Override
    public void sendEmail(Email email) {
    	 HttpURLConnection connection = null;
         InputStream is = null;
        try {
        	// Create JSON from email object
            Gson gson = new Gson();
            String requestJSON = gson.toJson(email);
            String apiURL = System.getenv("API_SEND_EMAIL");
        	//Create connection
            URL url = new URL(apiURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setRequestProperty("Content-Length", Integer.toString(requestJSON.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");  
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            
            //Send request
            System.out.println(requestJSON);
            DataOutputStream wr = new DataOutputStream (
            connection.getOutputStream());
            wr.writeBytes(requestJSON);
            wr.close();

            //Get Response  
            try {
                is = connection.getInputStream();
                System.out.println(is.toString());
            } catch (IOException ioe) {
                if (connection instanceof HttpURLConnection) {
                    HttpURLConnection httpConn = (HttpURLConnection) connection;
                    int statusCode = httpConn.getResponseCode();
                    if (statusCode != 200) {
                        is = httpConn.getErrorStream();
                    }
                }
            }

          } catch (MalformedURLException e) {

            e.printStackTrace();
          } catch (IOException e) {

            e.printStackTrace();
          }
    }


}
