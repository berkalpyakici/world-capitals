package com.company;

import java.io.BufferedReader;
import java.lang.reflect.Type;
import java.util.List;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

class Capitals {
    private static final String JSON_PATH = "resources/capitals.json";
    List<Country> COUNTRIES;

    public static class Country {
        String country;
        String city;
    }

    /**
     * Updates COUNTRIES with the information loaded from the JSON file resting at JSON_PATH.
     */
    void loadCountries() {
        Gson gson = new Gson();

        try (BufferedReader br = new BufferedReader(new FileReader(JSON_PATH))) {
            Type type = new TypeToken<List<Country>>(){}.getType();
            COUNTRIES = gson.fromJson(br, type);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
