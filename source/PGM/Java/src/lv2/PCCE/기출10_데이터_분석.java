package lv2.PCCE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 기출10_데이터_분석 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        int extNum = getDataCode(ext);
        int sortNum = getDataCode(sort_by);

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            if (data[i][extNum] < val_ext) {
                list.add(data[i]);
            }
        }

        Collections.sort(list, Comparator.comparingInt(o -> o[sortNum]));

        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            for (int j = 0; j < 4; j++) {
                answer[i][j] = temp[j];
            }
        }

        return answer;
    }

    private int getDataCode(String s) {
        char c = s.charAt(0);
        if (c == 'c') {
            return 0;
        } else if (c == 'd') {
            return 1;
        } else if (c == 'm') {
            return 2;
        } else {
            return 3;
        }
    }
}
