package com.epam.qavn.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonLoader {
    public static <T> T readJsonFile(String filePath, Class<T> valueType) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(filePath);
            return objectMapper.readValue(file, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
