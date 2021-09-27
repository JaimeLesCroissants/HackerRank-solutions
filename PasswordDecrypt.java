import java.util.*;

public class PasswordDecrypt {

    public static void main(String args[]) {
     String ab="43Ah*ck0rr0nk";

     char[] a=ab.toCharArray();

     for(int i=0;i<a.length-1;i++){
         if(Character.isDigit(a[i])){
             for(int j=a.length-1;j>0;j--){
                 if(a[j]=='0'){
                     a[j]=a[i];
                     break;
                 }
             }
         }else if(Character.isUpperCase(a[i])&&Character.isLowerCase(a[i+1])&&a[i+2]=='*'){
             char temp=a[i];
             a[i]=a[i+1];
             a[i+1]=temp;
         }
     }

     System.out.println(String.valueOf(a));

     for(int i=0;i<a.length;i++){
         if(!Character.isDigit(a[i])){
             a=Arrays.copyOfRange(a,i,a.length);
             break;
         }
     }

     System.out.println(String.valueOf(a));

     int stars=0;
     for(int i=0;i<a.length;i++){
         if(a[i]=='*'){
           stars++;
           for(int j=i;j<a.length-1;j++){
               a[j]=a[j+1];
           }
         }
     }

     a=Arrays.copyOfRange(a,0,a.length-stars);

     System.out.println(String.valueOf(a));

    }
}