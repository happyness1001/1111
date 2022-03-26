package ln.service;

public interface JsonService {
    public String sendGet(String url, String param);//get方式访问URL

    public String parseGeoCodeJson(String json);

    public double parseDirectionJson(String json);
}
