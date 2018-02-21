package lukaszja.jakubko.speeddrawing.paintapi;

import com.sun.jna.platform.win32.WinDef.HWND;
import lukaszja.jakubko.speeddrawing.winapi.User32Ext;

import static lukaszja.jakubko.speeddrawing.javautil.Sleep.sleep;

public class PaintAPIImpl implements PaintAPI {

	private static final User32Ext user32 = User32Ext.USER32EXT;

	private HWND canvasHandle;

	public PaintAPIImpl() {
		WindowHandleFinder finder = new WindowHandleFinder();
		canvasHandle = finder.getCanvasHandle();
	}

	@Override
	public void clickOnCanvas(int x, int y) {
		Integer lparam = ((y << 16) | (x & 0xFFFF));

		user32.SendMessage(canvasHandle, 0x201, 0, lparam);
		user32.SendMessage(canvasHandle, 0x202, 0, lparam);

		sleep();
	}
}
