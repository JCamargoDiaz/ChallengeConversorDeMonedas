# Conversor de Moneda

Este proyecto es un **conversor de moneda** desarrollado en **Java**, el cual utiliza la [Exchange Rate API](https://www.exchangerate-api.com/) para obtener las tasas de cambio en tiempo real entre diferentes monedas.

## Características:
- Conversión entre varias monedas: Dólar (USD), Peso Argentino (ARS), Real Brasileño (BRL), Peso Colombiano (COP).
- Actualización en tiempo real de las tasas de cambio a través de la API.
- Capacidad para realizar múltiples conversiones hasta que el usuario decida salir.

## Requisitos previos
Antes de poder ejecutar este proyecto, asegúrate de tener instalado lo siguiente:
- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Gson Library](https://github.com/google/gson) para procesar las respuestas JSON de la API.
- Acceso a la API de [Exchange Rate API](https://www.exchangerate-api.com/), incluyendo una clave de API.

## Instalación

1. **Clona el repositorio:**

   ```bash
   git clone https://github.com/jcamargodiaz/conversor-moneda.git
   cd conversor-moneda
Descarga y añade la biblioteca gson a tu proyecto:

Si estás utilizando un IDE como IntelliJ o Eclipse, sigue sus respectivas instrucciones para agregar la biblioteca Gson a tu proyecto.

O, si prefieres hacerlo manualmente, puedes descargar la librería Gson desde aquí y añadirla a tu classpath.

Configura tu clave API de Exchange Rate:

Obtén tu clave de API gratuita desde Exchange Rate API. Luego, reemplaza tu clave en el archivo BuscadorDeTasas.java:

String direccion = "https://v6.exchangerate-api.com/v6/tu-clave-api/latest/" + fromCurrency;
Uso
Compila el proyecto:

Si estás utilizando la terminal, navega al directorio raíz del proyecto y ejecuta el siguiente comando:

javac ConversorMoneda.java BuscadorDeTasas.java
Ejecuta el proyecto:

Después de compilarlo, puedes ejecutarlo con el siguiente comando:

java ConversorMoneda
Interfaz del programa:

Al ejecutar el programa, verás el siguiente menú en la consola:

**************************************
Bienvenido/a al conversor de Moneda

1) Dólar => Peso Argentino
2) Peso Argentino => Dólar
3) Dólar => Real Brasileño
4) Real Brasileño => Dólar
5) Dólar => Peso Colombiano
6) Peso Colombiano => Dólar
7) Salir
**************************************
Elige una opción válida:
Después de seleccionar una opción y proporcionar un valor a convertir, el programa mostrará el valor convertido en la moneda de destino.

Estructura del proyecto
├── BuscadorDeTasas.java       # Clase que maneja la llamada a la API de tasas de cambio.
├── ConversorMoneda.java       # Clase principal que maneja la interfaz del usuario y la lógica de conversión.
├── README.md                  # Este archivo README.

