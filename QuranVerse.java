
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.*;
import org.json.simple.JSONObject;

public class QuranVerse
{
    public static void main(String[] args) throws IOException, InterruptedException
    {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create("http://api.alquran.cloud/v1/ayah/2:1"))
                .GET() // GET is default
                .build();

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create("http://api.alquran.cloud/v1/ayah/2:1/en.sahih"))
                .GET() // GET is default
                .build();

        HttpResponse<String> response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> response2 = client.send(request2, HttpResponse.BodyHandlers.ofString());

        String json1 = (response1.body());
        String json2 = (response2.body());

        JSONObject object1a = new JSONObject(json1);
        JSONObject object2a = new JSONObject(json2);

        //int status = object2a.getString("data");
        String translation = object2a.getJSONObject("data").getString("text");
        String verse = object1a.getJSONObject("data").getString("text");

        //JSONObject object2b = new JSONObject(data);
        //String verse = object2b.getString("text");
        //for (int i = 0; i < array2.length(); i++) {
          //  JSONObject object = array2.getJSONObject(i);
          //  int verse = object.getInt("code");
        System.out.println(verse);
        System.out.println(translation);

        //}

        //System.out.println(response1.body());
        //System.out.println(response2.body());

    }
}
