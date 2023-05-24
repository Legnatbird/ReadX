package utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

/**
 * 
 * Class that fetches data from the dummy api.
 */
public class Fetch {
  /**
   * 
   * constructor of the fetch class
   */
  public Fetch() {
  }

  /**
   * 
   * Method that fetches data from the dummy api.
   * 
   * @return data from the dummy api
   */
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