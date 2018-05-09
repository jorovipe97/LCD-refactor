/** 
 * 
 * Estructura de datos para almacenar la información de un display
 * 
 * @author Jose Villalobos 
 * 
 * @see <a href="https://www.geeksforgeeks.org/wp-content/uploads/bcd.png">¿Que es un display de 7 segmentos?</a>
 *
 */
public class DigitSegmentDisplay {
	
	// Los 7 segmentos del display
	private boolean[] segmentos;
	
	// Matriz que almacena lo que se imprime en consola
	private String[][] digitDisplay;
	
	private int displaySize;
	
	/** El ancho del display */
	public int ancho;
	/** El alto del display */
	public int alto;
	
	public DigitSegmentDisplay(int size)
	{
		// Guarda el tamaño del display como miembro de clase
		this.displaySize = size;
		
		// Inicializa los 7 segmentos del display
		this.segmentos = new boolean[7];
		
		// Cada dígito debe ocupar exactamente size+2 columnas y 2*size + 3 filas.
		this.ancho = size + 2;
		this.alto = (size*2) + 3;
		// Inicializa la matriz que se imprimira en consola.
		this.digitDisplay = new String[this.alto][this.ancho];		
		for (int i = 0; i < this.alto; i++)
		{
			for (int j = 0; j < this.ancho; j++)
			{
				this.digitDisplay[i][j] = " ";
			}
		}
	}
	
	/**
	 * Muestra un numero en el display
	 * @param n el numero que se quiere mostrar en el display
	 * @throws IllegalArgumentException Si el argumento n no esta en el rango [0, 9]
	 */
	public void set(int n)
	{
		if (n < 0 || n > 9)
		{
			throw new IllegalArgumentException("El digito del display debe estar entre 0 y 9");
		}		
		
		
		// Obtiene los 4 bits menos significativos del argumento
		configurarSegmentos((n&8) != 0, (n&4) != 0, (n&2) != 0, (n&1) != 0);
				
	}
	
	/**
	 * Convierte BCD a 7 Segment
	 * 
	 * @param A El bit mas bit mas significativo del numero BCD
	 * @param B 
	 * @param C
	 * @param D El bit menos significativo del numero BCD
	 */
	protected void configurarSegmentos(boolean A, boolean B, boolean C, boolean D)
	{
		// Enciende todos los segmentos unicamente para propositos de debug
		/*for (int i = 0; i < this.segmentos.length; i++)
		{
			this.segmentos[i] = true;
		}*/
		
		/* En el link puedes ver una tabla de verdad que convierte de BCD a 7 Segments: https://www.electrical4u.com/images/march16/1460385570.PNG
		 * nos valdremos de esta tabla de verdad para hallar una función canonica como suma de miniterminos y la usaremos para 
		 * convertir de BCD a 7-Segment, en mi blog puedes ver en mas detalle
		 * este concepto: https://jorovipe97.github.io/Implementando-funciones-boleanas-CS01/#represantacion-cananonica-y-sus-implicaciones-teoricas---concepto2-concepto3
		 * */
		
		// TODO Simplificar las funciones canonicas usando propiedades del algebra booleana
		
		// Funcion canonica para segmento 'a'
		this.segmentos[0] = (!A && !B && !C && !D) || 
				(!A && !B && C && !D) || 
				(!A && !B && C && D) || 
				(!A && B && !C && D) || 
				(!A && B && C && !D) ||
				(!A && B && C && D) ||
				(A && !B && !C && !D) ||
				(A && !B && !C && D);
		
		// Funcion canonica para segmento 'b'
		this.segmentos[1] = (!A && !B && !C && !D) || 
				(!A && !B && !C && D) || 
				(!A && !B && C && !D) ||
				(!A && !B && C && D) || 
				(!A && B && !C && !D) ||
				(!A && B && C && D) ||
				(A && !B && !C && !D) ||
				(A && !B && !C && D);
		
		// Funcion canonica para segmento 'c'
		this.segmentos[2] = (!A && !B && !C && !D) || 
				(!A && !B && !C && D) ||
				(!A && !B && C && D) ||
				(!A && B && !C && !D) ||
				(!A && B && !C && D) || 
				(!A && B && C && !D) ||
				(!A && B && C && D) ||
				(A && !B && !C && !D) ||
				(A && !B && !C && D);
		
		// Funcion canonica para segmento 'd'
		this.segmentos[3] = (!A && !B && !C && !D) ||
				(!A && !B && C && !D) ||
				(!A && !B && C && D) ||
				(!A && B && !C && D) ||
				(!A && B && C && !D) ||
				(A && !B && !C && !D) ||
				(A && !B && !C && D);
		
		// Funcion canonica para segmento 'e'
		this.segmentos[4] = (!A && !B && !C && !D) ||
				(!A && !B && C && !D) ||
				(!A && B && C && !D) ||
				(A && !B && !C && !D);
		
		// Funcion canonica para segmento 'f'
		this.segmentos[5] = (!A && !B && !C && !D) ||
				(!A && B && !C && !D) ||
				(!A && B && !C && D) ||
				(!A && B && C && !D) ||
				(A && !B && !C && !D) ||
				(A && !B && !C && D);
		
		// Funcion canonica para segmento 'g'
		this.segmentos[6] = (!A && !B && C && !D) ||
				(!A && !B && C && D) ||
				(!A && B && !C && !D) ||
				(!A && B && !C && D) ||
				(!A && B && C && !D) ||
				(A && !B && !C && !D) ||
				(A && !B && !C && D);
				
				
		// Enciende el display
		this.encenderDisplay();
	}
	
	/**
	 * Imprime la fila del display especificada en el parametro
	 * 
	 * @param row La fila que quiero imprimir
	 * @throws ArrayIndexOutOfBoundsException si la fila especificada no existe en el display
	 */
	public void mostrarFilaDelDisplay(int row, boolean mostrarVarios)
	{
		try
		{
			for (int i = 0; i < this.digitDisplay[row].length; i++)
			{
				System.out.print(this.digitDisplay[row][i]);
			}
			
			// Si no va a mostrar varis displays poner salto de linea al finalalizar la lectura de la fila
			if (!mostrarVarios)
			{
				System.out.print("\n");
			}
			
		}
		catch (ArrayIndexOutOfBoundsException ex) // Si la fila especificada esta fuera de los rangos del array
		{
			System.out.println(ex.getMessage());
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}
	
	/**
	 * Usa la información codificada en los segmentos y enciende el display
	 */
	private void encenderDisplay()
	{
		int row = 0;
		int col = 0;
		
		// Mirar esta imagen para entender a que me refiero con segmentos: https://www.geeksforgeeks.org/wp-content/uploads/bcd.png
		if (this.segmentos[0]) // Si el segmento 'a' esta encendido
		{
			dibujarSegmentoHorizontal(0, 0);
		}
		
		if (this.segmentos[1]) // Si el segmento 'b' esta encendido
		{
			col = (this.ancho - 1);
			dibujarSegmentoVertical(0, col);
		}
		
		if (this.segmentos[2]) // Si el segmento 'c' esta encendido
		{
			row = (this.alto / 2);
			col = (this.ancho - 1);
			dibujarSegmentoVertical(row, col);
		}
		
		if (this.segmentos[3]) // Si el segmento 'd' esta encendido
		{
			row = (this.alto - 1);
			dibujarSegmentoHorizontal(row, 0);
		}
		
		if (this.segmentos[4]) // Si el segmento 'e' esta encendido
		{
			row = (this.alto / 2);
			dibujarSegmentoVertical(row, 0);
		}
		
		if (this.segmentos[5]) // Si el segmento 'f' esta encendido
		{
			dibujarSegmentoVertical(0, 0);
		}
		
		if (this.segmentos[6]) // Si el segmento 'g' esta encendido
		{
			row = (this.alto / 2);
			
			dibujarSegmentoHorizontal(row, 0);
		}
	}
	
	/**
	 * Dibuja un segmento horizontal en el display en la fila especificada empezando en la fila especificada
	 * @param row La fila en la que dibuja el segmento
	 * @param col la columna en la que empieza a dibujar el segmento
	 */
	private void dibujarSegmentoHorizontal(int row, int col)
	{
		for (int i = (col+1); i <= this.displaySize; i++)
		{
			this.digitDisplay[row][i] = "-";
		}
	}
	
	/**
	 * Dibuja un segmento vertical en la columna especificada, empezando en la fila especificada, el segmento se dibuja hacia abajo
	 *  
	 * @param row la fila desde la que empieza a dibujar el segmento
	 * @param col La columna en la que dibuja el segmento
	 * */
	private void dibujarSegmentoVertical(int row, int col)
	{
		for (int i = (row+1); i <= row+this.displaySize; i++)
		{
			this.digitDisplay[i][col] = "|";
		}
	}
	
}
