import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.ScriptEngineFactory;

public class DIIWallpaper {

  public static void main(String[] args) {

    //Changes wallpaper to the Ayah talking about the Mercy to the Worlds (SAWS)
    changeWallpaper("/Users/shaheer/Documents/GitHub/Daily-Islamic-Inspiration-Wallpaper/Wallpapers/Ayah-Mercy-To-Worlds.png");

  }

  //Change wallpaper to file specified by path
  public static void changeWallpaper(String path) {

    try {
        ProcessBuilder pb = new ProcessBuilder("osascript", "-e",
            "tell application \"Finder\" to set desktop picture to POSIX file \"" + path + "\"");
        Process p = pb.start();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
  }

}
