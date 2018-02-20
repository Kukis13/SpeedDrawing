package lukaszja.jakubko.speeddrawing;

import com.sun.jna.platform.win32.WinDef.HWND;

import lukaszja.jakubko.speeddrawing.winapi.User32Ext;

public class PaintAPIImpl implements PaintAPI{
	
	private static final User32Ext u = User32Ext.USER32EXT;
	
	private HWND mainHandle;
	private HWND canvasHandle;

	public PaintAPIImpl(String filename, String stupidClass){
		String windowName = filename + " - Paint";
		findAndSaveHandles(windowName, stupidClass);
	}

	public PaintAPIImpl(String stupidClass){
		this("Untitled", stupidClass);
	}

	@Override
	public void clickOnCanvas(int x, int y) {
        Integer lparam = ((y << 16) | (x & 0xFFFF));

        u.SendMessage(canvasHandle, 0x201, 0, lparam);
        u.SendMessage(canvasHandle, 0x202, 0, lparam);
       
        try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void findAndSaveHandles(String windowName, String stupidClass) {
		mainHandle = u.FindWindow(null, windowName);
        HWND handle = u.FindWindowEx(mainHandle, null, "MSPaintView", null);
        canvasHandle = u.FindWindowEx(handle, null, stupidClass, null);
	}

}
