import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class CurrencyConverter{

    static final String API_KEY = "Todo0rFqp3xLRUPcF5hglUzJUE81aG3a";
    static final String BASE_URI = "https://api.apilayer.com/exchangerates_data/";


     public static double convert(String from, String to, double amount) throws Exception {

        HttpRequest convertRequest = HttpRequest.newBuilder()
                .uri(new URI(BASE_URI + "convert?" + String.format("to=%s&from=%s&amount=%f",to,from, amount)))
                .header("apikey", API_KEY)
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response =  httpClient.send(convertRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        ConvertResponse convertResponse = gson.fromJson(response.body(),ConvertResponse.class);

        if(convertResponse.isSuccess())
            return convertResponse.getResult();

        throw new RuntimeException(convertResponse.getErrorMessage());

    }





    public static void main(String[] args) throws Exception{
        new GUI();
    }

}
