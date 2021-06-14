package proekt2;

import java.util.Comparator;


public class RankNumComparator implements Comparator<University> {
	
	public int compare(University uni1, University uni2){
	if(uni2.getRankingNum()>uni1.getRankingNum()){
		return -1;
	}else if(uni1.getRankingNum()>uni2.getRankingNum()){
		return 1;
	}else{
	return 0;
	}
	}
}