package proekt2;

import java.util.Comparator;


public class CountryComparator implements Comparator<University>{
	
	public int compare(University uni1, University uni2) {
		if(uni2.getCountry().compareTo(uni1.getCountry())<0){
			return 1;
		}
		else if(uni2.getCountry().compareTo(uni1.getCountry())>0){
			return -1;
		}
		else{
			return 0;
		}
	
	}
}
