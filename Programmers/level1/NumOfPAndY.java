/**
 * programmers level1 문자열 내 p와 y의 개수
 * @author pkch93
 */
class NumOfPAndY {
    /**
     * s의 p와 y의 갯수를 파악해 같으면 true, 다르면 false를 반환하는 메서드
     * 이때, p와 y의 대소문자는 상관없다.
     * s의 길이만큼 loop를 돌아 p와 y의 갯수를 구한 후
     * 갯수 비교 결과를 return
     *
     * @param s : 주어진 문자열
     * @return s 내부에 p와 y의 갯수가 같다면 true, 아니면 false
     */
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0, yCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P') pCount++;
            else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') yCount++;
        }
        return pCount == yCount;
    }
}