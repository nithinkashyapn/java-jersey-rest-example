package com.nithin.jerseytest.APICaller;

import okhttp3.*;

import javax.ws.rs.*;
import java.io.IOException;

@Path("test")
public class TestAPI {

    OkHttpClient client = new OkHttpClient();

    String check(String url) throws IOException {
        RequestBody formBody = new FormBody
                .Builder()
                .add("email", "sydney@fife")
                .build();

        Request request = new Request.Builder()
                .url("https://reqres.in/api/register")
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();

    }

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @POST
    @Path("/")
    @Consumes("application/x-www-form-urlencoded")
    public String scrape(@FormParam("url") String url){

        TestAPI testAPI = new TestAPI();
        try {
            String response = testAPI.run(url);
            return response;
        } catch (Exception e) {
            System.out.println(e);
            return "Error";
        }
    }

    @POST
    @Path("/i")
    @Consumes("application/x-www-form-urlencoded")
    public String scraper(@FormParam("url") String url){

        TestAPI testAPI = new TestAPI();
        try {
            String response = testAPI.check(url);
            return response;
        } catch (Exception e) {
            System.out.println(e);
            return "Error";
        }
    }


}
