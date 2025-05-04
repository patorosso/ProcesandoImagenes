package matriz;

public class Matriz {

	public static StringBuilder ToString(int[][] matriz) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				sb.append(matriz[i][j]).append("\t");
			}
			sb.append("\n");
		}
		return (sb);
	}

	public static int CantidadFilas(int[][] matriz) {
		return matriz.length;
	}

	public static int CantidadColumnas(int[][] matriz) {
		return matriz[0].length;
	}
}
