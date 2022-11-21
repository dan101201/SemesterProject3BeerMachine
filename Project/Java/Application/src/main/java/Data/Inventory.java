package Data;

public class Inventory {
	private double barley;
	private double malt;
	private double hops;
	private double wheat;
	private double yeast;
	
	public Inventory() {
		this.barley = 0;
		this.malt = 0;
		this.hops = 0;
		this.wheat = 0;
		this.yeast = 0;
	}
	
	public Inventory(double barley, double malt, double hops, double wheat, double yeast) {
		this.barley = barley;
		this.malt = malt;
		this.hops = hops;
		this.wheat = wheat;
		this.yeast = yeast;
	}
	
	public void setBarley(double barley) {
		this.barley = barley;
	}
	
	public double getBarley() {
		return this.barley;
	}
	
	public void setMalt(double malt) {
		this.malt = malt;
	}
	
	public double getMalt() {
		return this.malt;
	}
	
	public void setHops(double hops) {
		this.hops = hops;
	}
	
	public double getHops() {
		return this.hops;
	}
	
	public void setWheat(double wheat) {
		this.wheat = wheat;
	}
	
	public double getWheat() {
		return this.wheat;
	}
	
	public void setYeast(double yeast) {
		this.yeast = yeast;
	}
	
	public double getYeast() {
		return this.yeast;
	}
}
