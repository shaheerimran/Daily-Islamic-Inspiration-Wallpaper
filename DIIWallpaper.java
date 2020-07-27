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

    //Changes wallpaper to randomly selected wallpaper
    changeWallpaper();

  }

  //Change wallpaper to file specified by path
  public static void changeWallpaper() {

    //For Mac
    if(isMac()){

      String wallpapers_path = System.getProperty("user.dir") + "/Wallpapers"; //Wallpapers folder path
      File directoryPath = new File(wallpapers_path); //Gets File object of current working directory
      String contents[] = directoryPath.list(); //Gets String array of Filenames in Wallpapers

      int wallpaper_selection = (int) (Math.random() * contents.length);
      String wallpaper_path = wallpapers_path + "/" + contents[wallpaper_selection];

      try {

          ProcessBuilder pb = new ProcessBuilder("osascript", "-e",
              "tell application \"Finder\" to set desktop picture to POSIX file \"" + wallpaper_path + "\"");
          Process p = pb.start();

      } catch (Exception ex) {

          ex.printStackTrace();

      }

    } else if(isWindows()){ //For Windows

        String wallpapers_path = System.getProperty("user.dir") + "\\Wallpapers"; //Wallpapers folder path
        File directoryPath = new File(wallpapers_path); //Gets File object of current working directory
        String contents[] = directoryPath.list(); //Gets String array of Filenames in Wallpapers

        int wallpaper_selection = (int) (Math.random() * contents.length);
        String wallpaper = wallpapers_path + "\\" + contents[wallpaper_selection];

        try{
          

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
