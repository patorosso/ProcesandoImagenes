package algoritmos;
import org.junit.Assert;
import org.junit.Test;


public class DilatacionTests {

	 	@Test
	    public void testDilatacionSimple() {
	        int[][] imagen = {
	            {0, 0, 0},
	            {0, 255, 0},
	            {0, 0, 0}
	        };

	        int[][] vecindad = {
	            {1, 1, 1},
	            {1, 1, 1},
	            {1, 1, 1}
	        };

	        int[][] esperado = {
	            {255, 255, 255},
	            {255, 255, 255},
	            {255, 255, 255}
	        };

	        int[][] resultado = Algoritmos.dilatacion(imagen, vecindad);

	        for (int i = 0; i < esperado.length; i++) {
	            Assert.assertArrayEquals("Error en fila " + i, esperado[i], resultado[i]);
	        }
	    }
	 
	 @Test
	 public void testDilatacionSinBlancos() {
	     int[][] imagen = {
	         {0, 0, 0},
	         {0, 0, 0},
	         {0, 0, 0}
	     };

	     int[][] vecindad = {
	         {1, 1, 1},
	         {1, 1, 1},
	         {1, 1, 1}
	     };

	     int[][] esperado = {
	         {0, 0, 0},
	         {0, 0, 0},
	         {0, 0, 0}
	     };

	     int[][] resultado = Algoritmos.dilatacion(imagen, vecindad);

	     for (int i = 0; i < esperado.length; i++) {
	         Assert.assertArrayEquals("Error en fila " + i, esperado[i], resultado[i]);
	     }
	 }
	 
	 
	 @Test
	 public void testDilatacionMultiplesBlancos() {
	     int[][] imagen = {
	         {255, 0, 0},
	         {0, 0, 0},
	         {0, 0, 255}
	     };

	     int[][] vecindad = {
	         {1, 1, 1},
	         {1, 1, 1},
	         {1, 1, 1}
	     };

	     int[][] esperado = {
	         {255, 255, 0},
	         {255, 255, 255},
	         {0, 255, 255}
	     };

	     int[][] resultado = Algoritmos.dilatacion(imagen, vecindad);

	     for (int i = 0; i < esperado.length; i++) {
	         Assert.assertArrayEquals("Error en fila " + i, esperado[i], resultado[i]);
	     }
	 }
	 
	 
	 @Test
	 public void testDilatacionConVecindadCruz() {
	     int[][] imagen = {
	         {0, 0, 0},
	         {0, 255, 0},
	         {0, 0, 0}
	     };

	     int[][] vecindad = {
	         {0, 1, 0},
	         {1, 1, 1},
	         {0, 1, 0}
	     };

	     int[][] esperado = {
	         {0, 255, 0},
	         {255, 255, 255},
	         {0, 255, 0}
	     };

	     int[][] resultado = Algoritmos.dilatacion(imagen, vecindad);

	     for (int i = 0; i < esperado.length; i++) {
	         Assert.assertArrayEquals("Error en fila " + i, esperado[i], resultado[i]);
	     }
	 }
	 
	 
	 @Test
	 public void testDilatacionEnEsquina() {
	     int[][] imagen = {
	         {255, 0, 0},
	         {0, 0, 0},
	         {0, 0, 0}
	     };

	     int[][] vecindad = {
	         {1, 1, 1},
	         {1, 1, 1},
	         {1, 1, 1}
	     };

	     int[][] esperado = {
	         {255, 255, 0},
	         {255, 255, 0},
	         {0, 0, 0}
	     };

	     int[][] resultado = Algoritmos.dilatacion(imagen, vecindad);

	     for (int i = 0; i < esperado.length; i++) {
	         Assert.assertArrayEquals("Error en fila " + i, esperado[i], resultado[i]);
	     }
	 }

}
