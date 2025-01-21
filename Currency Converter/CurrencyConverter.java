import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter {

    // API Key from ExchangeRate-API
    private static final String API_KEY = "YOUR_API_KEY_HERE";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    // Method to fetch exchange rate for a specific currency pair
    public static double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            // URL for the API request
            String urlString = API_URL + fromCurrency;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the response to get exchange rate
            JSONObject myResponse = new JSONObject(response.toString());
            JSONObject conversionRates = myResponse.getJSONObject("conversion_rates");
            return conversionRates.getDouble(toCurrency);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return -1; // Indicates error
        }
    }

    // Method to convert currency
    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double rate = getExchangeRate(fromCurrency, toCurrency);
        if (rate == -1) {
            System.out.println("Error fetching exchange rate.");
            return -1;
        }
        return amount * rate;
    }

    // Main method for user interaction
    public static void main(String[] args) {
        // Scanner to get user input
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter the source currency (e.g., USD): ");
        String fromCurrency = scanner.next().toUpperCase();
        System.out.print("Enter the target currency (e.g., EUR): ");
        String toCurrency = scanner.next().toUpperCase();

        double result = convertCurrency(amount, fromCurrency, toCurrency);
        if (result != -1) {
            System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, result, toCurrency);
        }

        scanner.close();
    }
}
