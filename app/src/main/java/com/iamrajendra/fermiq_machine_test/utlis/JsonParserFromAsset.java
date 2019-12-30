package com.iamrajendra.fermiq_machine_test.utlis;

import android.content.Context;

import com.iamrajendra.fermiq_machine_test.model.Country;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonParserFromAsset {

    public List<Country> loadJSONFromAssets(Context context) {
        String json = null;
        try {
            InputStream inputStream = context.getAssets().open("country_name.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parse(json);
    }

    private List<Country> parse(String json) {
        List<Country> countries  =  new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                countries.add(new Country(jsonArray.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return countries;
    }

}
