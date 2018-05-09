/**
 * Clase encargada de procesar los comandos e imprimirlos en formato LCD
 */
public class ImpresorLCD {

    /* La logica de la aplicación absolutamente no debe estar aqui.
     * la primera razon es que no tiene sentido llamar un metodo fuera del scope de otro metodo
     * y la segunda razón es que esta clase esta encargada unicamente de procesar e imprimir los comandos recibidos
     * no de solicitar los comandos. 
     * */
    // TODO_FAIL: code application logic here
    // String entrada = JOptionPane.showInputDialog("Digite el numero");

     /**
     *
     * Metodo encargado de procesar la entrada que contiene el size del segmento
     * de los digitos y los digitos a imprimir
     *
     * @param comando Entrada que contiene el size del segmento de los digito
     * y el numero a imprimir
     * @param espacioDig Espacio Entre digitos
     */  
    public void procesar(String comando, int espacioDig) {
        
        String[] parametros;
        char[] digitos;
        
        // Displays para mostrar los digitos
        DigitSegmentDisplay[] displays;
        
        int tam;

        // Valida que la cadena tenga el caracter coma (',')
        if (!comando.contains(",")) {
            throw new IllegalArgumentException("Cadena \"" + comando
                    + "\" no contiene caracter ,");
        }
        
        //Se hace el split de la cadena
        parametros = comando.split(",");
        
        //Valida la cantidad de parametros
        if(parametros.length>2)
        {
           throw new IllegalArgumentException("Cadena \"" + comando
                    + "\" contiene mas argumentos de los esperados"); 
        }
        
        //Valida la cantidad de parametros
        if(parametros.length<2)
        {
           throw new IllegalArgumentException("Cadena \"" + comando
                    + "\" no contiene los parametros requeridos"); 
        }
        
        //Valida que el parametro size sea un integer
        if(isInteger(parametros[0]))
        {
            tam = Integer.parseInt(parametros[0]);
            
            // se valida que el size este entre 1 y 10
            if(tam <1 || tam >10)
            {
                throw new IllegalArgumentException("El parametro size ["+tam
                        + "] debe estar entre 1 y 10");
            }
        }
        else
        {
            throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                    + "] no es un numero");
        }
        
        
        // Crea el arreglo de digitos
        digitos = parametros[1].toCharArray();        
        displays = new DigitSegmentDisplay[digitos.length];
        
        for (int i = 0; i < digitos.length; i++) {
            
	        //Valida que el caracter sea un digito
	        if( ! Character.isDigit(digitos[i]))
	        {
	            throw new IllegalArgumentException("Caracter " + digitos[i]
	                + " no es un digito");
	        }
	        
	        // Convierte caracter a numero
	        int numero = Integer.parseInt(String.valueOf(digitos[i]));
	        
	        // Instancia los displays para los digitos
	        displays[i] = new DigitSegmentDisplay(tam);
	        // Pone el valor del display
	        displays[i].set(numero);	        
        }
        

        // Realiza la impresion del numero
        for (int row = 0; row < displays[0].alto; row++)
        {
        	for (int i = 0; i < displays.length; i++)
        	{
        		displays[i].mostrarFilaDelDisplay(row, true);
        		
        		// Salto de linea cuando lea la fila del ultimo display
        		if (i == displays.length-1)
        		{
        			System.out.print("\n");
        		}
        		else
        		{
        			// Agrega los espacios despues de mostrar la fila de un display
                	for (int spaces = 0; spaces < espacioDig; spaces++)
                	{
                		System.out.print(" ");
                	}
        		}
        	}
        }
        
        System.out.print("\n");
        // imprimirNumero(tam, parametros[1], espacioDig);

    }
    
    // TODO Analizar la opción de sacar este metodo de la clase ImpresorLCD y agregarlo a una clase de utilidades con strings
    /**
     *
     * Metodo encargado de validar si una cadena es un integer
     *
     * @param cadena Cadena
     */  
    static boolean isInteger(String cadena) {
    	/* En la implementación original se estan usando las excepciones para determinar el flujo del programa
    	 * esto es sin lugar a duda una mala practica, sin mencionar que es una operación costosa en 
    	 * terminos computacionales.
    	 * 
    	 * CONSEJO: Se recomienda mirar el detalle del commit en github para comparar los cambios	
    	 * 
    	 * Para arreglar dicho problema se decidió usar expresiones regulares para validar si es un numero entero.
    	 * 
    	 * Ademas se decidió cambiar el nombre del método por uno mas diciente.
    	 */
    	
    	// Notese el back slash en \\d esto es para que el string resultante sea \d el cual es un short-hand para decir [0-9]
    	return cadena.matches("^[+-]?\\d+$");
        
    }

}