package algoritmos;

import helpers.Constantes;

public class Algoritmos {

	public static int[][] dilatacion(int[][] imagen, int[][] vecindad) {
		int filas = imagen.length;
		int columnas = imagen[0].length;
		int filasVecindad = vecindad.length;
		int columnasVecindad = vecindad[0].length;

		int[][] resultado = new int[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {

				boolean aplicarDilatacion = false;

				for (int vi = 0; vi < filasVecindad; vi++) {
					for (int vj = 0; vj < columnasVecindad; vj++) {

						if (vecindad[vi][vj] == Constantes.BIT_A_IGNORAR)
							continue;

						int ni = i + vi - vecindad.length / 2;
						int nj = j + vj - vecindad[0].length / 2;

						if (ni >= 0 && ni < filas && nj >= 0 && nj < columnas) {
							if (imagen[ni][nj] == Constantes.PIXEL_BLANCO) {
								aplicarDilatacion = true;
								break;
							}
						} // else: Fuera del rango => ignoramos
					}

					if (aplicarDilatacion)
						break;
				}

				resultado[i][j] = aplicarDilatacion ? Constantes.PIXEL_BLANCO : Constantes.PIXEL_NEGRO;
			}
		}

		return resultado;
	}

	public static int[][] erosion(int[][] imagen, int[][] vecindad) {
		int filas = imagen.length;
		int columnas = imagen[0].length;
		int filasVecindad = vecindad.length;
		int columnasVecindad = vecindad[0].length;

		int[][] resultado = new int[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {

				boolean mantenerBlanco = true;

				for (int vi = 0; vi < filasVecindad; vi++) {
					for (int vj = 0; vj < columnasVecindad; vj++) {

						if (vecindad[vi][vj] == Constantes.BIT_A_IGNORAR)
							continue;

						int ni = i + vi - filasVecindad / 2;
						int nj = j + vj - columnasVecindad / 2;

						if (ni >= 0 && ni < filas && nj >= 0 && nj < columnas) {
							if (imagen[ni][nj] == Constantes.PIXEL_NEGRO) {
								mantenerBlanco = false;
								break;
							}
						} else {
							// Fuera de los límites de la imagen => tratamos como negro
							mantenerBlanco = false;
							break;
						}
					}
					if (!mantenerBlanco)
						break;
				}

				resultado[i][j] = mantenerBlanco ? Constantes.PIXEL_BLANCO : Constantes.PIXEL_NEGRO;
			}
		}

		return resultado;
	}

}
