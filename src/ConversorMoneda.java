import java.util.Scanner;

public class ConversorMoneda {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**************************************");
            System.out.println("Bienvenido/a al conversor de Moneda\n");

            String menu = """
                    1) Dólar => Peso Argentino
                    2) Peso Argentino => Dólar
                    3) Dólar => Real Brasileño
                    4) Real Brasileño => Dólar
                    5) Dólar => Peso Colombiano
                    6) Peso Colombiano => Dólar
                    7) Salir
                    """;   
            System.out.println(menu);
            System.out.println("Elige una opción válida: ");
            int opcion = scanner.nextInt();

            String fromCurrency = ""; // Moneda origen
            String toCurrency = "";   // Moneda destino

            switch (opcion) {
                case 1 -> { fromCurrency = "USD"; toCurrency = "ARS"; }
                case 2 -> { fromCurrency = "ARS"; toCurrency = "USD"; }
                case 3 -> { fromCurrency = "USD"; toCurrency = "BRL"; }
                case 4 -> { fromCurrency = "BRL"; toCurrency = "USD"; }
                case 5 -> { fromCurrency = "USD"; toCurrency = "COP"; }
                case 6 -> { fromCurrency = "COP"; toCurrency = "USD"; }
                case 7 -> {
                    System.out.println("Gracias por utilizar el sistema.");
                    return; // Salir del programa
                }
                default -> {
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    continue; // Reinicia el bucle si la opción no es válida
                }
            }

            System.out.println("Ingrese el valor que deseas convertir: ");
            double monto = scanner.nextDouble();

            // Llama a la función de BuscadorDeTasas para obtener la tasa de cambio
            double tasaCambio = BuscadorDeTasas.obtenerTasaCambio(fromCurrency, toCurrency);
            if (tasaCambio == -1) {
                System.out.println("Error al obtener la tasa de cambio.");
                continue; // Si hay error, reinicia el bucle
            }

            // Calcula el monto convertido
            double montoConvertido = monto * tasaCambio;
            System.out.printf("El valor %.2f %s corresponde al valor final de =>>> %.2f %s\n", monto, fromCurrency, montoConvertido, toCurrency);

            System.out.println();  // Espacio en blanco para separar las repeticiones
        }
    }
}
