package main;
import helpers.*;
import java.io.IOException;
import algoritmos.Algoritmos;

public class Main {
	public static void main(String[] args) {
		try {

			int[][] imagen = Archivo.leerArchivo("./resources/in/texto_prueba.pgm");
			int[][] vecindad = Matrices.getVecindad(Matrices.TipoVecindad.COMPLETA_10x10);
//			int[][] vecindad = Matrices.getVecindad(Matrices.TipoVecindad.CRUZ_GRUESA_10x10);
//			int[][] vecindad = Matrices.getVecindad(Matrices.TipoVecindad.DIAGONAL_ZIGZAG_10x10);
//			int[][] vecindad = Matrices.getVecindad(Matrices.TipoVecindad.SEMICIRCULAR_INFERIOR_10x10);

			int[][] imagenErosion = Algoritmos.erosion(imagen, vecindad);
			int[][] imagenDilatacion = Algoritmos.dilatacion(imagen, vecindad);

			Archivo.guardarPGM_P2(imagenErosion, "./resources/out/texto_prueba_erosion.pgm");
			Archivo.guardarPGM_P2(imagenDilatacion, "./resources/out/texto_prueba_dilatacion.pgm");
			
			System.out.println("[" + Fecha.getTiempo + "] \nImágenes creadas con éxito!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
