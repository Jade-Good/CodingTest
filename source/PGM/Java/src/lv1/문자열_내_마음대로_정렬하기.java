package lv1;

public class 문자열_내_마음대로_정렬하기 {
    public String[] solution(String[] strings, int n) { //문자열 배열, 인덱스
        int len = strings.length;

        for (int i = 0; i < len-1; i++){
            for (int j = i+1; j < len; j++){
                if (strings[i].charAt(n) > strings[j].charAt(n)){
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
                else if (strings[i].charAt(n) == strings[j].charAt(n)){
                    if (strings[i].compareTo(strings[j]) > 0){
                        String temp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = temp;
                    }
                }
            }
        }
        return strings;
    }
}
