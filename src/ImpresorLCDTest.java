import static org.junit.Assert.*;

import org.junit.Test;

public class ImpresorLCDTest {

	
	@Test(expected = IllegalArgumentException.class)
	public void argumentExceptionNoComa() {
		String comando = "25";
		
		// Se crea una instancia de la clase encargada de ejecutar los comandos
	    ImpresorLCD impresorLCD = new ImpresorLCD();
	    impresorLCD.procesar(comando, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void argumentExceptionMuchosArgumentos() {
		String comando = "2,5,6";
		
		// Se crea una instancia de la clase encargada de ejecutar los comandos
	    ImpresorLCD impresorLCD = new ImpresorLCD();
	    impresorLCD.procesar(comando, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void argumentExceptionPocosArgumentos() {
		String comando = ",25";
		
		// Se crea una instancia de la clase encargada de ejecutar los comandos
	    ImpresorLCD impresorLCD = new ImpresorLCD();
	    impresorLCD.procesar(comando, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void argumentExceptionSizeNoInteger() {
		String comando = "ab,3";
		
		// Se crea una instancia de la clase encargada de ejecutar los comandos
	    ImpresorLCD impresorLCD = new ImpresorLCD();
	    impresorLCD.procesar(comando, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void argumentExceptionSizeFueraRango() {
		String comando = "0,10556";
		
		// Se crea una instancia de la clase encargada de ejecutar los comandos
	    ImpresorLCD impresorLCD = new ImpresorLCD();
	    impresorLCD.procesar(comando, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void argumentExceptionDisplayNoDigit() {
		String comando = "2,4f4";
		
		// Se crea una instancia de la clase encargada de ejecutar los comandos
	    ImpresorLCD impresorLCD = new ImpresorLCD();
	    impresorLCD.procesar(comando, 2);
	}
	
	@Test
	public void argumentExceptionCommandHack1() {
		String comando = "2,1\n";
		
		// Se crea una instancia de la clase encargada de ejecutar los comandos
	    ImpresorLCD impresorLCD = new ImpresorLCD();
	    impresorLCD.procesar(comando, 2);
	}
	@Test
	public void argumentExceptionCommandHack2() {
		String comando = "2  , 2\n";
		
		// Se crea una instancia de la clase encargada de ejecutar los comandos
	    ImpresorLCD impresorLCD = new ImpresorLCD();
	    impresorLCD.procesar(comando, 2);
	}
	
	@Test
	public void argumentExceptionCommandHack3() {
		String comando = "\n2  , 3\n";
		
		// Se crea una instancia de la clase encargada de ejecutar los comandos
	    ImpresorLCD impresorLCD = new ImpresorLCD();
	    impresorLCD.procesar(comando, 2);
	}
	
	@Test
	public void argumentExceptionCommandHack4() {
		String comando = "\n2  \n, 4\n";
		
		// Se crea una instancia de la clase encargada de ejecutar los comandos
	    ImpresorLCD impresorLCD = new ImpresorLCD();
	    impresorLCD.procesar(comando, 2);
	}
}
