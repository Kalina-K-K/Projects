package proekt2;

public class University  {
	 
	private int rankingNum;
	private int cost;
	private String name;
	private String country;
	private String opinion;
	
	public University(){
		
	}
    public University(int rankinNum, int cost, String name,String country, String opinion){
      	this.setRankingNum(rankingNum);
		this.setCost(cost);
		this.setName(name);
		this.setCountry(country);
		this.setOpinion(opinion);
	}

	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getRankingNum() {
		return rankingNum;
	}
	public void setRankingNum(int rankingNum) {
		this.rankingNum = rankingNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String toString() {
		return "Name: "+name+" Ranking Number: "+rankingNum+" Country "+country+" Cost "+cost;
				
	}

}
