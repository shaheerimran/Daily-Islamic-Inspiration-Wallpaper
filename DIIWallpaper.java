import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.ScriptEngineFactory;
import java.lang.Math;

public class DIIWallpaper {

  private static String OS = System.getProperty("os.name").toLowerCase(); //The OS of the computer we're using

  public static void main(String[] args) {
    //Changes wallpaper to the Ayah talking about the Mercy to the Worlds (SAWS)
    changeWallpaper("C:\\Users\\yusufpc\\Pictures\\Hadith-Intentions.png");

  }
  public static interface User32 extends Library {
        User32 INSTANCE = (User32) Native.loadLibrary("user32",User32.class,W32APIOptions.DEFAULT_OPTIONS);
        boolean SystemParametersInfo (int one, int two, String s ,int three);
  }
  //Change wallpaper to file specified by path
  public static void changeWallpaper(String path) {

    //For Mac
    if(isMac()){

      try {

          String wallpapers_path = System.getProperty("user.dir") + "/";
          File directoryPath = new File(wallpapers_path);
          String contents[] = directoryPath.list();

          int wallpaper = (int) contents.length * Math.random();
          String wallpaper_path = wallpapers_path + "/" + contents[wallpaper];

          ProcessBuilder pb = new ProcessBuilder("osascript", "-e",
              "tell application \"Finder\" to set desktop picture to POSIX file \"" + wallpaper_path + "\"");
          Process p = pb.start();

      } catch (Exception ex) {

          ex.printStackTrace();

      }

    } else if(isWindows()){ //For Windows

      String wallpapers_path = System.getProperty("user.dir") + "\\";
      File directoryPath = new File(wallpapers_path);
      String contents[] = directoryPath.list();

      int wallpaper = (int) contents.length * Math.random();
      String wallpaper_path = wallpapers_path + "\\" + contents[wallpaper];

        try{
          User32.INSTANCE.SystemParametersInfo(0x0014, 0, wallpaper , 1);
        } catch (Exception ex) {

          ex.printStackTrace();

        }

    } else{ //Error message if any other operating system

      System.out.println("Daily Islamic Inspiration Wallpaper currently does not support your OS");

    }

  }

  //Checks if computer uses Windows
  public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

  //Checks if computer uses Mac
	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}


}
