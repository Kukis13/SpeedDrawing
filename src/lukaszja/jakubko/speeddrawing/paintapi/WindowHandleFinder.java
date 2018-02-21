package lukaszja.jakubko.speeddrawing.paintapi;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HDC;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import lukaszja.jakubko.speeddrawing.winapi.GDI32Ext;
import lukaszja.jakubko.speeddrawing.winapi.User32Ext;

import java.util.*;

public class WindowHandleFinder{

    private static final User32Ext user32 = User32Ext.USER32EXT;
    private static final GDI32Ext gdi32 = GDI32Ext.GDI32EXT;

    private final static String MS_PAINT_CLASS = "MSPaintApp";
    private final static String MS_PAINT_VIEW = "MSPaintView";

    private HWND mainHandle;
    private HWND canvasHandle;
    private HWND toolsHandle;

    public WindowHandleFinder(){
        mainHandle = user32.FindWindow(MS_PAINT_CLASS, null);
        HWND handle = user32.FindWindowEx(mainHandle, null, MS_PAINT_VIEW, null);
        findCanvasClassName(handle);
        List<String> childNames = Arrays.asList("UIRibbonCommandBar", "UIRibbonWorkPane", "NUIPane", "NetUIHWND");
        handle = user32.FindWindowEx(mainHandle, null, "UIRibbonCommandBarDock", "UIRibbonDockTop");
        for(String childName : childNames){
            handle = user32.FindWindowEx(handle, null, childName, null);
        }
        toolsHandle = handle;

        HDC hdc = user32.GetDC(toolsHandle);


    }

    private void findCanvasClassName(HWND parentHandle) {
        Map<HWND, String> handlesAndClasses = new HashMap<>();
        WinUser.WNDENUMPROC proc = (hwnd, pointer) -> {
            char[] className = new char[40];
            user32.GetClassName(hwnd, className, 40);
            handlesAndClasses.put(hwnd, String.valueOf(className));
            return true;
        };

        user32.EnumChildWindows(parentHandle, proc, Pointer.NULL);
        canvasHandle = handlesAndClasses.entrySet().stream().max(
                (str1, str2) -> str1.getValue().length() < str2.getValue().length() ? 1 : -1).get().getKey();
    }

    public HWND getMainHandle() {
        return mainHandle;
    }

    public HWND getCanvasHandle() {
        return canvasHandle;
    }
}
