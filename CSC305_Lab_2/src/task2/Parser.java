package task2;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Parser {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Dignitary dignitary = mapper.readValue(new File("input3.json"), Dignitary.class);
            System.out.println(dignitary);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
