package lukaszja.jakubko.speeddrawing;

import org.opencv.core.Core;

import lukaszja.jakubko.speeddrawing.fileimageservice.ImageReader;
import lukaszja.jakubko.speeddrawing.paintapi.PaintAPI;
import lukaszja.jakubko.speeddrawing.paintapi.PaintAPIImpl;
import lukaszja.jakubko.speeddrawing.virtualartist.Artist;
import lukaszja.jakubko.speeddrawing.virtualartist.DerpArtist;

public class MainClass {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		Artist derp = new DerpArtist();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		derp.drawImage("testImages\\rf.jpg");
	}

}
