/**
 * programmers level1 이상한 문자 만들기 CreateWeirdWord
 * @author pkch93
 */
class CreateWeirdWord {
    /**
     * 문자열 제어가 편하게 split하여 구현
     * 단어가 공백을 기준으로 하므로 cnt 변수를 두어 각 단어의 짝수, 홀수를 확인 
     *
     * @param s
     * @return 공백으로 구분된 각 단어의 짝수번째가 대문자, 홀수번째가 소문자인 문자열
     */
    public String solution(String s) {
        int cnt = 0;
        String[] alphas = s.split("");
        for (int i = 0; i < alphas.length; i++){
            if (alphas[i].equals(" ")){
                cnt = 0;
            } else {
                if (cnt % 2 == 0){
                    alphas[i] = alphas[i].toUpperCase();
                } else {
                    alphas[i] = alphas[i].toLowerCase();
                }
                cnt++;
            }
        }
        return String.join("", alphas);
    }
}