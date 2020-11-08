package br.com.site.selenium.core.utils.enums;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONFileManager {

    public static void writeJson(String email, String senha) {
        JSONObject userData = new JSONObject();
        userData.put("login", email);
        userData.put("senha", senha);

        JSONArray userList = new JSONArray();
        userList.add(userData);

        try (FileWriter file = new FileWriter("src/main/java/br/com/site/selenium/core/utils/enums/loginAcess.json")) {

            file.write(userList.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readJSONEmail() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray obj = (JSONArray) parser.parse(new FileReader("src/main/java/br/com/site/selenium/core/utils/enums/loginAcess.json"));
        return obj.get(0).toString().substring(29).replace('"',' ').replace("}","").replace(" ","");

    }

    public static String readJSONSenha() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray obj = (JSONArray) parser.parse(new FileReader("src/main/java/br/com/site/selenium/core/utils/enums/loginAcess.json"));

        return obj.get(0).toString().substring(10,18);


    }

}
