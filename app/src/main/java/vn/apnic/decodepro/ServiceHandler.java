package vn.apnic.decodepro;

import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceHandler {

    public final static int GET = 1;
    public final static int POST = 2;

    public ServiceHandler() {

    }

    public String makeService(String myURL, int myMethod) {
        return this.makeService(myURL, myMethod, null);
    }

    public String makeService(String myURL, int myMethod,
                              String s) {
        try {
            URL obj = new URL(myURL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            String method = null;
            if (myMethod == ServiceHandler.GET) {
                method = "GET";
            } else if (myMethod == ServiceHandler.POST) {
                method = "POST";
            }
            if (TextUtils.isEmpty(method)) {
            } else {
                con.setRequestMethod(method);
            }
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}