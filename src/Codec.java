import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Codec {
	List<String> url = new ArrayList<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        url.add(longUrl);
        return "http://tinyurl.com/" + (url.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	String[] ss = shortUrl.split("/");
    	int n = Integer.parseInt(ss[ss.length-1]);
        return url.get(n);
    }
    
    Map<Integer, String> map1=new HashMap<Integer, String>();
    Map<String, Integer> map2=new HashMap<String, Integer>();
    String s="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Encodes a URL to a shortened URL.
    public String encode1(String longUrl) {
        if(!map2.containsKey(longUrl)) {
            map1.put(map1.size()+1,longUrl);
            map2.put(longUrl, map2.size()+1);
        }
        int n=map2.get(longUrl);
        StringBuilder sb=new StringBuilder();
        while(n>0) {
            int r=n%62;
            n/=62;
            sb.insert(0,s.charAt(r));
        }
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode1(String shortUrl) {
        int val=0;
        int n=shortUrl.length();
        for(int i=0;i<n;i++) {
            val=val*62+s.indexOf(shortUrl.charAt(i));
        }
        return map1.get(val);
    }
}
