import static org.junit.Assert.*;

import org.junit.Test;

public class DigitoLCDTest {

	// Prueba que los valores de los segmentos esten bien para el 0
	@Test
	public void testSegmentsForDigit0() {
		DigitoLCD digito = new DigitoLCD(4);
		digito.set(0);
		
		boolean[] expecteds = new boolean[] {
			true, true, true, true, true, true, false
		};
		assertArrayEquals("Prueba que los segmentos del display muestren bien el numero 0", expecteds, digito.segmentos);
	}
	
	@Test
	public void testSegmentsForDigit1() {
		DigitoLCD digito = new DigitoLCD(4);
		digito.set(1);
		
		boolean[] expecteds = new boolean[] {
			false, true, true, false, false, false, false
		};
		assertArrayEquals("Prueba que los segmentos del display muestren bien el numero 1", expecteds, digito.segmentos);
	}
	
	@Test
	public void testSegmentsForDigit2() {
		DigitoLCD digito = new DigitoLCD(4);
		digito.set(2);
		
		boolean[] expecteds = new boolean[] {
			true, true, false, true, true, false, true
		};
		assertArrayEquals("Prueba que los segmentos del display muestren bien el numero 2", expecteds, digito.segmentos);
	}
	
	@Test
	public void testSegmentsForDigit3() {
		DigitoLCD digito = new DigitoLCD(4);
		int n = 3;
		digito.set(n);
		
		boolean[] expecteds = new boolean[] {
			true, true, true, true, false, false, true
		};
		assertArrayEquals("Prueba que los segmentos del display muestren bien el numero " + n, expecteds, digito.segmentos);
	}
	
	@Test
	public void testSegmentsForDigit4() {
		DigitoLCD digito = new DigitoLCD(4);
		int n = 4;
		digito.set(n);
		
		boolean[] expecteds = new boolean[] {
			false, true, true, false, false, true, true
		};
		assertArrayEquals("Prueba que los segmentos del display muestren bien el numero " + n, expecteds, digito.segmentos);
	}
	
	@Test
	public void testSegmentsForDigit5() {
		DigitoLCD digito = new DigitoLCD(4);
		int n = 5;
		digito.set(n);
		
		boolean[] expecteds = new boolean[] {
			true, false, true, true, false, true, true
		};
		assertArrayEquals("Prueba que los segmentos del display muestren bien el numero " + n, expecteds, digito.segmentos);
	}
	
	@Test
	public void testSegmentsForDigit6() {
		DigitoLCD digito = new DigitoLCD(4);
		int n = 6;
		digito.set(n);
		
		boolean[] expecteds = new boolean[] {
			true, false, true, true, true, true, true
		};
		assertArrayEquals("Prueba que los segmentos del display muestren bien el numero " + n, expecteds, digito.segmentos);
	}
	
	@Test
	public void testSegmentsForDigit7() {
		DigitoLCD digito = new DigitoLCD(4);
		int n = 7;
		digito.set(n);
		
		boolean[] expecteds = new boolean[] {
			true, true, true, false, false, false, false
		};
		assertArrayEquals("Prueba que los segmentos del display muestren bien el numero " + n, expecteds, digito.segmentos);
	}
	
	@Test
	public void testSegmentsForDigit8() {
		DigitoLCD digito = new DigitoLCD(4);
		int n = 8;
		digito.set(n);
		
		boolean[] expecteds = new boolean[] {
			true, true, true, true, true, true, true
		};
		assertArrayEquals("Prueba que los segmentos del display muestren bien el numero " + n, expecteds, digito.segmentos);
	}
	
	@Test
	public void testSegmentsForDigit9() {
		DigitoLCD digito = new DigitoLCD(4);
		int n = 9;
		digito.set(n);
		
		boolean[] expecteds = new boolean[] {
			true, true, true, true, false, true, true
		};
		assertArrayEquals("Prueba que los segmentos del display muestren bien el numero " + n, expecteds, digito.segmentos);
	}
	
	@Test
	public void displayWidthShouldBe3()
	{
		DigitoLCD digito = new DigitoLCD(1);		
		assertEquals("El ancho no es igual a 3, asegurate de cumplir la formula: width = size+2", 3, digito.ancho);		
	}
	
	@Test
	public void displayHeightShouldBe5()
	{
		DigitoLCD digito = new DigitoLCD(1);		
		assertEquals("El ancho no es igual a 3, asegurate de cumplir la formula: height = size*2+3", 5, digito.alto);		
	}
	
	@Test(expected = IllegalArgumentException.class)	
	public void shouldThrowExceptionForSize0()
	{
		DigitoLCD digito = new DigitoLCD(0);	
	}
	
	@Test
	public void testDisplayForDigit8Row0()
	{
		DigitoLCD digito = new DigitoLCD(1);
		digito.set(8);
		String[] actualRow = digito.digitDisplay[0];
		String[] expectedRow = new String[] {" ", "-", " "};
		boolean[] results = new boolean[actualRow.length];
		
		for (int i = 0; i < actualRow.length; i++)
		{
			results[i] = actualRow[i].equals(expectedRow[i]);
		}		
		
		assertArrayEquals("El display no se esta imprimiendo correctamente", new boolean[] {true, true, true}, results);
	}
	
	@Test
	public void testDisplayForDigit8Row1()
	{
		DigitoLCD digito = new DigitoLCD(1);
		digito.set(8);
		String[] actualRow = digito.digitDisplay[1];
		String[] expectedRow = new String[] {"|", " ", "|"};
		boolean[] results = new boolean[actualRow.length];
		
		for (int i = 0; i < actualRow.length; i++)
		{
			results[i] = actualRow[i].equals(expectedRow[i]);
		}		
		
		assertArrayEquals("El display no se esta imprimiendo correctamente", new boolean[] {true, true, true}, results);
	}
	
	@Test
	public void testDisplayForDigit8Row2()
	{
		DigitoLCD digito = new DigitoLCD(1);
		digito.set(8);
		String[] actualRow = digito.digitDisplay[2];
		String[] expectedRow = new String[] {" ", "-", " "};
		boolean[] results = new boolean[actualRow.length];
		
		for (int i = 0; i < actualRow.length; i++)
		{
			results[i] = actualRow[i].equals(expectedRow[i]);
		}		
		
		assertArrayEquals("El display no se esta imprimiendo correctamente", new boolean[] {true, true, true}, results);
	}
	
	@Test
	public void testDisplayForDigit8Row3()
	{
		DigitoLCD digito = new DigitoLCD(1);
		digito.set(8);
		String[] actualRow = digito.digitDisplay[3];
		String[] expectedRow = new String[] {"|", " ", "|"};
		boolean[] results = new boolean[actualRow.length];
		
		for (int i = 0; i < actualRow.length; i++)
		{
			results[i] = actualRow[i].equals(expectedRow[i]);
		}		
		
		assertArrayEquals("El display no se esta imprimiendo correctamente", new boolean[] {true, true, true}, results);
	}
	
	@Test
	public void testDisplayForDigit8Row4()
	{
		DigitoLCD digito = new DigitoLCD(1);
		digito.set(8);
		String[] actualRow = digito.digitDisplay[4];
		String[] expectedRow = new String[] {" ", "-", " "};
		boolean[] results = new boolean[actualRow.length];
		
		for (int i = 0; i < actualRow.length; i++)
		{
			results[i] = actualRow[i].equals(expectedRow[i]);
		}		
		
		assertArrayEquals("El display no se esta imprimiendo correctamente", new boolean[] {true, true, true}, results);
	}
}
