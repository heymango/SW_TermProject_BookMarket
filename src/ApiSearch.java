import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import netscape.javascript.JSObject;

import java.io.*;
import java.net.*;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

public class ApiSearch {

    public static void main(String[] args) {
        String clientId = "KakaoAK 993196a87417a24b44b200335ae8b947";

        String query = null;
        try {
            query = URLEncoder.encode("미움받을 용기","UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        URL url = null;
        try {
            url = new URL("https://dapi.kakao.com/v3/search/book?target=title");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        URLConnection urlConn= null;
        try {
            urlConn = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonParser json = new JsonParser();
        assert urlConn != null;
        urlConn.setRequestProperty("Authorization",clientId);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String msg = null;
        StringBuffer b = new StringBuffer();

        while(true)
        {
            try {
                if ((msg = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            b.append(msg);
        }


/*
        String result = b.toString();
        JsonParser Parser = new JsonParser();
        JsonObject jsonObj = (JsonObject) Parser.parse(result);
        System.out.println(jsonObj);
       JsonArray memberArray = (JsonArray) jsonObj.get("items");

        for (int i = 0; i < memberArray.size(); i++) {
            JsonObject object = (JsonObject) memberArray.get(i);
            System.out.println("제목 : " + object.get("title"));
            System.out.println("링크 : " + object.get("link"));
            System.out.println("이미지 : " + object.get("image"));
            System.out.println("저자 : " + object.get("author"));
            System.out.println("가격: " + object.get("price"));
            System.out.println("출판사 : " + object.get("publisher"));
            System.out.println("ISBN : " + object.get("isbn"));
            System.out.println("------------------------");
        }
          */

    }


}