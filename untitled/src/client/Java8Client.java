package client;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

/**
 * Created by futaner on 02/12/16.
 */
public class Java8Client {

    public static void main(String[] args) {

        
        int[][] matrix = {{1,2,3},{0,2,1},{9,0,1}};
        int[] row0EleIndex={-1,-1,-1};
        int[] column0EleIndex={-1,-1,-1};
        int index=0;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == 0) {
                    row0EleIndex[index]=i;
                    column0EleIndex[index]=j;
                    index++;
                }
            }
        }
        System.out.println(row0EleIndex);
        System.out.println(column0EleIndex);
        for (int i = 0; i < row0EleIndex.length; i++) {
          //  matrix[row0EleIndex[i]]
        }

        String date ="2016-11-15";
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        DateFormatter formatter= new DateFormatter(dateFormat);
      //  System.out.println(formatter.parse(date));

    }
}
