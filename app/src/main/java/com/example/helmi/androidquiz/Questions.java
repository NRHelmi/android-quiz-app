package com.example.helmi.androidquiz;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Vector;




class Questions {


    Vector<String> questions = new Vector();
    Vector<String> options   = new Vector();
    Vector<String> answers   = new Vector();

    public Questions(String url,String category) throws Exception{
        parseJson(url,category);
    }

    public Vector<String> getQuestions() {
        return questions;
    }

    public Vector<String> getOptions() {
        return options;
    }

    public Vector<String> getAnswers() {
        return answers;
    }




    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    private void parseJson(String url,String category) throws Exception{
        JSONObject obj = new JSONObject(readUrl(url));

        JSONArray arr = obj.getJSONArray(category);
        for(int i=0;i<arr.length();i++){
            questions.add((String)arr.getJSONObject(i).get("Question"));
            options.add((String)arr.getJSONObject(i).getJSONObject("Options").get("1"));
            options.add((String)arr.getJSONObject(i).getJSONObject("Options").get("2"));
            options.add((String)arr.getJSONObject(i).getJSONObject("Options").get("3"));
            answers.add((String)arr.getJSONObject(i).get("Answer"));
        }
    }
}