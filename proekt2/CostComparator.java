package proekt2;

import java.util.Comparator;

public class CostComparator implements Comparator<University> {
	
	public int compare(University uni1, University uni2){
	if(uni2.getCost()>uni1.getCost()){
		return -1;
	}else if(uni1.getCost()>uni2.getCost()){
		return 1;
	}else{
	return 0;
	}
	}
}
