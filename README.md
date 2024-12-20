# Proyecto Conversor de Monedas

## Descripción

El proyecto **Conversor de Monedas** permite a los usuarios convertir entre diferentes monedas utilizando la tasa de cambio más reciente proporcionada por la API **Exchangerate API**. El sistema permite consultar la tasa de cambio de diferentes monedas, realizar conversiones y mostrar los resultados de forma clara y organizada.

Este proyecto hace parte de la formación en **Back-end** del programa **Microsoft Oracle Next Education (ONE)** en colaboración con **Alura Latam**. Esta formación ha sido muy enriquecedora, ya que me ha permitido comprender nuevos conceptos de desarrollo de software y aplicarlos de forma práctica en este proyecto.

El proyecto está diseñado utilizando **Java** y hace uso de varias herramientas y bibliotecas como **Gson** para la conversión de objetos a JSON y viceversa, además de **Java HttpClient** para la conexión con la API externa.

### Características Principales:
- Consulta en tiempo real de tasas de cambio entre monedas.
- Conversión de un valor en una moneda base a una moneda objetivo.
- Visualización de la tasa de cambio actual y detalles sobre la moneda.
- Manejo eficiente de datos utilizando el patrón de **Programación Orientada a Objetos**.

## Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación utilizado para el desarrollo del proyecto.
- **Gson**: Biblioteca de Google para la conversión de objetos a JSON y viceversa.
- **Http**: Herramienta de Java para realizar solicitudes HTTP y consumir APIs externas.
- **Exchangerate API**: API externa para obtener tasas de cambio entre monedas.
## Conocimientos Adquiridos

Este proyecto ha sido una excelente oportunidad para poner en práctica una variedad de conceptos y técnicas de programación que he aprendido a lo largo de mi formación. Algunos de los conocimientos más relevantes que he aplicado son:

- **Conexión a una API Externa**: El uso de **HttpClient** de Java me ha permitido realizar peticiones HTTP para obtener datos de una API externa, en este caso, Exchangerate API. Este proceso implica enviar solicitudes GET y manejar las respuestas JSON para obtener la tasa de cambio actual entre las monedas solicitadas.

- **Manejo de Errores**: Durante el desarrollo, he aprendido a manejar posibles errores que podrían surgir al consumir la API, como errores de red o datos inesperados. Utilicé excepciones (`IOException`, `InterruptedException`) para controlar estos errores de manera eficiente y proporcionar retroalimentación adecuada al usuario.

- **Programación Orientada a Objetos (POO)**: El diseño del proyecto sigue los principios de la programación orientada a objetos, creando clases como `ConversorMoneda`, `ApiExchangerate`, y `ConversorJson`, que encapsulan comportamientos específicos de la conversión de monedas, la conexión con la API y la conversión de datos en JSON, respectivamente. La POO me permitió estructurar el código de manera modular, facilitando su comprensión y mantenimiento.

- **Uso de Records**: En este proyecto, utilicé el tipo de dato **record** de Java, una característica introducida en Java 14, para representar de manera sencilla y eficiente los datos inmutables. El `ConversionMonedaExchangerate` es un ejemplo de cómo los records pueden usarse para almacenar de manera concisa los valores de la tasa de conversión y la fecha de actualización.

- **Manejo de JSON**: Aprendí a trabajar con la biblioteca **Gson** para convertir objetos Java a JSON y viceversa. Esto es crucial para la interacción con APIs que devuelven datos en formato JSON, como Exchangerate API. He implementado la conversión de objetos como `ConversorMoneda` y `ListaMonedasConsultadas` a JSON y también la deserialización de las respuestas JSON en objetos de tipo `ConversionMonedaExchangerate`.

- **Fecha y Hora**: Aprendí a trabajar con la API de **java.time** para capturar y formatear fechas y horas, lo que es fundamental para registrar el momento de la consulta y mostrar la fecha de actualización de las tasas de cambio.

## Instalación

### Requisitos Previos

- Tener **Java 17** o superior instalado en tu máquina.
- Una conexión a Internet para consumir la API de Exchangerate.

### Instrucciones

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/conversor-de-monedas.git
   ```

2. Navega a la carpeta del proyecto:
   ```bash
   cd conversor-de-monedas
   ```

3. Compila y ejecuta el proyecto utilizando tu IDE favorito o desde la línea de comandos:
   ```bash
   javac -cp . ConversorMonedas.java
   java ConversorMonedas
   ```

4. También puedes ejecutar las pruebas unitarias con JUnit para asegurarte de que todo funcione correctamente:
   ```bash
   java -cp .:junit.jar org.junit.runner.JUnitCore TestConversorMonedas
   ```

## Uso

### Funcionalidad Principal

El proyecto permite ingresar el nombre de la moneda base y la moneda objetivo. Al realizar la conversión, se obtiene la tasa de cambio y el valor convertido entre ambas monedas. A continuación, se describen las funciones principales:

1. **Mostrar tasa de cambio**: Muestra la tasa de cambio actual entre la moneda base y la moneda objetivo.
2. **Realizar conversión**: Convierte un valor dado de la moneda base a la moneda objetivo utilizando la tasa de cambio actual.
3. **Detalles de la moneda**: Muestra información detallada sobre la moneda base, la moneda objetivo, la tasa de cambio, la fecha de actualización, y el resultado de la conversión.

## Estructura del Proyecto

```
.
├── com
│   └── aluracursos
│       └── conversordemonedas
│           ├── apis
│           │   └── ApiExchangerate.java
│           ├── conversordeformatos
│           │   └── ConversorJson.java
│           ├── dtos
│           │   └── ConversionMonedaExchangerate.java
│           ├── modelos
│           │   ├── ConversorMoneda.java
│           │   ├── ListaMonedasDisponibles.java
│           │   ├── ListaMonedasConsultadas.java
│           │   └── Menu.java
│           ├── excepciones
│           │   └── ArchivoNoGuardadoException.java
│           ├── manejoarchivos
│           │   └── ArchivoJson.java
│           └── principal
│               └── Main.java
└── README.md
└── LICENSE
```

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
