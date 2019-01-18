package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class twoCharacters {

    static int alternate(String s) {

        char[] chars = s.toCharArray();
        int i=0;
        while (i < chars.length -1)
            if((int)chars[i] == (int) chars[i+1] + 1 || (int)chars[i] == (int) chars[i+1] - 1) {
            i++;
            } else {
                //not only i+1 has to be removed i can also be removed
                 String s1;
                if(((int)chars[i+1] == (int) chars[i+2] + 1 || (int)chars[i+1] == (int) chars[i+2] - 1)
                //&& (i-1 !=0 && !((int)chars[i-1] == (int) chars[i]+1 || (int)chars[i-1] == (int) chars[i]-1))
                ){
                    s1= s.replaceAll(String.valueOf(chars[i+1]), "");
                    System.out.println("removing" + chars[i+1]);
                } else{
                     s1 = s.replaceAll(String.valueOf(chars[i]), "");
                    System.out.println("removing" + chars[i]);
                }
                chars = s1.toCharArray();
                s = s1;
                System.out.println(s);
                i=0;
            }

        return chars.length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}
