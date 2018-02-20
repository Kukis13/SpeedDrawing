package lukaszja.jakubko.speeddrawing;

public class MainClass {

	public static void main(String[] args) {
		PaintAPI api = new PaintAPIImpl("file.png", "Afx:00007FF6F1BF0000:8");
		HouseDrawer houseDrawer = new HouseDrawer(api);
		houseDrawer.draw();
	}

}
