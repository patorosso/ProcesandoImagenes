package main;

import java.io.IOException;

import algoritmos.Algoritmos;
import archivo.Archivo;
import matriz.Matriz;

public class Main {

	public static void main(String[] args) {
		try {
			int[][] imagen = null;
			imagen = Archivo.LeerArchivo("./resources/in/binary_figures.pgm");

			System.out.println("Imagen previa:\n");
			System.out.println(Matriz.ToString(imagen));
			System.out.println("\n\n----------------------------------\n\n");
			
			int vecindad = 3;
			int[][] imagenDilatada = Algoritmos.dilatacion(imagen, vecindad);

			System.out.println("Imagen post algoritmo:\n");
			System.out.println(Matriz.ToString(imagenDilatada));
			Archivo.GuardarPGM_P2(imagenDilatada, "./resources/out/cat2.pgm", 255);

		} catch (IOException e) {
			// TODO Bloque catch generado automaticamente
			e.printStackTrace();
		}
	}

}
