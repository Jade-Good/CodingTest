package lv1;

public class 문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        s = s.toUpperCase();
        int p = 0;
        int y = 0;

        for(String c : s.split("")){
            if(c.charAt(0) == 'P') p++;
            else if(c.charAt(0) == 'Y') y++;

        }
        return p == y;
    }
}
