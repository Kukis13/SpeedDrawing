package lukaszja.jakubko.speeddrawing.winapi;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.win32.W32APIOptions;

public interface User32Ext extends User32 {
	User32Ext USER32EXT = (User32Ext) Native.loadLibrary("user32",
			User32Ext.class, W32APIOptions.DEFAULT_OPTIONS);

	HWND FindWindowEx(HWND lpParent, HWND lpChild, String lpClassName, String lpWindowName);

	HWND GetTopWindow(HWND hwnd);

	HWND GetParent(HWND hwnd);

	HWND GetDesktopWindow();

	int SendMessage(HWND hWnd, int dwFlags, byte bVk, int dwExtraInfo);

	int SendMessage(HWND hWnd, int Msg, int wParam, int lParam);

	void keybd_event(byte bVk, byte bScan, int dwFlags, int dwExtraInfo);

	void SwitchToThisWindow(HWND hWnd, boolean fAltTab);

	boolean EnumChildWindows(HWND hWnd, WNDENUMPROC lpEnumFunc, Pointer data);

}
