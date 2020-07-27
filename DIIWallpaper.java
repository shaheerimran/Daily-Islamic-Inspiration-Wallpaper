import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.ScriptEngineFactory;

public class DIIWallpaper {

  //The OS of the computer we're using
  private static String OS = System.getProperty("os.name").toLowerCase();

  public static void main(String[] args) {

    //Changes wallpaper to the Ayah talking about the Mercy to the Worlds (SAWS)
    changeWallpaper("/Users/shaheer/Documents/GitHub/Daily-Islamic-Inspiration-Wallpaper/Wallpapers/Ayah-Mercy-To-Worlds.png");

  }

  //Change wallpaper to file specified by path
  public static void changeWallpaper(String path) {
    if(isMac()){
      try {
          ProcessBuilder pb = new ProcessBuilder("osascript", "-e",
              "tell application \"Finder\" to set desktop picture to POSIX file \"" + path + "\"");
          Process p = pb.start();
      } catch (Exception ex) {
          ex.printStackTrace();
      }
    }
    else if(isWindows()){
      try{
        //ADD CODE FOR CHANGING WALLPAPER ON WINDOWS THROUGHT COMMAND PROMPT
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    else{
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
