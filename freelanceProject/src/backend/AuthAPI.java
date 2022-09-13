package backend;


import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

public class AuthAPI {

    public String signUp (String name, String pass) throws IOException{

        RequestBody formBody = new FormBody.Builder()
                .add("username", name)
                .add("password", pass)
                .add("confirmPassword", pass)
                .build();

        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/auth/signup")
                .addHeader("Content-Type", "application/json")
                .addHeader("accept", "*/*")
                .post(formBody)
                .build();

        OkHttpClient client = new OkHttpClient();
        //отправляет запрос
        Response response = client.newCall(request).execute();

        System.out.println(response.code());
        //System.out.println(response.body().string());

        System.out.println("set response body");

        String responseBody = response.body().string();
        //JSONObject responseJson = new JSONObject(responseBody); //передаем строку в объект
        JSONObject responseJson = new JSONObject(responseBody);
        System.out.println("response get username");

        return responseJson.get("username").toString();

    }




    public String signIn(String name, String pass) throws IOException{

        RequestBody formBody = new FormBody.Builder()
                .add("username", name)
                .add("password", pass)
                .build();

        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/auth/signin")
                .addHeader("Content-Type", "application/json")
                .addHeader("accept", "*/*")
                .post(formBody)
                .build();

        OkHttpClient client = new OkHttpClient();
        //отправляет запрос
        Response response = client.newCall(request).execute();

        System.out.println(response.code());
        //System.out.println(response.body().string());

        System.out.println("set response body");

        String responseBody = response.body().string();
        //JSONObject responseJson = new JSONObject(responseBody); //передаем строку в объект
        JSONObject responseJson = new JSONObject(responseBody);
        System.out.println("response get token");

//        {
//            "success": true,
//                "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMDgiLCJuYW1lIjpudWxsLCJpZCI6IjEwOCIsInVzZXJuYW1lIjoiYXBhIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTY2MzAyODE5NywiZXhwIjoxNjYzMDMxNzk3fQ.b9jIJcBFLtlTJavrrxDnUjjU3iLprBUVupD3F-QMc0cj3Mf6xLdTst81KDNTkKyUIo6A7SBcZpH9wLtMLkEJog"
//        }
        return responseJson.get("token").toString();

    }




}

