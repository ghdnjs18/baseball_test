package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class team_test {
    public static void main(String[] args) {
        //팀원들 각자의 사고과정
        
        //  랜덤함수를 이용해서 랜덤 숫자 3자리 설정 - LinkedHashSet을 이용
        //  while을 이용하여 반복 시도
        //  버퍼리더를 split해서 한자리씩 문자열 배열에 넣고 숫자 배열로 변경해준다.
        //  기회는 cnt해서 출력
        //  입력을 받은 배열을 set을 iterator한것과 비교 S와 B의 개수 채크후 출력
        //  일치할 경우 while 종료


        //  랜덤 함수를 이용해서 랜덤 숫자 3자리 설정
        //  While 반복문에서 게임 종료 되기 전까지 사용자 입력 배열과 정답 배열 비교. 스트라이크와 볼 개수 계산
        //  정답일 때 while 종료

        //  1. BufferedReader로 원하는 숫자 문자열로 입력한다.
        //  2. Set<Integer> hashSet과 변수 a1, a2, a3에 입력받은 문자열 int 형으로 저장한다.
        //  3. 1~9까지의 숫자를 LinkedList<Integer> numList에 저장해둬 삭제와 추가가 쉽도록 한다.
        //  4. Random random = new Random();을 이용해 numList.size()만큼 돌려준다.
        //  5. 나온 숫자 순서에 있는 배열 요소를 따로 저장하고 remove한다.
        //  6. 4~5번 과정을 두번 더 반복하고, 3개의 숫자를 검사해 ball과 strike가 몇개인지 판별한다.(함수 사용)
        //  7. 만일 모두 틀렸으면 numList에서 삭제한 상태 그대로를 유지한다.
        //  8. ball과 strike합이 3개면 3ball 또는 3strike를 맟춘다.
        //  9. 1개일때는 제거한 숫자를 다시 numList에 돌려주고 4번부터 반복한다.
        //  10. 2개일때는.. 흠.. 어쩌지....
        //  11. 앗 반대로 생각했구나 ;;

        // 랜덤 숫자 부여
        Random rd = new Random();
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        while (set.size() < 3) { // 중복 삭제 하면서 셋으로 받기
            set.add(rd.nextInt(10));
        }
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        System.out.println(set.toString());

        Scanner sc = new Scanner(System.in);

        int attempt = 1;
        int strike = 0;
        int ball = 0;

        while (strike < 3) {
            strike = 0;
            ball = 0;
            System.out.print(attempt + "번째 시도 : ");

            String putStr = sc.next();
            if (putStr.length() != 3) {
                System.out.println("세자리 숫자를 입력해주세요.");
                attempt++;
                continue;
            }
            int putNum = 0;
            try {
                putNum = Integer.parseInt(putStr);
            } catch (NumberFormatException e) {
                System.out.println("문자를 잘 못 입력하셨습니다.");
                attempt++;
                continue;
            }

            int[] myNum = new int[3];
            myNum[0] = putNum / 100;
            myNum[1] = (putNum % 100) / 10;
            myNum[2] = putNum % 10;

            // 비교 테스트
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                for (int i = 0; i < 3; i++) {
                    if (myNum[i] == iterator.next()) {
                        strike++;
                    } else if (set.contains(myNum[i])){
                        ball++;
                    }
                }
            }

            if (strike == 3) {
                System.out.println("3S");
            } else {
                attempt++;
                if (ball == 3) {
                    System.out.println("3B");
                } else {
                    System.out.println(ball + "B" + strike + "S");
                }
            }
        }
        System.out.println(attempt + "번만에 맞히셨습니다.");
        System.out.println("게임을 종료합니다.");
    }
}
