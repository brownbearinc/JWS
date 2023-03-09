import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        makeConnectWithISS();
        System.out.println("---------------------");
        teacherMethod();

    }

    public static void makeConnectWithISS(){
        try {

            URL url = new URL("https://api.wheretheiss.at/v1/satellites/25544");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();

            System.out.print("\033[35mWe are making the connect right now... \033[0m");

            if (responseCode == 200){
                System.out.println("\033[32mSuccessfully\033[0m");
            } else if (responseCode == 400) {
                System.out.println("\033[31mBad Request\033[0m");
            } else if (responseCode == 401) {
                System.out.println("\033[31mUnauthorized\033[0m");
            } else if (responseCode == 403) {
                System.out.println("\033[31mForbidden\033[0m");
            } else if (responseCode == 404) {
                System.out.println("\033[31mNot Found\033[0m");
            } else if (responseCode == 500) {
                System.out.println("\033[31mInternal Server Error\033[0m");
            } else if (responseCode == 502) {
                System.out.println("\033[31mBad Gateway\033[0m");
            } else if (responseCode == 503) {
                System.out.println("\033[31mService Unavailable\033[0m");
            } else {
                System.out.println("I have no idea sorry...");
            }

            // Add and read JSON data from the WhereTheISS API
            InputStream inputStream = connection.getInputStream();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(inputStream, "UTF-8"));
            inputStream.close();

            System.out.println("\n\033[34m###########[INFORMATION]###########\033[0m");
            System.out.println("\033[36mObject: \033[0m" + jsonObject.get("name"));
            System.out.println("\033[36mLatitude: \033[0m" + jsonObject.get("latitude"));
            System.out.println("\033[36mLongitude: \033[0m" + jsonObject.get("longitude"));
            System.out.println("\033[36mAltitude: \033[0m" + jsonObject.get("altitude"));
            System.out.println("\033[36mVelocity: \033[0m" + jsonObject.get("velocity"));

        } catch (Exception error) {
            System.out.println(error);
        }
    }

    public static void teacherMethod(){
        try {

            URL url = new URL("https://api.wheretheiss.at/v1/satellites/25544");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();

            System.out.print("\033[35mWe are making the connect right now... \033[0m");

            if (responseCode == 200){
                System.out.println("\033[32mSuccessfully\033[0m");
            } else if (responseCode == 400) {
                System.out.println("\033[31mBad Request\033[0m");
            } else if (responseCode == 401) {
                System.out.println("\033[31mUnauthorized\033[0m");
            } else if (responseCode == 403) {
                System.out.println("\033[31mForbidden\033[0m");
            } else if (responseCode == 404) {
                System.out.println("\033[31mNot Found\033[0m");
            } else if (responseCode == 500) {
                System.out.println("\033[31mInternal Server Error\033[0m");
            } else if (responseCode == 502) {
                System.out.println("\033[31mBad Gateway\033[0m");
            } else if (responseCode == 503) {
                System.out.println("\033[31mService Unavailable\033[0m");
            } else {
                System.out.println("I have no idea sorry...");
            }


            StringBuilder strData = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext())
                strData.append(scanner.nextLine());

            scanner.close();

            JSONObject jsonObject = (JSONObject) new JSONParser().parse(String.valueOf(strData));

            System.out.println("\n\033[34m###########[INFORMATION]###########\033[0m");
            System.out.println("\033[36mObject: \033[0m" + jsonObject.get("name"));
            System.out.println("\033[36mLatitude: \033[0m" + jsonObject.get("latitude"));
            System.out.println("\033[36mLongitude: \033[0m" + jsonObject.get("longitude"));
            System.out.println("\033[36mAltitude: \033[0m" + jsonObject.get("altitude"));
            System.out.println("\033[36mVelocity: \033[0m" + jsonObject.get("velocity"));

        } catch (Exception error) {
            System.out.println(error);
        }
    }

}