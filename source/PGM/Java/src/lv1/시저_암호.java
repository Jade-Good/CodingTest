package lv1;

public class 시저_암호 {
    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder(s);

        System.out.println(builder);

        for (int i = 0; i < s.length(); i++)  {
            char c = builder.charAt(i);
            if(c == ' '){}
            else if(c < 'a'){
                builder.setCharAt(i,(char)((c+n-'A')%26 + 'A'));
            }
            else
                builder.setCharAt(i,(char)((c+n-'a')%26 + 'a'));
        }
        return builder.toString();
    }
}
