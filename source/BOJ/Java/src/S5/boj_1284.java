package S5;

public class boj_1284 {
    public static void main(String[] args) {
        final int MAX = 10000;
        boolean arr[] = new boolean[MAX+1];

        for (int i = 1; i <= MAX; i++){
            int j = i;
            if (!arr[j]){
                while (true){
                    int temp = j;
                    for (String s : Integer.toString(j).split(""))
                        temp += Integer.parseInt(s);
                    if (temp < MAX){
                        arr[temp] = true;
                        j = temp;
                    }
                    else break;
                }
            }
        }
        for (int j = 1; j < MAX; j++){
            if (!arr[j]) System.out.println(j);
        }
    }
}
