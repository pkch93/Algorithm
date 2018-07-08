package Programmers.Algorithm;

public class Delivery {

	public static final int MAXDELIVERY = 500000; 
	
	public int findTarget(int [] d, boolean [] visit) {
		int target = 0, min = MAXDELIVERY;
		for(int i = 1; i < d.length; i++) {
			if(d[i] < min && visit[i] == false) {
				min = d[i];
				target = i; 
			}
		}
		return target;
	}
	
	public int solution(int n, int [][] road, int k) {
		int answer = 0;
		int [] dist = new int[n+1];
		for(int i = 0; i < dist.length; i++) 
			dist[i] = MAXDELIVERY;
		boolean [] visit = new boolean[n+1];
		dist[1] = 0;
		for(int i = 0; i < n - 1; i++) {
			int target = findTarget(dist, visit);
			for(int j = 0; j < road.length; j++) {
				if(road[j][0] == target || road[j][1] == target) {
					int x = road[j][0] == target ? road[j][1] : road[j][0];
					if(visit[x] == false) dist[x] = Math.min(dist[x], dist[target] + road[j][2]);
				}
			}
			visit[target] = true;
		}
		for(int i = 1; i < dist.length; i++) {
			if(dist[i] <= k) answer++;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Delivery test = new Delivery();
		int [][] road = {
			{1,2,1},
			{2,3,3},
			{5,2,2},
			{1,4,2},
			{5,3,1},
			{5,4,2}
		};
		System.out.println(test.solution(5, road, 3));
	}
}
