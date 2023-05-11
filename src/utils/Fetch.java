package utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class Fetch {
  public static String[] getData() {
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("https://dummyapi.io/data/v1/user?limit=10"))
      .header("app-id", "6457b6b912461cf7b0b5791a")
      .method("GET", HttpRequest.BodyPublishers.noBody())
      .build();
    HttpResponse<String> response;
  
    {
      try {
        response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
      } catch (IOException | InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    
    return response.body().split("\"");
  }
}