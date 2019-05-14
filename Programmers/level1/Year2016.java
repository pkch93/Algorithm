/**
 * programmers level1 2016년 문제 Year2016
 * @author pkch93
 */
class Year2016 {
  /**
   * 2016년 1월 1일이 금요일이라고 가정한 후 월(a), 일(b)이 주어질 때
   * 해당 요일을 return하는 메서드
   * 계산의 편의를 위해 monthDays int 배열에 모든 월의 날짜를 담음
   * 마찬가지로 enDay도 각 요일의 영어 이름을 담음
   * 단, 계산의 편의를 위해 7로 나눈 나머지가 1부터 FRI(금요일)이므로
   * [목, 금, 토, 일, 월, 화, 수] 순으로 각 요일의 영어이름을 담음 
   *
   * @param a 월
   * @param b 일
   * @return 해당 월, 일의 요일 이름
   */
  public String solution(int a, int b) {
    int[] monthDays = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] enDay = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
    int days = b;
    for (int i = 0; i < a; i++){
        days += monthDays[i];
    }
    return enDay[days % 7];
  }
}