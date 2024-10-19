import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.URI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class BuscadorDeTasas {
    private static final String API_KEY = "dd7dc9102da49af5270eb998"; // clave de API
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public static double obtenerTasaCambio(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        // URL de la API para obtener la tasa de cambio
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + fromCurrency + "/" + toCurrency;

        // solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();

        // Envia la solicitud y obtiene respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Compruena si la respuesta es exitosa
        if (response.statusCode() != 200) {
            System.out.println("Error: No se pudo obtener la tasa de cambio.");
            return -1;
        }

        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

        // Obtiene tasa de conversión
        if (jsonResponse.has("conversion_rate")) {
            return jsonResponse.get("conversion_rate").getAsDouble();
        } else {
            System.out.println("Error: No se encontró la tasa de cambio en la respuesta.");
            return -1;
        }
    }
}
