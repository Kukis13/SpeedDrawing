package lukaszja.jakubko.speeddrawing;

import lukaszja.jakubko.speeddrawing.paintapi.PaintAPI;
import lukaszja.jakubko.speeddrawing.paintapi.PaintAPIImpl;

public class MainClass {

	public static void main(String[] args) {
		PaintAPI api = new PaintAPIImpl();
		HouseDrawer houseDrawer = new HouseDrawer(api);
		houseDrawer.draw();
	}

}
