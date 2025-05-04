package escalamientoNearestNeighbour;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import archivo.Archivo;

public class DilatacionTests {

	@Test
	public void dilatar() throws IOException { // manteniendo las proporciones
		// Arrange
		int[][] imagen = Archivo.LeerArchivo("./resources/in/tablero blanco negro 3x3.pgm");
		int[][] esperado = { { 0, 0, 0, 255, 255, 255, 0, 0, 0 }, { 0, 0, 0, 255, 255, 255, 0, 0, 0 },
				{ 0, 0, 0, 255, 255, 255, 0, 0, 0 }, { 255, 255, 255, 0, 0, 0, 255, 255, 255 },
				{ 255, 255, 255, 0, 0, 0, 255, 255, 255 }, { 255, 255, 255, 0, 0, 0, 255, 255, 255 },
				{ 0, 0, 0, 255, 255, 255, 0, 0, 0 }, { 0, 0, 0, 255, 255, 255, 0, 0, 0 },
				{ 0, 0, 0, 255, 255, 255, 0, 0, 0 } };

		// Act
		int[][] imagenEscalada = EscalamientoNearestNeighbour.nearestNeighbourEscalado(imagen, 9, 9);

		// Assert
		Assert.assertArrayEquals(esperado, imagenEscalada);
	}

}
