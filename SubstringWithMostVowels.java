class SubstringWithMostVowels {
  
  public static void main(String[] args){
    String a = "caberqiitefg";
    int res = maxVowels(a,5);
    System.out.println(res);
  }

  public static boolean isVowel(char x) {
    return (x == 'a' || x =='e' || x == 'i' || x == 'o' || x == 'u');
  }

  public static int maxVowels(String s, int k) {
    int maxSum = 0;
    int windowSum = 0;
    int windowStart = 0;

    for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
      if(isVowel(s.charAt(windowEnd))){
        windowSum += 1;
      }
      if(windowEnd >= k - 1) {
        maxSum = Math.max(windowSum, maxSum);
        if(isVowel(s.charAt(windowStart))){
             windowSum -= 1;
        }
        windowStart++;
      }
    }
    return maxSum;
  }
}