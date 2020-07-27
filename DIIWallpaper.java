import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.ScriptEngineFactory;

public class DIIWallpaper {

  private static String OS = System.getProperty("os.name").toLowerCase(); //The OS of the computer we're using

  public static void main(String[] args) {

    //Changes wallpaper to the Ayah talking about the Mercy to the Worlds (SAWS)
    changeWallpaper("/Users/shaheer/Documents/GitHub/Daily-Islamic-Inspiration-Wallpaper/Wallpapers/Ayah-Mercy-To-Worlds.png");

  }

  //Change wallpaper to file specified by path
  public static void changeWallpaper(String path) {

    //For Mac
    if(isMac()){

      try {

          ProcessBuilder pb = new ProcessBuilder("osascript", "-e",
              "tell application \"Finder\" to set desktop picture to POSIX file \"" + path + "\"");
          Process p = pb.start();

      } catch (Exception ex) {

          ex.printStackTrace();

      }

    } else if(isWindows()){ //For Windows

        try{

          ProcessBuilder pb = new ProcessBuilder("reg", "add", "\"HKEY_CURRENT_USER\\Control Panel\\Desktop\"", "/v", "Wallpaper", "/t", "REG_SZ", "/d ", path, "/f");
          Process p = pb.start;
          ProcessBuilder pbt = new ProcessBuilder("RUNDLL32.EXE", "user32.dll,UpdatePerUserSystemParameters");
          Process pt = pbt.start;

          /*String command1 = "reg add \"HKEY_CURRENT_USER\\Control Panel\\Desktop\" /v Wallpaper /t REG_SZ /d  " + path + " /f";
   	      String command2 = "RUNDLL32.EXE user32.dll,UpdatePerUserSystemParameters";
          Process process1 = Runtime.getRuntime().exec(command1);
          Process process2 = Runtime.getRuntime().exec(command2);*/

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
