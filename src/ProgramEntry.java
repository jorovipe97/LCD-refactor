import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
// import javax.swing.JOptionPane;


// Se comentó el codigo para mejorar legibilidad asi como javadocs para facilitar el entendimiento para futuros programadores.
public class ProgramEntry {
	
	// Cuando se reciba este string el programa finalizara
    static final String CADENA_FINAL = "0,0";
    
    public static void main(String[] args) {
    	// String entrada = JOptionPane.showInputDialog("Digite el numero");
    	
        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        // Comando actual
        String comando;
        
        // Numero de espacios que debe haber entre cada digito
        int espacioDig;
        
        try {

            try (Scanner lector = new Scanner(System.in)) {
                
                System.out.print("Espacio entre Digitos (0 a 5): ");
                comando = lector.next();

                // Valida si es un número
                if (ImpresorLCD.isInteger(comando)) 
                {
                    espacioDig = Integer.parseInt(comando);
                    
                    // se valida que el espaciado este entre 0 y 5
                    if(espacioDig<0 || espacioDig>5)
                    {
                        throw new IllegalArgumentException("El espacio entre "
                                + "digitos debe estar entre 0 y 5");
                    }
                    
                } 
                else
                {
                	// Si no es un numero, se lanza una excepción de argumento invalido
                    throw new IllegalArgumentException("Cadena \"" + comando
                            + "\" no es un entero");
                }
                
                do
                {
                	// Se pregunta al usuarió un comando.
                    System.out.print("Entrada: ");
                    comando = lector.next();
                    
                    // Si el comando actual no es igual a la cadena "0,0"  
                    if(!comando.equalsIgnoreCase(CADENA_FINAL))
                    {
                    	// Agregar comando actual a la lista de comandos (cuando se envie el comando de finalizacion se ejecutaran los comandos almacenados en esta lista).
                        listaComando.add(comando);
                    }
                } while (!comando.equalsIgnoreCase(CADENA_FINAL)); // Mientras el comando actual no sea igual al comando de terminación seguir preguntando comandos
            }

            // Se crea una instancia de la clase encargada de ejecutar los comandos
            ImpresorLCD impresorLCD = new ImpresorLCD();
            
            // Convierte la lista de comandos a un Iterator para acceder a sus elementos de una forma sintacticamente mas comoda
            Iterator<String> iterator = listaComando.iterator();
            // Mientras haya comandos, se procesan.
            while (iterator.hasNext()) 
            {
                try 
                {
                	// Se procesan un comando de la lista de comandos
                    impresorLCD.procesar(iterator.next(), espacioDig);
                } catch (Exception ex) 
                {
                	// Si hubo un problema procesando el comando se captura la excepcion.
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        }
        catch (NumberFormatException ex) // Ahora se manejan excepciones mas especificas para dar mayor control y mantenibilidad a los futuros programadores
        {        	
        	System.out.println("Error: " + ex.getMessage());
        }
        catch (Exception ex) 
        {
            System.out.println("Error: " + ex.getMessage());
        }

    }

}