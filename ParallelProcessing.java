import java.util.*;

public class ParallelProcessing {

    public static void main(String args[]) {

      int[] x={4,1,3,2,8};

      int numCores=4;

      int limit=1;

      ArrayList<Integer> arr=new ArrayList<Integer>();

      int sum=0;

      if(numCores==1){
          for(int i=0;i<x.length;i++){
              sum+=x[i];
          }
          System.out.println(sum);
      }else{
          for(int i=0;i<x.length;i++){
              if(x[i]%numCores==0){
                  arr.add(x[i]);
              }else{
                  sum+=x[i];
              }
          }

          Collections.sort(arr);

          int k=0;

          for(int j=arr.size()-1;j>=0;j--){
              if(k<limit){
                  sum+=(arr.get(j)/numCores);
              }else{
                  sum+=arr.get(j);
              }
              k++;
          }

          System.out.println(sum);

      }
    }
}