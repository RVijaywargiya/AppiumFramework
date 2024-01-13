package utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class JsonUtils {

    // Read JSON file content as a string
    private static final JSONArray jsonArray;

    static {
        JSONArray tempObject = null;
        try {
            // Read JSON file content as a string
            String jsonContent = new String(Files.readAllBytes(Paths.get("D:\\Learning\\AppiumFramework\\src\\main\\resources\\data\\login.json")));

            // Parse the JSON string into a JSONObject
            tempObject = new JSONArray(jsonContent);
        } catch (Exception e) {
            e.printStackTrace();
        }

        jsonArray = tempObject;
    }

    public static String getJsonData(Integer index, String param) {
        return jsonArray.getJSONObject(index).getString(param);
    }
}
