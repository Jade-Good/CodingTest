package B4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_13496_TheMerchantofVenice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine()); // Number of data sets

        for (int dataSet = 1; dataSet <= k; dataSet++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // Number of ships
            int s = Integer.parseInt(st.nextToken()); // Speed of ships (miles per day)
            int d = Integer.parseInt(st.nextToken()); // Days until due date

            int totalDucats = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int distance = Integer.parseInt(st.nextToken()); // Distance of the ship from Venice
                int value = Integer.parseInt(st.nextToken()); // Value of the ship's load

                // If the ship can reach Venice on or before the due date
                if (distance <= s * d) {
                    totalDucats += value;
                }
            }

            // Append the results for the current data set
            sb.append("Data Set ").append(dataSet).append(":\n");
            sb.append(totalDucats).append("\n\n");
        }

        // Write all results at once
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
