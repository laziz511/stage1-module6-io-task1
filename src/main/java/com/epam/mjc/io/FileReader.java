package com.epam.mjc.io;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = null;

        try (InputStream inputStream = new FileInputStream(file)) {
            
            // .split("\\R") = splits the String according to the beginning of the line, returns an array of split Strings.
            // In this case it is divided into 4.
            String content = new String(inputStream.readAllBytes());
            String[] lines = content.split("\\R");
            
            String name = lines[0].split(" ")[1]; // split the line when " " is met, and return the second part.
            Integer age = Integer.parseInt(lines[1].split(" ")[1]); // parseInt() = takes only a String as a parameter, and returns a primitive int value.
            String email = lines[2].split(" ")[1];
            Long phone = Long.parseLong(lines[3].split(" ")[1]);

            profile = new Profile(name,age,email,phone);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;
    }
}
