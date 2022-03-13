
package ln.dlut.ln.controller;

import ln.service.AddressDistanceService;
import ln.service.JsonIml;
import ln.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ln.pojo.LngLat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Controller
@RequestMapping("/GenerateRoute")

public class GenerateRouteController {

    @Autowired
    private JsonService jsonService;

//    private JsonIml jsonService = new JsonIml();


    @Autowired
    private AddressDistanceService addressDistanceService;
    public static List<String> receiveLocations = new ArrayList<>();//收货地址集合
    public static List<String> sentLocation = new ArrayList<>();//发货地址，即当前仓库地址
    public static String finalRoute;
    private final String DirectionUrl = "https://restapi.amap.com/v5/direction/driving";
    private final String GeoCodeUrl = "https://restapi.amap.com/v3/geocode/geo";
    private final String user_key = "key=1d9801ec3c792505986ce94fb4d49ef7";
    private String param = "";
//    {
//        sentLocation.add("北京");
//        receiveLocations.add("上海");
//        receiveLocations.add("天津");
//        receiveLocations.add("大连");
//    }


    public int count = 0;     //定义全局变量，用于计算当前已行走方案次数，初始化为0
    public double MinDistance = 999999999;    //定义完成一个行走方案的最短距离，初始化为99999（PS：99999此处表示比实际要大很多的距离）
//    public int[][] distance = {{0,2,5,7},{2,0,8,3},{5,8,0,1},{7,3,1,0}};   //使用二维数组的那个音图的路径相关距离长度
    public double[][] distance ;   //使用二维数组的那个音图的路径相关距离长度
    public static Map<Integer,String[]> Index_Location = new TreeMap<>();//将邻接矩阵的数字行转化为地址行

    public static Map<Integer,String > Map = new TreeMap<>();
    public static Map<String, Double> result = new TreeMap<>();
    public static String route = "";

    public  double[][] getChartMatrix(List<String> sentLocations, List<String> receiveLocations){
        int size = sentLocations.size() + receiveLocations.size();//总共有多少个地点，即无向图的矩阵的行数或列数
        double [][]distances = new double[size][size];//存储生成的无向图矩阵
        List<String> locations = new ArrayList<>();//存放所有的地点的集合
//        AddressDistanceIml addressDistanceIml = new AddressDistanceIml();

        locations.addAll(sentLocations);
        locations.addAll(receiveLocations);

        //将矩阵的边由索引变为地点名词
        for (int i = 0; i < size; i++){
            String[] strings = new String[2];
            strings[0] = locations.get(i);
            Index_Location.put(i,strings);
//            System.out.println(strings[0]);
//            Index_Location.put(i,locations.get(i));
        }
//        System.out.println("location   :::::" + locations);
        /*
        * 将矩阵的地点名词添加相应的经纬度
        * */
        for (int i = 0; i < size; i++) {
//            System.out.println("size============>" + size);
            try {
                param = "address=" + URLEncoder.encode(Index_Location.get(i)[0],"UTF-8") /*"%E5%8C%97%E4%BA%AC"*/ + "&" + "output=JSON" + "&" + user_key;

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String json = jsonService.sendGet(GeoCodeUrl, param);
            Index_Location.get(i)[1] = jsonService.parseGeoCodeJson(json);
//            System.out.println(Index_Location.get(i)[0] + "================>" +Index_Location.get(i)[1]);
        }

        long time1 = new Date().getTime();
        System.out.println("time1:"+ time1);
        //初始化矩阵除对角元外的所有元素
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (i != j){
//                    System.err.println("  i  " + i + "  j :" + j);
                    param = "origin=" + Index_Location.get(i)[1] + "&destination=" + Index_Location.get(j)[1] + "&" + user_key;
//                    System.out.println("二层数组内部得param：" + param);
                    long time3 = new Date().getTime();
                    System.out.println("time3:"+ time3);
                    String directionJson = jsonService.sendGet(DirectionUrl, param);
                    long time4 = new Date().getTime();
                    System.out.println("time4:"+ time4);
                    System.out.println("t4-t3:" + (time4 - time3));
                    System.out.println("DirectionUrl json:" +  directionJson);
//                    System.out.println("判断函数内部是否正常" + jsonService.parseDirectionJson(directionJson));
                    distances[i][j] = jsonService.parseDirectionJson(directionJson);
                }
            }
        }
        long time2 = new Date().getTime();
        System.out.println("time2:"+ time2);
        System.out.println("time2 - time1:" + (time2 - time1)/1000);
        //初始化矩阵的对角元素
        for (int i = 0; i < size; i++){
            distances[i][i] = 0;
        }

        return distances;
    }

    @RequestMapping("/getDistance")
    private String getDistance(Model model,String location_name1, String location_name2) {
        ArrayList<String> distance_name = new ArrayList<>();
        distance_name.add(location_name1);
        distance_name.add(location_name2);
        model.addAttribute("distance_name",distance_name);
        return "getDistance";
    }

    /*
     * start为开始进行排序的位置
     * step为当前正在行走的位置
     * n为需要排序的总位置数
     * Max为n!值
*/
    public void Arrange(int[] A,int start,int step,int n,int Max){
        if(step == n){   // 当正在行走的位置等于城市总个数时
            ++count;           //每完成一次行走方案，count自增1
            if (A[0] == 0)
            printArray(A);     //输出行走路线方案及其总距离
        }
        if(count == Max){
            Set<String> keys = result.keySet();
            String final_key = "";
            double i = 10000000000.0;
            for (String key : keys) {
//                System.out.println(key + result.get(key));

                double final_result = result.get(key);
                if (final_result < i){
                    final_key = key;
                    i = final_result;
                }
            }
            finalRoute = final_key;
//            finalRoute = "已生成最短路径方案：" + final_key + result.get(final_key) + "米";
//            System.out.println("已生成最短路径方案：" + final_key + result.get(final_key));
//            System.out.println("已完成全部行走方案！！！,最短路径距离为:"+MinDistance);
        }
        else{

            for(int i = start;i < n;i++){

/*第i个数分别与它后面的数字交换就能得到新的排列,从而能够得到n!次不同排序方案
                 */

                swapArray(A,start,i);
                Arrange(A,start+1,step+1,n,Max);
                swapArray(A,i,start);
            }

        }
    }
    //交换数组中两个位置上的数值
    public  void swapArray(int[] A,int p,int q){
        int temp = A[p];
        A[p] = A[q];
        A[q] = temp;
    }

    //输出数组A的序列，并输出当前行走序列所花距离，并得到已完成的行走方案中最短距离
    public void printArray(int[] A){


        //输出当前行走方案的序列
        for (int j : A) {
            route += (Index_Location.get(j)[0] + " ");
        }
//        route +=  "  行走路程总和：";
//        System.out.println(route);

        double tempDistance = distance[A[0]][A[A.length - 1]];     //此处是因为，最终要返回出发地城市，所以总距离要加上最后到达的城市到出发点城市的距离
        for(int i = 0;i < (A.length-1);i++)   //输出当前行走方案所花距离
            tempDistance += distance[A[i]][A[i+1]];

        if(MinDistance > tempDistance){//返回当前已完成方案的最短行走距离
            MinDistance = tempDistance;
        }
        result.put(route, tempDistance);
//        System.out.println(route + result.get(route));
//        System.out.println("此时的result：" + result.keySet());
        route = "";
//        System.out.println("  行走路程总和："+tempDistance);
    }

    @RequestMapping("/main")

    public  String main(Model model) {
        distance = getChartMatrix(sentLocation, receiveLocations);
        int n = sentLocation.size() + receiveLocations.size();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i;
        }
        int N = Factorial(n);
//        model.addAttribute("matrix",Arrays.deepToString(distance));
        Arrange(A,0,0,n,N);
//        System.out.println("finalRoute:" + finalRoute);
        model.addAttribute("route",finalRoute);
        sentLocation.clear();
        receiveLocations.clear();
        Index_Location.clear();
        result.clear();
        finalRoute = "";
        count = 0;
        return "route";
    }
    @ResponseBody
@RequestMapping("/getLngLat")
public void getLngLat(LngLat lngLat) {
            receiveLocations.add(lngLat.getAddress_name());
            System.out.println(receiveLocations);
}
    @RequestMapping("/getLngLatLeft")
    public void getLngLatLeft(LngLat lngLat) {
            sentLocation.add(lngLat.getAddress_name());
            System.out.println(sentLocation);
    }
@RequestMapping("/null")
    public String ToVoid(){
        return "redirect:/GenerateRoute/main";
    }

public static int Factorial(int n){
        int result = 0;
        for (int i=n-1; i>0; i--){
            n*=i;
            result = n;
        }
        return result;
}



}