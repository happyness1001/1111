package ln.service;

import com.google.gson.Gson;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Service
public class JsonIml implements JsonService {
    public static void main(String[] args) {
        JsonIml jsonIml = new JsonIml();
        long time1 = new Date().getTime();
        System.out.println("time1:" + time1);
        System.out.println(jsonIml.sendGet("https://restapi.amap.com/v5/direction/driving", "origin=116.434307,39.90909&destination=116.434446,39.90816&key=1d9801ec3c792505986ce94fb4d49ef7"));
        long time2 = new Date().getTime();
        System.out.println("time2:" + time2);
        System.out.println("time2 - time1:" + (time2 - time1) / 1000 + "秒");
    }

    @Override
    public String sendGet(String url, String param) {

        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
//            System.out.println("urlNameString:==============>" + urlNameString);
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();

            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }

    @Override
    public String parseGeoCodeJson(String json) {
        GeoCodeCallback callbackObject = new Gson().fromJson(json, GeoCodeCallback.class);
        return callbackObject.geocodes.get(0).location;
    }

    @Override
    public double parseDirectionJson(String json) {
//        System.out.println("传入函数的json===============================================================>" + json);
        double distance = 0;
        DirectionCallback callbackObject = new Gson().fromJson(json, DirectionCallback.class);
//        for (int i =0; i< callbackObject.route.paths.size(); i++){
//                distance+= Double.parseDouble(callbackObject.route.paths.get(i).distance);
//        }
        distance = Double.parseDouble(callbackObject.route.paths.get(0).distance);
        return (distance);
    }

    @Data
    private static class GeoCodeCallback {
        public String status;
        public String count;
        public String info;
        public String infocode;
        public List<geocodeInfo> geocodes;

        private static class geocodeInfo {
            public String formatted_address;
            public String country;
            public String province;
            public String citycode;
            public List<String> street;
            public List<String> number;
            public String adcode;
            public String location;
            public String level;

        }
    }

    @Data
    private static class DirectionCallback {
        public String status;
        public String info;
        public String infocode;
        public String count;
        public routeInfo route;

        static class routeInfo {
            public String origin;
            public String destination;
            public List<pathInfo> paths;

            static class pathInfo {
                public String distance;
                public String restriction;
                public List<stepInfo> steps;

                public static class stepInfo {
                    public String instruction;
                    public String orientation;
                    public String road_name;
                    public String step_distance;
                }
            }
        }
    }


}
