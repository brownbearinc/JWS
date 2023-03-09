import org.json.simple.JSONObject;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("puush");

        // Create a JSON Object
        JSONObject jsonOb = new JSONObject();

        // Add values in JSON object
        jsonOb.put("name","Oliver");
        jsonOb.put("age", 17);

        String filePath = System.getProperty("user.dir") + "/data/filename.json";
        Object object = new JSONParser().parse(new FileReader(filePath));
        JSONObject jsonData = (JSONObject) object;
        JSONObject person = (JSONObject) jsonData.get("p1");
        String name = (String) person.get("language");

        // Print
        System.out.println(String.format("My name is %s", name));

    }
}