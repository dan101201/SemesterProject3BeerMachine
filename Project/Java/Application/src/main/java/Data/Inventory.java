package Data;

public class Inventory {
	private float barley;
	private float malt;
	private float hops;
	private float wheat;
	private float yeast;
	
	public Inventory() {
		this.barley = 0;
		this.malt = 0;
		this.hops = 0;
		this.wheat = 0;
		this.yeast = 0;
	}
	
	public Inventory(float barley, float malt, float hops, float wheat, float yeast) {
		this.barley = barley;
		this.malt = malt;
		this.hops = hops;
		this.wheat = wheat;
		this.yeast = yeast;
	}
	
	public void setBarley(float barley) {
		this.barley = barley;
	}
	
	public float getBarley() {
		return this.barley;
	}
	
	public void setMalt(float malt) {
		this.malt = malt;
	}
	
	public float getMalt() {
		return this.malt;
	}
	
	public void setHops(float hops) {
		this.hops = hops;
	}
	
	public float getHops() {
		return this.hops;
	}
	
	public void setWheat(float wheat) {
		this.wheat = wheat;
	}
	
	public float getWheat() {
		return this.wheat;
	}
	
	public void setYeast(float yeast) {
		this.yeast = yeast;
	}
	
	public float getYeast() {
		return this.yeast;
	}
}
