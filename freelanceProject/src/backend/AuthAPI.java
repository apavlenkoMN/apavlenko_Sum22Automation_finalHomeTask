package backend;


import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

public class AuthAPI {

    public String signUp (String name, String pass) throws IOException{


        JSONObject json = new JSONObject();
        json.put("username", "usernameAPA");
        json.put("password", "passwordAPA");
        json.put("password", "passwordAPA");


        RequestBody body = RequestBody.create(json.toString().getBytes());

        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/auth/signup")
                .addHeader("Content-Type", "application/json")
                .addHeader("accept", "*/*")
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();
        //отправляет запрос
        Response response = client.newCall(request).execute();

        System.out.println("code is:");
        System.out.println(response.code());

        String responseBody = response.body().string();
        //JSONObject responseJson = new JSONObject(responseBody); //передаем строку в объект
        JSONObject responseJson = new JSONObject(responseBody);
        System.out.println("response username:");

        return responseJson.get("username").toString();

    }




    public String signIn(String name, String pass) throws IOException{

//        RequestBody formBody = new FormBody.Builder()
//                .add("username", name)
//                .add("password", pass)
//                .build();


        JSONObject json = new JSONObject();
        json.put("username", name);
        json.put("password", pass);


        RequestBody body = RequestBody.create(json.toString().getBytes());

        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/auth/signin")
                .addHeader("Content-Type", "application/json")
                .addHeader("accept", "*/*")
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();
        //отправляет запрос
        Response response = client.newCall(request).execute();

        System.out.println("code is:");
        System.out.println(response.code());
        //System.out.println(response.body().string());

        String responseBody = response.body().string();
        //JSONObject responseJson = new JSONObject(responseBody); //передаем строку в объект
        JSONObject responseJson = new JSONObject(responseBody);
        System.out.println("response token:");

//        {
//            "success": true,
//                "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMDgiLCJuYW1lIjpudWxsLCJpZCI6IjEwOCIsInVzZXJuYW1lIjoiYXBhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTY2MzAyODE5NywiZXhwIjoxNjYzMDMxNzk3fQ.b9jIJcBFLtlTJavrrxDnUjjU3iLprBUVupD3F-QMc0cj3Mf6xLdTst81KDNTkKyUIo6A7SBcZpH9wLtMLkEJog"
//        }
        System.out.println(responseJson.get("token").toString());
        return responseJson.get("token").toString();

    }


    public void createDefaultUser () throws IOException{


        JSONObject json = new JSONObject();
        json.put("username", "usernameAPA");
        json.put("password", "passwordAPA");
        json.put("password", "passwordAPA");


        RequestBody body = RequestBody.create(json.toString().getBytes());

        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/auth/signup")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "*/*")
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();
        //отправляет запрос
        Response response = client.newCall(request).execute();

        System.out.println("code is:");
        System.out.println(response.code());

        String responseBody = response.body().string();
        //JSONObject responseJson = new JSONObject(responseBody); //передаем строку в объект
        JSONObject responseJson = new JSONObject(responseBody);
        System.out.println("response get username");

        //return responseJson.get("username").toString();

    }


}

