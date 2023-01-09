import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class InterfazPunto extends JFrame implements ActionListener {

	// crea un panel central
	JPanel panelNorte;
	JPanel panelCentral;
	JPanel panelSur;

	JPanel panelNorteIzq;

	JPanel panelNorteDer;
	JLabel lpunto1x;
	JLabel lpunto1y;
	JTextField JTFPunto1x;
	JTextField JTFPunto1y;
	JLabel lpunto2x;
	JLabel lpunto2y;
	JTextField JTFPunto2x;
	JTextField JTFPunto2y;
	JButton JBCalcular;
	JButton JBDibujar;
	JButton JBLimpiar;
	JTextArea JTFdistancia;

	JLabel seleccionFiguraLabel;

	ButtonGroup buttonGroup;
	JRadioButton linea;
	JRadioButton cuadrado;
	JRadioButton triangulo;

	JComboBox comboFiguras;

	PanelDibujo dibujar;

	// Crea dos instancias de tipo punto
	Punto miPunto1;
	Punto miPunto2;

	// Constructor de la clase interfaz punto. Aquí creamos una instancia de
	// todos los componentes de la ventana, la cual la dividimos en tres paneles,
	// Norte, Central y Sur
	// El panel Central va a estar compuesto a su vez por el panel Dibujo y el
	// textArea, en el cual mostramos
	// la distancia entre dos punto

	InterfazPunto() {

		panelNorte = new JPanel();
		panelCentral = new JPanel();
		panelNorteDer = new JPanel();
		panelNorteIzq = new JPanel();
		panelSur = new JPanel();
		dibujar = new PanelDibujo();
		dibujar.setBackground(Color.gray);

		lpunto1x = new JLabel("Coordenada x");
		lpunto1y = new JLabel("Coordenada y");

		// Le damos un valor inicial al punto 1
		// para asegurar que el rectángulo se pinta en una zona correcta
		JTFPunto1x = new JTextField("80");
		JTFPunto1y = new JTextField("80");

		lpunto2x = new JLabel("Coordenada x");
		lpunto2y = new JLabel("Coordenada y");

		JTFPunto2x = new JTextField();
		JTFPunto2y = new JTextField();

		JBCalcular = new JButton("Calcular");
		JBDibujar = new JButton("Dibujar");
		JBLimpiar = new JButton("Limpiar");

		JTFdistancia = new JTextArea();

		panelNorteDer.setLayout(new GridBagLayout());
		// Construir la primera fila de componentes
		panelNorteDer.add(lpunto1x, createConstraints(0, 0, 1, 1, 0.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelNorteDer.add(JTFPunto1x, createConstraints(1, 0, 2, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelNorteDer.add(lpunto1y, createConstraints(3, 0, 1, 1, 0.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelNorteDer.add(JTFPunto1y, createConstraints(4, 0, 2, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));

		// Construir la segunda fila de componentes
		panelNorteDer.add(lpunto2x, createConstraints(0, 1, 1, 1, 0.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelNorteDer.add(JTFPunto2x, createConstraints(1, 1, 2, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelNorteDer.add(lpunto2y, createConstraints(3, 1, 1, 1, 0.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelNorteDer.add(JTFPunto2y, createConstraints(4, 1, 2, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		;
		// Añadir el panel norte a la interfaz, la cual por ser un JFrame utiliza por
		// defecto el layout BorderLayout



		//Añado los radiobutton al panel norte izquierdo.

		panelNorteIzq.setLayout(new GridLayout(4,1));
		panelNorteIzq.setBorder(BorderFactory.createTitledBorder(""));

		seleccionFiguraLabel = new JLabel("¿Qué figura quieres dibujar?");
		panelNorteIzq.add(seleccionFiguraLabel);

		buttonGroup = new ButtonGroup();
		linea = new JRadioButton("Linea");
		cuadrado = new JRadioButton("Cuadrado");
		triangulo = new JRadioButton("Triángulo");



		buttonGroup.add(linea); buttonGroup.add(cuadrado); buttonGroup.add(triangulo);

		panelNorteIzq.add(linea); panelNorteIzq.add(cuadrado); panelNorteIzq.add(triangulo);


		/*
		comboFiguras = new JComboBox();
		comboFiguras.addItem("linea");
		comboFiguras.addItem("cuadrado");
		comboFiguras.addItem("triangulo");

		panelNorteIzq.add(comboFiguras);*/

		panelNorte.add(panelNorteIzq);

		panelNorte.add(panelNorteDer);

		add(panelNorte, BorderLayout.NORTH);

		// Construir el panel Central
		panelCentral.setLayout(new GridLayout(1, 2));
		Border miBorde = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

		panelCentral.setBorder(miBorde);
		JTFdistancia.setEditable(false);
		JTFdistancia.setBorder(miBorde);

		panelCentral.add(JTFdistancia);
		panelCentral.add(dibujar);

		// Añadir el panel central a la interfaz
		add(panelCentral, BorderLayout.CENTER);

		// Construir el panel Sur
		panelSur.setLayout(new GridBagLayout());

		// Construir la fila de botones
		panelSur.add(JBCalcular, createConstraints(0, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelSur.add(JBDibujar, createConstraints(1, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));
		panelSur.add(JBLimpiar, createConstraints(2, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 10, 10, 4)));

		// Añadir el panel sur a la interfaz
		add(panelSur, BorderLayout.SOUTH);

		// Poner los botones a la escucha
		JBCalcular.addActionListener(this);
		JBLimpiar.addActionListener(this);
		JBDibujar.addActionListener(this);

		// Poner el botón dibujar desactivado hasta que el usuario introduzca un puno
		JBDibujar.setEnabled(false);

		// Poner el punto 1 no editaable para que el usuario tenga el primer punto fijo
		JTFPunto1x.setEditable(false);
		JTFPunto1y.setEditable(false);

		// Crear dos instancias de la clase punto
		miPunto1 = new Punto();
		miPunto2 = new Punto();

		// Asignar el foco al cuadro de texto del punto2
		JTFPunto2x.requestFocus();

		this.setMinimumSize(new Dimension(300, 300));

	}

	
	/*
	 * Implementación de la funcionalidad. Todos los botones implementan la
	 * interface ActionListener, por lo que cada vez
	 * que pulsamos en un botón, ejecuta el mismo método.
	 * Debido a esto la primera instrucción que debemos añadir es la que nos permite
	 * identificar que botón a pulsado el usuario
	 * y dependiendo de eso realizamos una función u otra.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		/*
		 * Lo primero que hacemos es obtener el objeto punto de los cuadros de texto.
		 * Como el JTextField nos devuelve un dato
		 * de tipo String y el objeto Punto necesita dos coordenadas de tipo Double
		 * debemos hacer la conversión. Dicha conversion
		 * puede lanzar una excepción cuando se produce un error, por lo cual debemos
		 * capturarla. Esto lo hacemos incluyendo las
		 * instrucciones susceptibles de que se produzca una excepción dentro del try.
		 * Sería más correcto que cada conversión tuviera su propio bloque y gestionar
		 * los posibles errores por separado, y hacer que
		 * si el usuario introduce un valor incorrecto en el cuadro de texto no le deje
		 * pasar al siguiente. Esto se gestiona con los eventos
		 * del foco
		 * 
		 */

		if (arg0.getSource() == JBCalcular) {
			try {
				miPunto1.asignarX(Double.parseDouble(JTFPunto1x.getText()));
				miPunto1.asignarY(Double.parseDouble(JTFPunto1y.getText()));

				miPunto2.asignarX(Double.parseDouble(JTFPunto2x.getText()));
				miPunto2.asignarY(Double.parseDouble(JTFPunto2y.getText()));
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Se ha producido un error al convertir el texto a Double" + e.getMessage());
			}

			Double distanciaPuntos = Math.round(miPunto1.calcularDistancia(miPunto2) * 100.0) / 100.0;
			// Sacamos en el textArea los dos puntos con el siguiente mensaje. Para ello
			// modificamos la clase punto
			// y le añado el método mostrarPunto

			JTFdistancia.setText(JTFdistancia.getText() + (distanciaPuntos + "\n"));

			// Al calcular la distancia entre dos puntos activar el botón Dibujar
			JBDibujar.setEnabled(true);
		}
		if (arg0.getSource() == JBLimpiar) {

			JTFPunto2x.requestFocus();

			JTFPunto2x.setText("");
			JTFPunto2y.setText("");

			dibujar.asignarPunto(new Punto(0, 0), new Punto(this.getWidth(), this.getHeight()));
			dibujar.setLimpiar(true);
			dibujar.repaint();

		}
		if (arg0.getSource() == JBDibujar) {
			JBDibujar.setEnabled(false);

			dibujar.asignarPunto(miPunto1, miPunto2);
			dibujar.setLimpiar(false);

			// Comprobar si el tamaño del rectángulo que estamos dibujando 
			// es mayor que el contenedor (en este caso el JPanel)
			int width = (int) (dibujar.obtenerPunto2().obtenerX()) - (int) (dibujar.obtenerPunto1().obtenerX());
			System.out.println("el tamaño es "+ width);

			// En este caso al ancho del panel dibujo le resto la coordenada X del primer
			// punto, ya que no dibujo el rectángulo en el punto (0,0)
			if (width > dibujar.getWidth()-dibujar.obtenerPunto1().obtenerX()) {
				System.out.println(("Entro en el if"));
				if (width > dibujar.getHeight()-dibujar.obtenerPunto1().obtenerY()) 	
					//En este caso modificamos el alto y el ancho de la ventana
					this.setMinimumSize(new Dimension(this.getWidth() + width, this.getHeight() + width));
				else 
					//En este caso modificamos sólo el ancho de la ventana
					this.setMinimumSize(new Dimension(this.getWidth() + width, dibujar.getHeight()));
							
			}
			dibujar.repaint();

		}

	}

	public static void main(String s[]) {
		InterfazPunto miVentanaPunto = new InterfazPunto();
		miVentanaPunto.setSize(600, 400);
		miVentanaPunto.setLocation(80, 60);
		miVentanaPunto.setVisible(true);
	}

	private static GridBagConstraints createConstraints(int gridx, int gridy, int gridwidth, int gridheight,
			double weightx, double weighty, int fill, int anchor, Insets insets) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		constraints.fill = fill;
		constraints.anchor = anchor;
		constraints.insets = insets;
		return constraints;
	}
}
