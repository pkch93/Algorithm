import java.util.Arrays;

/**
 * programmers level1 문자열 다루기 기본 StringBasic
 * @author pkch93
 */
class StringBasic {
    /**
     * 주어진 문자열 s의 길이가 4 또는 6이고
     * 모두 숫자로 이뤄져 있는지 확인하는 문제
     * 따라서 먼저 s의 길이가 4나 6이 아니라면 false를 return
     * 그리고 stream을 사용하여 각 String을 charAt을 통해 char로 형변환
     * 이후 allMatch와 Character.isDisit 메서드를 활용하여 모두 숫자인지 판단 
     *
     * @param s : 확인할 문자열 s
     * @return 문자열의 길이가 4 또는 6이고 모두 숫자로 구성되어있는지 여부
     */
    public boolean solution(String s) {
        int n = s.length();
        if (n != 4 && n != 6){
            return false;
        }
        return Arrays.stream(s.split(""))
            .map(str -> str.charAt(0))
            .allMatch(Character::isDigit);
    }
}