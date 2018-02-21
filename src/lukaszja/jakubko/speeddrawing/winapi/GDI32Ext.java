package lukaszja.jakubko.speeddrawing.winapi;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.GDI32;
import com.sun.jna.win32.W32APIOptions;

public interface GDI32Ext extends GDI32{

    GDI32Ext GDI32EXT = (GDI32Ext) Native.loadLibrary("gdi32",
            GDI32Ext.class, W32APIOptions.DEFAULT_OPTIONS);

}
