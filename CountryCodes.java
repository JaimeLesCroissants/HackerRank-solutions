import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import javax.script.*;
import org.json.*;

public class CountryCodes{

 public static void main(String[] args){
  int i=1;
  String cd="ZW";
  String cName=findCountryName(i,cd);
  while(cName.equals("X")){
   cName=findCountryName(i++,cd);
  }
  System.out.println(cName);
 }

 public static String findCountryName(int j,String code){
  String inputLine;
  String res;
  try{
   URL url =new URL("https://jsonmock.hackerrank.com/api/countries?page="+j);
        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
        conn.setRequestProperty("accept","application/json");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      
        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
          content.append(inputLine);
        }

        res=content.toString();
        in.close();
        conn.disconnect();

   JSONObject obj = new JSONObject(res);
   JSONArray arr = obj.getJSONArray("data");
   
   for(int i=0;i<arr.length();i++){
    String alphaC=arr.getJSONObject(i).getString("alpha2Code");
    if(alphaC.equals(code)){
     return arr.getJSONObject(i).getString("name");
    }
   }
  }catch(Exception e){
   e.printStackTrace();
  }
  return "X";
 }
}