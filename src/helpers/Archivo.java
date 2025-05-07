package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Archivo {

	public static int[][] leerArchivo(String path) throws IOException {
		int[][] imagen = null;
		String format;
		int ancho, alto, valorMaximo;

		try (FileInputStream fis = new FileInputStream(new File(path))) {
			Scanner scanner = new Scanner(fis);

			// Leer el formato ("P2" o "P5")
			format = scanner.next();
			if (!format.equals("P2") && !format.equals("P5")) {
				throw new IllegalArgumentException("Formato PGM no soportado: " + format);
			}

			// Saltar comentarios si los hay
			while (scanner.hasNext("#")) {
				scanner.nextLine();
			}

			// Leer ancho, alto y valor m�ximo del color
			ancho = scanner.nextInt();
			alto = scanner.nextInt();
			valorMaximo = scanner.nextInt(); // 255 (blanco)

			// Si es formato ASCII (P2)
			if (format.equals("P2")) {
				imagen = new int[alto][ancho];

				// Leer los valores de los p�xeles y llenar la matriz
				for (int i = 0; i < alto; i++) {
					for (int j = 0; j < ancho; j++) {
						imagen[i][j] = scanner.nextInt();
					}
				}
			}
			// Si es formato binario (P5)
			else if (format.equals("P5")) {
				// Leer el resto en binario
				fis.getChannel().position(fis.getChannel().position() + scanner.match().end()); // Saltar la parte le�da
																								// por el scanner

				// Inicializar la matriz
				imagen = new int[alto][ancho];

				 // Leer los valores de los p�xeles como bytes y llenar la matriz
                byte[] pixelData = new byte[ancho * alto];
                fis.read(pixelData);  // Leer los p�xeles en un arreglo de bytes

                int index = 0;
                for (int i = 0; i < alto; i++) {
                    for (int j = 0; j < ancho; j++) {
                        // Convertir el byte sin signo a entero (0-255)
                        imagen[i][j] = pixelData[index++] & 0xFF;
                    }
                }
			}
		}

		return imagen;
	}
	
	// Guardar la matriz en formato ASCII (P2)
    public static void guardarPGM_P2(int[][] imagen, String path) throws IOException {
        int alto = imagen.length;
        int ancho = imagen[0].length;

        try (PrintWriter writer = new PrintWriter(new File(path))) {
            // Escribir la cabecera
            writer.println("P2");
            writer.println(ancho + " " + alto);
            writer.println(Constantes.PIXEL_BLANCO); // Valor max

            // Escribir los valores de los p�xeles
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    writer.print(imagen[i][j] + " ");
                }
                writer.println();
            }
        }
    }

    // Guardar la matriz en formato binario (P5)
    public static void guardarPGM_P5(int[][] imagen, String path) throws IOException {
        int alto = imagen.length;
        int ancho = imagen[0].length;

        try (FileOutputStream fos = new FileOutputStream(new File(path))) {
            // Escribir la cabecera
            String header = "P5\n" + ancho + " " + alto + "\n" + Constantes.PIXEL_BLANCO + "\n";
            fos.write(header.getBytes());

            // Escribir los valores de los p�xeles en binario
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    fos.write(imagen[i][j]);
                }
            }
        }
    }

}
