/**
 * programmers level1 가운데 글자 가져오기 CenterCharacter
 * @author pkch93
 */
class CenterCharacter {
    /**
     * target 문자열 s의 가운데 글자를 return하는 메서드
     * s의 길이로 짝수인지 홀수인지 판단하여
     * 삼항연산자로 전자는 가운데 2글자, 후자는 가운데 한글자를 return 
     *
     * @param target 문자열
     * @return 가운데 글자. 단, 홀수라면 가운데 1글자, 짝수는 가운데 2글자
     */
    public String solution(String s) {
        int n = s.length();
        return n % 2 == 0 ? 
            s.substring(n / 2 - 1, n / 2 + 1) :
            s.substring(n / 2, n / 2 + 1);
  }
}