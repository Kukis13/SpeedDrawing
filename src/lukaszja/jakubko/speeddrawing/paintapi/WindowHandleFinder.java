package lukaszja.jakubko.speeddrawing.paintapi;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import lukaszja.jakubko.speeddrawing.winapi.User32Ext;

import java.util.HashMap;
import java.util.Map;

public class WindowHandleFinder{

    private static final User32Ext user32 = User32Ext.USER32EXT;

    private final static String MS_PAINT_CLASS = "MSPaintApp";
    private final static String MS_PAINT_VIEW = "MSPaintView";

    private HWND mainHandle;
    private HWND canvasHandle;

    public  WindowHandleFinder(){
        mainHandle = user32.FindWindow(MS_PAINT_CLASS, null);
        HWND handle = user32.FindWindowEx(mainHandle, null, MS_PAINT_VIEW, null);
        findCanvasClassName(handle);
    }

    private void findCanvasClassName(HWND parentHandle) {
        WinUser.WNDENUMPROC proc = (hwnd, pointer) -> {
            char[] className = new char[50];
            user32.GetClassName(hwnd, className, 50);
            if(String.valueOf(className).startsWith("Afx:000")){
            	canvasHandle = hwnd;
            	return false;
            }
            return true;
        };

        user32.EnumChildWindows(parentHandle, proc, Pointer.NULL);
    }

    public HWND getMainHandle() {
        return mainHandle;
    }

    public HWND getCanvasHandle() {
        return canvasHandle;
    }
}
