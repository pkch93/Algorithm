/**
 * programmers level1 서울에서 김서방 찾기 FindKimInSeoul
 * @author pkch93
 */
class FindKimInSeoul {
    /**
     * 간단히 배열을 순회하여 "Kim"을 찾은후 해당 index를 포함하여
     * 김서방은 <int:Kim의 index>에 있다를 return
     *
     * @param seoul : Kim이 반드시 포함된 String 배열
     * @return Kim의 위치를 찾아 "김서방은 <int:Kim의 index>에 있다"를 return 
     */
    public String solution(String[] seoul) {
        int answer = findKimPosition(seoul);
        String format = String.format("김서방은 %d에 있다", answer);
        return format;
    }
    
    private int findKimPosition(String[] seoul){
        for (int i = 0; i < seoul.length; i++){
            if (seoul[i].equals("Kim")){
                return i;   
            }
        }
        return -1;
    }
}