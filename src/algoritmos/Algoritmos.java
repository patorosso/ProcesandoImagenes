package algoritmos;

public class Algoritmos {

	public static int[][] dilatacion(int[][] image, int[][] mask) {
        int rows = image.length;
        int cols = image[0].length;
        int maskRows = mask.length;
        int maskCols = mask[0].length;
 
        int[][] output = new int[rows][cols];
 
        int rOffset = maskRows / 2;
        int cOffset = maskCols / 2;
 
        for (int i = rOffset; i < rows - rOffset; i++) {
            for (int j = cOffset; j < cols - cOffset; j++) {
                boolean found = false;
 
                // Recorre el vecindario según la máscara
                for (int mi = 0; mi < maskRows; mi++) {
                    for (int mj = 0; mj < maskCols; mj++) {
                        if (mask[mi][mj] == 1) {
                            int ii = i + mi - rOffset;
                            int jj = j + mj - cOffset;
                            if (image[ii][jj] == 0) {
                                found = true;
                                break;
                            }
                        }
                    }
                    if (found) break;
                }
 
                output[i][j] = found ? 0 : 255;
            }
        }
 
        return output;
    }
	
	public static int[][] erosion(int[][] imagen, int vecindario) {
		int height = imagen.length;
		int width = imagen[0].length;
		
		int[][] matrizDilatada = {{}};


		return matrizDilatada;
	}

}
