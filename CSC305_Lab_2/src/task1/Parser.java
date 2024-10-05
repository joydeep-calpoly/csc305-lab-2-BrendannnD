package task1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static class Award {
        private final String name;
        private final int year;

        public Award(String name, int year) {
            this.name = name;
            this.year = year;
        }

        @Override
        public String toString() {
            return name + ", " + year;
        }
    }

    private static class Dignitary {
        private final List<String> knownFor;
        private final List<Award> awards;

        private final String name;

        public Dignitary(List<String> knownFor, List<Award> awards, String name) {
            this.knownFor = List.copyOf(knownFor);
            this.awards = List.copyOf(awards);
            this.name = name;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(name);
            builder.append("\n\nKnown For:\n"); // always include even if known for nothing?
            for(String accolade : knownFor) {
                builder.append("\t").append(accolade).append("\n");
            }
            builder.append("\nAwards:\n");
            for(Award award : awards) {
                builder.append("\t").append(award).append("\n");
            }
            return builder.toString();
        }


    }

    //             QUESTION: Does including the static member classes break single responsibility?
    public static void main(String[] args) {
        String fileName = "C:/Users/brend/OneDrive/Documents/GitHub/csc349/csc305-lab-2-BrendannnD/CSC305_Lab_2/src/input1.json";
        try {
            JSONObject jsonObject = new JSONObject(new String(Files.readAllBytes(Paths.get(fileName))));
            String name = jsonObject.getString("name");
            List<String> knownFor = new ArrayList<>();
            JSONArray knownForArr = jsonObject.getJSONArray("knownFor");
            for(int i = 0; i< knownForArr.length(); i++){
                knownFor.add(knownForArr.getString(i));
            }
            List<Award> awards = new ArrayList<>();
            JSONArray awardArr = jsonObject.getJSONArray("awards");
            for (int i = 0; i < awardArr.length(); i++){
                JSONObject jsonAwardObject = awardArr.getJSONObject(i);
                awards.add(new Award(jsonAwardObject.getString("name"),jsonAwardObject.getInt("year")));
            }
            Dignitary dignitary = new Dignitary(knownFor, awards, name);
            System.out.println(dignitary);
        }
        catch(Exception e) {
            System.out.println("Failed to read file: " + e);
        }
    }
}
