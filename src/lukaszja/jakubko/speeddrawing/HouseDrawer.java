package lukaszja.jakubko.speeddrawing;

public class HouseDrawer {

	private PaintAPI api;

	public HouseDrawer(PaintAPI api) {
		this.api = api;
	}
	
	public void draw(){
		//walls
		for(int y=200; y<300; y++){
			api.clickOnCanvas(300, y);
			api.clickOnCanvas(400, y);
		}
		
		//floor and ceiling
		for(int x=300; x<400; x++){
			api.clickOnCanvas(x, 200);
			api.clickOnCanvas(x, 300);
		}
		
		//roof
		for(int x=275; x<350; x++){
			api.clickOnCanvas(x, 500 - x);
		}
		for(int x=350; x<425; x++){
			api.clickOnCanvas(x, -200 + x);
		}
	}

}
