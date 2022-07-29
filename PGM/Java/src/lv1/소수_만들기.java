package lv1;

public class 소수_만들기 {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;

        for (int i = 0; i < len-1; i++){    // 오름차순 정렬(선택정렬)
            for (int j = i+1; j < len; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int i = 0; i < len-2; i++){        // 숫자 1
            for (int j = i+1; j < len-1; j++){    // 숫자 2
                for (int k = j+1; k < len; k++){  // 숫자 3
                    int sum = nums[i] + nums[j] + nums[k]; // 숫자합
                    int n = 1;
                    while(n < sum){             // 소수 판단
                        n++;
                        if(sum % n == 0) break; //소수 X
                    }
                    if(n == sum) answer++;      //소수 O
                }
            }
        }

        return answer;
    }
}
