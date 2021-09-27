import java.util.*;

public class PairsOfSimilarRectangles {

    public static void main(String args[]) {
      int[][] a={{4,8},{15,30},{3,6},{10,20},{1,3},{2,6},{1,5},{5,25},{6,30},{4,20},{7,35}};

      HashMap<Double,Integer>hm=new HashMap<Double,Integer>();

      int res=0;

      for(int i=0;i<a.length;i++){
          double tm=(double)a[i][0]/a[i][1];
          if(!hm.containsKey(tm)){
              hm.put(tm,1);
          }else{
              int tmp=hm.get(tm);
              hm.put(tm,++tmp);
          }
      }

      for (Map.Entry elem : hm.entrySet()) {
          if((int)elem.getValue()==2)res+=1;
          if((int)elem.getValue()==3)res+=3;
          if((int)elem.getValue()>3){
              int sum=0;
              for(int i=(int)elem.getValue()-1;i>0;i--){
                  sum+=i;
              }
              res+=sum;
          }
      }

      System.out.println(res);

    }
}