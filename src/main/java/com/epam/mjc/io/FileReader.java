package com.epam.mjc.io;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = null;

        try (InputStream inputStream = new FileInputStream(file)) {

            String content = new String(inputStream.readAllBytes());
            String[] lines = content.split("\\R");

            String name = lines[0].split(" ")[1];
            Integer age = Integer.parseInt(lines[1].split(" ")[1]);
            String email = lines[2].split(" ")[1];
            Long phone = Long.parseLong(lines[3].split(" ")[1]);

            profile = new Profile(name,age,email,phone);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;
    }
}
