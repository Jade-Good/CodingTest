package lv2._2018_KAKAO_BLIND_RECRUITMENT;

import java.util.Arrays;

public class _3차_파일명정렬 {
    public String[] solution(String[] files) {

        FileName[] fns = make_FileName(files);

        Arrays.sort(fns);

        String[] answer = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            answer[i] = fns[i].origin;
        }

        return answer;
    }

    private FileName[] make_FileName(String[] files) {

        FileName[] result = new FileName[files.length];

        for (int i = 0; i < files.length; i++) {

            int start = 0;
            int end = 0;
            char[] chars = files[i].toCharArray();

            // 숫자 시작 찾기
            for (int j = 0; j < chars.length; j++) {
                if (Character.isDigit(chars[j])) {
                    start = j;
                    break;
                }
            }

            String head = files[i].substring(0, start).toUpperCase();

            // 숫자 끝 찾기
            for (end = start + 1; end < chars.length; end++) {
                if (!Character.isDigit(chars[end])) {
                    break;
                }
            }

            int num = Integer.parseInt(files[i].substring(start, end));

            result[i] = new FileName(files[i], head, num, i);
        }

        return result;
    }

    private class FileName implements Comparable<FileName> {

        String origin;
        String head;
        int num;
        int idx;

        FileName(String origin, String head, int num, int idx) {
            this.origin = origin;
            this.head = head;
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(FileName o) {
            if (this.head.compareTo(o.head) != 0) {
                return this.head.compareTo(o.head);
            } else if (this.num != o.num) {
                return this.num - o.num;
            } else {
                return this.idx - o.idx;
            }
        }
    }
}
