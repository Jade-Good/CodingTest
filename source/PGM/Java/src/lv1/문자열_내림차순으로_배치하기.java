package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 문자열_내림차순으로_배치하기 {
    public String solution(String s) {
        ArrayList<String> ss = new ArrayList<String>(Arrays.asList(s.split("")));
        Collections.sort(ss, Collections.reverseOrder());
        return String.join("", ss);
    }
}
