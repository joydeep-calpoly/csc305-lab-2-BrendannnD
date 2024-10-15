package task1;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static void main(String[] args) {
        String fileName = "input1.json";
        try {
            JSONObject jsonObject = new JSONObject(new String(Files.readAllBytes(Paths.get(fileName))));
            String name = jsonObject.getString("name");
            List<String> knownFor = new ArrayList<>();
            JSONArray knownForArr = jsonObject.getJSONArray("knownFor");
            for(int i = 0; i< knownForArr.length(); i++){
                knownFor.add(knownForArr.getString(i));
            }
            List<Dignitary.Award> awards = new ArrayList<>();
            JSONArray awardArr = jsonObject.getJSONArray("awards");
            for (int i = 0; i < awardArr.length(); i++){
                JSONObject jsonAwardObject = awardArr.getJSONObject(i);
                awards.add(new Dignitary.Award(jsonAwardObject.getString("name"),jsonAwardObject.getInt("year")));
            }
            Dignitary dignitary = new Dignitary(knownFor, awards, name);
            System.out.println(dignitary);
        }
        catch(Exception e) {
            System.out.println("Failed to read file: " + e);
        }
    }
}
