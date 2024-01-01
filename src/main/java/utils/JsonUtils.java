package utils;

import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class JsonUtils {

    // Read JSON file content as a string
    private static final JSONObject jsonObject;

    static {
        JSONObject tempObject = null;
        try {
            // Read JSON file content as a string
            String jsonContent = new String(Files.readAllBytes(Paths.get("D:\\Learning\\AppiumFramework\\src\\main\\resources\\data\\login.json")));

            // Parse the JSON string into a JSONObject
            tempObject = new JSONObject(jsonContent);
        } catch (Exception e) {
            e.printStackTrace();
        }

        jsonObject = tempObject;
    }

    public static String getJsonData(String param) {
        return jsonObject.getString(param);
    }

    public static void main(String[] args) {
        System.out.println(getJsonData("username"));
        System.out.println(getJsonData("password"));
    }

}
