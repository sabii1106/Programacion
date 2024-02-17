import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.awt.event.ActionListener;

   public class Sistema extends JFrame {

    private JButton Cliente;
    private JButton Administrativo;
    private JButton Dueno;
    private JButton Empleado;
    private JLabel jLabel1;
    private List<Cliente> clientesRegistrados;
    private List<Empleado> empleadosRegistrados;
    

    public Sistema() {
        initComponents();
        clientesRegistrados = new ArrayList<>();
        empleadosRegistrados = new ArrayList<>();
    }
    //METODOS PARA CLIENTES OJO
    public List<Cliente> getClientesRegistrados() {
        return clientesRegistrados;
    }

    public void agregarCliente(Cliente cliente) {
        clientesRegistrados.add(cliente);
    }
  //METODOS PARA EMPLEADOS OJO
    public List<Empleado> getEmpleadosRegistrados() {
        return empleadosRegistrados;
    }
    
    public void agregarEmpleado(Empleado empleado) {
        empleadosRegistrados.add(empleado);
    }
    public boolean existeEmpleado(String id) {
        for (Empleado empleado : empleadosRegistrados) {
            if (empleado.getId().equals(id)) {
                return true;  
            }
        }
        return false;
    }
    
    private void initComponents() {
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 51, 102));

        JPanel franjaPanel = new JPanel();
        franjaPanel.setBackground(Color.WHITE);
        franjaPanel.setPreferredSize(new Dimension(80, getHeight()));

        Font labelFont = new Font("Times New Roman", Font.BOLD, 24);
        jLabel1 = new JLabel();
        jLabel1.setFont(labelFont);
        jLabel1.setText("EL TALLER DE GEPETTO");
        jLabel1.setPreferredSize(new Dimension(5000, 300));
        jLabel1.setForeground(Color.WHITE);

        Cliente = new JButton("CLIENTE");
        Administrativo = new JButton("ADMINISTRATIVO");
        Dueno = new JButton("Dueño");
        Empleado = new JButton("Empleado");

        // Establece el fondo blanco y el color de las letras a negro solo para los botones
        Cliente.setBackground(Color.WHITE);
        Cliente.setForeground(Color.BLACK);
        
        Administrativo.setBackground(Color.WHITE);
        Administrativo.setForeground(Color.BLACK);

        Dueno.setBackground(Color.WHITE);
        Dueno.setForeground(Color.BLACK);

        Empleado.setBackground(Color.WHITE);
        Empleado.setForeground(Color.BLACK);

        Cliente.addActionListener(this::clienteActionPerformed);
        Administrativo.addActionListener(this::administrativoActionPerformed);
        Dueno.addActionListener(this::duenoActionPerformed);
        Empleado.addActionListener(this::empleadoActionPerformed);

        JButton agregarEmpleadoButton = new JButton("Agregar Empleado");
        JButton mostrarEmpleadosButton = new JButton("Mostrar Empleados");

        mostrarEmpleadosButton.addActionListener(this::mostrarEmpleadosButtonActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(franjaPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(140, 140, 140)
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(Administrativo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Cliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)                                                        )))
                                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(Cliente)
                                .addGap(100, 100, 100)
                                .addComponent(Administrativo)                          
                                .addContainerGap(51, Short.MAX_VALUE))
                        .addComponent(franjaPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }



    private void clienteActionPerformed(ActionEvent evt) {
        ClienteOptionsWindow optionsWindow = new ClienteOptionsWindow(this);
        optionsWindow.setVisible(true);
        this.dispose();
    }
    
    private void mostrarEmpleadosButtonActionPerformed(ActionEvent evt) {
        List<Empleado> listaEmpleados = getEmpleadosRegistrados();

        StringBuilder mensaje = new StringBuilder("Lista de Empleados:\n");
        for (Empleado empleado : listaEmpleados) {
            mensaje.append(empleado.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(this, mensaje.toString(), "Empleados", JOptionPane.INFORMATION_MESSAGE);
    }
    private void administrativoActionPerformed(ActionEvent evt) {
        AdministrativoOptionsWindow adminOptionsWindow = new AdministrativoOptionsWindow(this);
        adminOptionsWindow.setVisible(true);
        this.dispose();
    }

    private void duenoActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Acceso como dueño", "Información", JOptionPane.INFORMATION_MESSAGE);
        Dueno.setVisible(false);
    }

    private void empleadoActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Acceso como empleado", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Sistema sistema = new Sistema();
            sistema.setVisible(true);  
        });
    }

class VentanaBase extends JFrame {

    public VentanaBase() {
        initComponents();
    }

    private void initComponents() {

    	GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addContainerGap(240, Short.MAX_VALUE))
        );

        pack();
    }

}

class AdministrativoOptionsWindow extends VentanaBase {

    private Sistema sistema;

    public AdministrativoOptionsWindow(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
    }

    private void initComponents() {
        JButton dueñoButton = new JButton("Dueño");
        JButton regresarButton = new JButton("Regresar");
        JButton empleadoButton = new JButton("Empleado");

        dueñoButton.addActionListener(this::dueñoButtonActionPerformed);
        empleadoButton.addActionListener(this::empleadoButtonActionPerformed);
        regresarButton.addActionListener(this::regresarButtonActionPerformed);

        getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 5)); // Cambia el color a negro y ajusta el grosor a tu preferencia

        getContentPane().setBackground(new Color(0, 51, 102));

        // Establece colores para los botones
        dueñoButton.setBackground(Color.WHITE);
        dueñoButton.setForeground(Color.BLACK);

        empleadoButton.setBackground(Color.WHITE);
        empleadoButton.setForeground(Color.BLACK);

        regresarButton.setBackground(Color.WHITE);
        regresarButton.setForeground(Color.BLACK);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(85, 85, 85)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(dueñoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(empleadoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(regresarButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)) // Nuevo botón de regresar
                                                .addContainerGap(85, Short.MAX_VALUE))
                                ))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(dueñoButton)
                                .addGap(18, 18, 18)
                                .addComponent(empleadoButton)
                                .addGap(18, 18, 18)
                                .addComponent(regresarButton)
                                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }

    private void dueñoButtonActionPerformed(ActionEvent evt) {
        DueñoWindow dueñoWindow = new DueñoWindow(sistema);
        dueñoWindow.setVisible(true);
        this.dispose();
    }

    private void empleadoButtonActionPerformed(ActionEvent evt) {
        EmpleadoWindow empleadoWindow = new EmpleadoWindow(sistema);
        empleadoWindow.setVisible(true);
        this.dispose();
    }
    
    private void regresarButtonActionPerformed(ActionEvent evt) {
        Sistema sistema2 = new Sistema();
		sistema2.setVisible(true);
        this.dispose();
    }
}

class DueñoWindow extends VentanaBase {
	
	    private Sistema sistema;
	    private JPasswordField claveField;;
	    private int intentosRestantes;
	    private CarritoDeCompras carrito;
	    private String enteredID;

	    public DueñoWindow(Sistema sistema) {
	    	this.intentosRestantes = 3;
	        this.sistema = sistema;
	        initComponents();
	    }
	    private void verEmpleadosButtonActionPerformed(ActionEvent evt) {
	        List<Empleado> empleados = sistema.getEmpleadosRegistrados();

	        StringBuilder mensaje = new StringBuilder("Lista de Empleados:\n");

	        for (Empleado empleado : empleados) {
	            mensaje.append("Nombre: ").append(empleado.getNombre())
	                   .append(" - ID: ").append(empleado.getId()).append("\n");
	        }

	        JOptionPane.showMessageDialog(this, mensaje.toString(), "Lista de Empleados", JOptionPane.INFORMATION_MESSAGE);
	    }

	    private void initComponents() {
	        JButton ingresarButton = new JButton("Ingresar");
	        JButton regresarButton = new JButton("Regresar");
	        JButton mostrarEmpleadosButton = new JButton("Mostrar Empleados");
	        JButton agregarEmpleadosButton = new JButton("Agregar Empleados");

	        // Cambia el color del borde de la ventana a negro
	        getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        getContentPane().setBackground(new Color(0, 51, 102));

	        JPanel franjaPanel = new JPanel();
	        franjaPanel.setBackground(Color.WHITE);
	        franjaPanel.setPreferredSize(new Dimension(80, getHeight()));

	        // Establece colores para los componentes
	        ingresarButton.setBackground(Color.WHITE);
	        ingresarButton.setForeground(Color.BLACK);
	        regresarButton.setBackground(Color.WHITE);
	        regresarButton.setForeground(Color.BLACK);
	        mostrarEmpleadosButton.setBackground(Color.WHITE);
	        mostrarEmpleadosButton.setForeground(Color.BLACK);
	        agregarEmpleadosButton.setBackground(Color.WHITE);
	        agregarEmpleadosButton.setForeground(Color.BLACK);

	        ingresarButton.addActionListener(this::ingresarButtonActionPerformed);
	        regresarButton.addActionListener(this::regresarButtonActionPerformed);
	        mostrarEmpleadosButton.addActionListener(this::mostrarEmpleadosButtonActionPerformed);
	        agregarEmpleadosButton.addActionListener(this::agregarEmpleadosButtonActionPerformed);

	        JLabel claveLabel = new JLabel("Ingrese la contraseña:");
	        claveLabel.setForeground(Color.WHITE);

	        claveField = new JPasswordField();
	        claveField.setBackground(Color.WHITE);
	        claveField.setForeground(Color.BLACK);

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
	                                .addGap(85, 85, 85)
	                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                        .addComponent(claveLabel)
	                                        .addComponent(claveField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
	                                        .addGroup(layout.createSequentialGroup()
	                                                .addComponent(ingresarButton)
	                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                                                .addComponent(regresarButton)))
	                                .addContainerGap(85, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
	                                .addGap(46, 46, 46)
	                                .addComponent(claveLabel)
	                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(claveField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                                        .addComponent(ingresarButton)
	                                        .addComponent(regresarButton))
	                                .addContainerGap(46, Short.MAX_VALUE))
	        );

	        pack();
	    }


	    private void ingresarButtonActionPerformed(ActionEvent evt) {
	        char[] claveIngresada = claveField.getPassword(); // Obtener la contraseña ingresada
	        String claveCorrecta = "1";
	        enteredID = new String(claveIngresada);

	        if (Arrays.equals(claveIngresada, claveCorrecta.toCharArray())) {
	            // Contraseña correcta, puedes proceder a la siguiente ventana
	            mostrarOpciones();
	        } else {
	            // Contraseña incorrecta, muestra un mensaje de alerta
	            JOptionPane.showMessageDialog(this, "Contraseña incorrecta. Inténtalo de nuevo.", "Alerta", JOptionPane.WARNING_MESSAGE);

	            // Decrementar el número de intentos restantes
	            intentosRestantes--;

	            if (intentosRestantes <= 0) {
	                // Bloquear el programa si se agotan los intentos
	                JOptionPane.showMessageDialog(this, "Número de intentos agotado. El programa se bloqueará.", "Alerta", JOptionPane.ERROR_MESSAGE);
	                System.exit(0); // Salir del programa
	            }
	        }
	    }
	    private void regresarButtonActionPerformed(ActionEvent evt) {
	    	Sistema.AdministrativoOptionsWindow administrativoOptionsWindow = new Sistema.AdministrativoOptionsWindow(
					null);
			administrativoOptionsWindow.setVisible(true);
	    	dispose();
	    }

	    private void mostrarOpciones() {
	        JButton ingresosMensualesButton = new JButton("Ingresos Mensuales");
	        JButton gastosMensualesButton = new JButton("Gastos Mensuales");
	        JButton agregarEmpleadosButton = new JButton("Agregar Empleados");
	        JButton mostrarEmpleadosButton = new JButton("Mostrar Empleados");
	        JButton regresarButton = new JButton("Regresar");

	        ingresosMensualesButton.addActionListener(this::ingresosMensualesButtonActionPerformed);
	        gastosMensualesButton.addActionListener(this::gastosMensualesButtonActionPerformed);
	        agregarEmpleadosButton.addActionListener(this::agregarEmpleadosButtonActionPerformed);
	        mostrarEmpleadosButton.addActionListener(this::mostrarEmpleadosButtonActionPerformed);
	        regresarButton.addActionListener(this::regresarButtonActionPerformed);

	        // Establece colores para los botones
	        ingresosMensualesButton.setBackground(Color.WHITE);
	        ingresosMensualesButton.setForeground(Color.BLACK);

	        gastosMensualesButton.setBackground(Color.WHITE);
	        gastosMensualesButton.setForeground(Color.BLACK);

	        agregarEmpleadosButton.setBackground(Color.WHITE);
	        agregarEmpleadosButton.setForeground(Color.BLACK);

	        mostrarEmpleadosButton.setBackground(Color.WHITE);
	        mostrarEmpleadosButton.setForeground(Color.BLACK);

	        regresarButton.setBackground(Color.WHITE);
	        regresarButton.setForeground(Color.BLACK);

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().removeAll();
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
	                                .addGap(85, 85, 85)
	                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                                        .addComponent(ingresosMensualesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(gastosMensualesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(agregarEmpleadosButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(mostrarEmpleadosButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(regresarButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                .addContainerGap(85, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
	                                .addGap(46, 46, 46)
	                                .addComponent(ingresosMensualesButton)
	                                .addGap(18, 18, 18)
	                                .addComponent(gastosMensualesButton)
	                                .addGap(18, 18, 18)
	                                .addComponent(agregarEmpleadosButton)
	                                .addGap(18, 18, 18)
	                                .addComponent(mostrarEmpleadosButton)
	                                .addContainerGap(46, Short.MAX_VALUE)
	                                .addComponent(regresarButton)
	                                .addContainerGap(46, Short.MAX_VALUE))
	        );

	        pack();
	    }


	    	private void mostrarEmpleadosButtonActionPerformed(ActionEvent evt) {
	    		if (sistema.getEmpleadosRegistrados().isEmpty()) {
	    	        JOptionPane.showMessageDialog(this, "No hay empleados registrados", "Información", JOptionPane.INFORMATION_MESSAGE);
	    	        return;
	    	    }
	    		// Crear una ventana para mostrar la información de los empleados
	    	    JFrame frame = new JFrame("Lista de Empleados");

	    	    // Obtener la lista de empleados del sistema
	    	    List<Empleado> empleados = sistema.getEmpleadosRegistrados();

	    	    // Crear una matriz de objetos para almacenar los datos de los empleados
	    	    Object[][] data = new Object[empleados.size()][6];  // Suponemos 5 atributos para cada empleado

	    	    // Llenar la matriz con los datos de los empleados
	    	    for (int i = 0; i < empleados.size(); i++) {
	    	        Empleado empleado = empleados.get(i);
	    	        data[i][0] = empleado.getId();
	    	        data[i][1] = empleado.getNombre();
	    	        data[i][2] = empleado.getTipo();	
	    	        data[i][3] = (empleado instanceof Diseñador) ? 
	    	                ((Diseñador) empleado).getCantidadDiseños() : 
	    	                (empleado instanceof Produccion) ? 
	    	                ((Produccion) empleado).getCantidadEnsamblajes() : "";
	    	        data[i][4] = (empleado instanceof Diseñador) ? ((Diseñador) empleado).getComisionPorDiseño() : 
	    	              (empleado instanceof Produccion) ? ((Produccion) empleado).getComisionPorEnsamblaje() : "";    	           	        
	    	        data[i][5] = (empleado instanceof Diseñador) ? 
	    	                ((Diseñador) empleado).getComisionPorDiseño() * ((Diseñador) empleado).getCantidadDiseños() :
	    	                (empleado instanceof Produccion) ? 
	    	                ((Produccion) empleado).getComisionPorEnsamblaje() * ((Produccion) empleado).getCantidadEnsamblajes() : "";
	    	    }

	    	    // Nombres de las columnas
	    	    String[] columnNames = {"ID", "Nombre","Tipo","Cantidad Diseños/Ensamblajes", "Comisión", "Sueldo"};

	    	    // Crear el JTable con los datos y nombres de columnas
	    	    JTable table = new JTable(data, columnNames);

	    	    // Agregar el JTable a un JScrollPane para permitir el desplazamiento si hay muchos empleados
	    	    JScrollPane scrollPane = new JScrollPane(table);

	    	    // Agregar el JScrollPane al contenido del marco
	    	    frame.getContentPane().add(scrollPane);

	    	    // Configuración básica del marco
	    	    frame.setSize(600, 300);
	    	    frame.setLocationRelativeTo(null);  // Centrar en la pantalla
	    	    frame.setVisible(true);
	    	}

	    	

	    private void ingresosMensualesButtonActionPerformed(ActionEvent evt) {
	        // Obtener el precio total del carrito
	        CarritoDeCompras carrito = new CarritoDeCompras();
	        double precioTotal = carrito.getPrecioTotal();
	        
	        // Mostrar el precio total como ingresos mensuales en el cuadro de diálogo
	        JOptionPane.showMessageDialog(this, "Ingresos mensuales: " + precioTotal, "Ingresos Mensuales", JOptionPane.INFORMATION_MESSAGE);
	    }

	    private void gastosMensualesButtonActionPerformed(ActionEvent evt) {
	        // Pedir al usuario que ingrese el valor de los gastos mensuales
	        String gastosMensualesStr = JOptionPane.showInputDialog(this, "Ingrese el valor de los gastos mensuales:");
	        
	        // Verificar si se canceló la entrada de datos
	        if (gastosMensualesStr == null || gastosMensualesStr.isEmpty()) {
	            return; // Se canceló la operación
	        }
	        
	        // Convertir el valor ingresado a un número
	        double gastosMensuales = 0;
	        try {
	            gastosMensuales = Double.parseDouble(gastosMensualesStr);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "El valor ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        
	        // Aquí puedes hacer lo que quieras con el valor de los gastos mensuales, como guardarlo en una variable o realizar algún cálculo
	        
	        // Mostrar el mensaje de los gastos mensuales
	        JOptionPane.showMessageDialog(this, "Los gastos mensuales son: "+ gastosMensuales, "Gastos Mensuales", JOptionPane.INFORMATION_MESSAGE);
	    }

	    private void agregarEmpleadosButtonActionPerformed(ActionEvent evt) {
	        // Lógica para agregar empleados
	        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del empleado:");
	        String id = JOptionPane.showInputDialog(this, "Ingrese la ID del empleado:");

	        if (!sistema.existeEmpleado(id)) {  // Verificar si NO existe el empleado con esa ID
	            // Si el empleado no existe, puedes mostrar otro cuadro de diálogo para elegir el tipo de empleado a agregar
	            // Por ejemplo:
	            String[] opciones = {"Diseñador", "Producción"};
	            String tipoEmpleado = (String) JOptionPane.showInputDialog(this, "Seleccione el tipo de empleado:",
	                    "Tipo de Empleado", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

	            if (tipoEmpleado != null) {
	                Empleado nuevoEmpleado;
	                switch (tipoEmpleado) {
	                    case "Diseñador":
	                        nuevoEmpleado = crearDiseñador(nombre, id);
	                        break;
	                    case "Producción":
	                        nuevoEmpleado = crearProduccion(nombre, id);
	                        break;
	                    default:
	                        nuevoEmpleado = null;
	                        break;
	                }

	                if (nuevoEmpleado != null) {
	                    sistema.agregarEmpleado(nuevoEmpleado);
	                    JOptionPane.showMessageDialog(this, "Empleado agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(this, "Tipo de empleado no válido.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(this, "Ya existe un empleado con esa ID.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }


	private Diseñador crearDiseñador(String nombre, String id) {
    // Lógica para obtener más información o parámetros específicos para un Diseñador
    return new Diseñador(nombre, id, 0, 0);
	}

	private Produccion crearProduccion(String nombre, String id) {
    // Lógica para obtener más información o parámetros específicos para un Empleado de Producción
    return new Produccion(nombre, id, 0, 0);
	}
	
	public String getEnteredID() {
	    return enteredID;
	}
	
}

public class EmpleadoWindow extends VentanaBase {

    private Sistema sistema;
    private JTextField idTextField;
    private DefaultListModel<String> productosListModel;

    public EmpleadoWindow(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
    }

    private void initComponents() {
        JLabel idLabel = new JLabel("Ingrese el ID:");
        idTextField = new JTextField(10);

        // Cambia el color del borde de la ventana a negro
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 51, 102));

        JPanel franjaPanel = new JPanel();
        franjaPanel.setBackground(Color.WHITE);
        franjaPanel.setPreferredSize(new Dimension(80, getHeight()));

        JButton mostrarProductosButton = new JButton("Mostrar Productos");
        JButton regresarButton = new JButton("Regresar"); // Botón Regresar

        // Establece colores para los componentes
        idLabel.setForeground(Color.WHITE);
        idTextField.setBackground(Color.WHITE);
        idTextField.setForeground(Color.BLACK); // Cambia el color del texto a negro
        mostrarProductosButton.setBackground(Color.WHITE);
        mostrarProductosButton.setForeground(Color.BLACK); // Cambia el color del texto a negro
        regresarButton.setBackground(Color.WHITE);
        regresarButton.setForeground(Color.BLACK); // Cambia el color del texto a negro

        mostrarProductosButton.addActionListener(this::mostrarProductosButtonActionPerformed);
        regresarButton.addActionListener(this::regresarButtonActionPerformed); // Método para el botón "Regresar"

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(idLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(idTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(mostrarProductosButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(regresarButton)))
                                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(idLabel)
                                        .addComponent(idTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(mostrarProductosButton)
                                        .addComponent(regresarButton))
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }

    private void mostrarProductosButtonActionPerformed(ActionEvent evt) {
        String enteredID = idTextField.getText();
        if (sistema.existeEmpleado(enteredID)) {
            List<Producto> productosComprados = sistema.getProductosComprados(enteredID);
            mostrarProductos(productosComprados);
        } else {
            JOptionPane.showMessageDialog(this, "El ID ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarProductos(List<Producto> productosComprados) {
        productosListModel.clear();
        for (Producto producto : productosComprados) {
            productosListModel.addElement(producto.getNombre());
        }
    }

    private void regresarButtonActionPerformed(ActionEvent evt) {
        Sistema.AdministrativoOptionsWindow administrativoOptionsWindow = new Sistema.AdministrativoOptionsWindow(null);
		administrativoOptionsWindow.setVisible(true);
    	dispose();
    }
}


class ClienteOptionsWindow extends VentanaBase {

    private Sistema sistema;

    public ClienteOptionsWindow(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
    }

    private void initComponents() {
        JButton iniciarSesionButton = new JButton("Iniciar Sesión");
        JButton registrarseButton = new JButton("Registrarse");
        JButton regresarButton = new JButton("Regresar");
        
        // Cambia el color del borde de la ventana a negro
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 51, 102));

        JPanel franjaPanel = new JPanel();
        franjaPanel.setBackground(Color.WHITE);
        franjaPanel.setPreferredSize(new Dimension(80, getHeight()));

        // Establece colores para los componentes
        iniciarSesionButton.setBackground(Color.WHITE);
        iniciarSesionButton.setForeground(Color.BLACK); // Cambia el color del texto a negro
        registrarseButton.setBackground(Color.WHITE);
        registrarseButton.setForeground(Color.BLACK); // Cambia el color del texto a negro
        regresarButton.setBackground(Color.WHITE);
        regresarButton.setForeground(Color.BLACK); // Cambia el color del texto a negro

        iniciarSesionButton.addActionListener(this::iniciarSesionButtonActionPerformed);
        registrarseButton.addActionListener(this::registrarseButtonActionPerformed);
        regresarButton.addActionListener(this::regresarButtonActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(iniciarSesionButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(registrarseButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(regresarButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(iniciarSesionButton)
                                .addGap(18, 18, 18)
                                .addComponent(registrarseButton)
                                .addGap(18, 18, 18)
                                .addComponent(regresarButton)
                                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }

    private void iniciarSesionButtonActionPerformed(ActionEvent evt) {
        ClienteLoginWindow loginWindow = new ClienteLoginWindow(sistema);
        loginWindow.setVisible(true);
        this.dispose();
    }

    private void registrarseButtonActionPerformed(ActionEvent evt) {
        ClienteRegistroWindow registroWindow = new ClienteRegistroWindow(sistema);
        registroWindow.setVisible(true);
        this.dispose();
    }
    
    private void regresarButtonActionPerformed(ActionEvent evt) {   // ESTO
        Sistema sistema2 = new Sistema();
		sistema2.setVisible(true);
        this.dispose();
    }
}
class ProductosUtil {
    public static List<String> obtenerListaProductos() {
        return List.of(
                "Lampara de acrílico",
                "Recuerdos de acrílico",
                "Recuerdos de mdf",
                "Llaveros",
                "Alcancías",
                "Libretas",
                "Portarretratos",
                "Cajas en forma de letras",
                "Cajas personalizadas"
        );
    }
}
class ClienteLoginWindow extends VentanaBase {
    private Sistema sistema;
    private JTextField correoTextField;
    private JPasswordField passwordField;

    public ClienteLoginWindow(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
    }

    private void initComponents() {
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 51, 102));

        JLabel correoLabel = new JLabel("Correo:");
        JLabel passwordLabel = new JLabel("Contraseña:");
        JButton regresarButton = new JButton("Regresar");

        correoTextField = new JTextField();
        passwordField = new JPasswordField();

        JButton iniciarSesionButton = new JButton("Iniciar Sesión");

        // Establece colores para los componentes
        correoLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        regresarButton.setBackground(Color.WHITE);
        regresarButton.setForeground(new Color(0, 51, 102)); // Cambia el color del texto a azul oscuro
        iniciarSesionButton.setBackground(Color.WHITE);
        iniciarSesionButton.setForeground(new Color(0, 51, 102)); // Cambia el color del texto a azul oscuro

        iniciarSesionButton.addActionListener(this::iniciarSesionButtonActionPerformed);
        regresarButton.addActionListener(this::regresarButtonActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(correoLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(correoTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(passwordLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(iniciarSesionButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(regresarButton)))
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(correoLabel)
                                        .addComponent(correoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(iniciarSesionButton)
                                        .addComponent(regresarButton))
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().setPreferredSize(new Dimension(400, 200));
        pack();
    }


    private void iniciarSesionButtonActionPerformed(ActionEvent evt) {
        String correo = getCorreo();
        String password = getPassword();
        if (correo.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            Cliente clienteEncontrado = buscarClientePorCorreo(correo);
            if (clienteEncontrado != null && clienteEncontrado.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
                Sistema.VentanaCatalogo ventanaCatalogo = new Sistema.VentanaCatalogo();
				ventanaCatalogo.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private Cliente buscarClientePorCorreo(String correo) {
        for (Cliente cliente : sistema.getClientesRegistrados()) {
            if (cliente.getCorreo().equals(correo)) {
                return cliente;
            }
        }
        return null;
    }
    

    public String getCorreo() {
        return correoTextField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }
    
    private void regresarButtonActionPerformed(ActionEvent evt) {   // ESTO
        Sistema sistema2 = new Sistema();
		sistema2.setVisible(true);
        this.dispose();
    }
}

public class VentanaCatalogo extends JFrame {

    public VentanaCatalogo() {
        super("Catálogo de Productos");
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 3));

        List<String> listaProductos = obtenerListaProductos();
        JButton[] botones = new JButton[listaProductos.size()];

        for (int i = 0; i < listaProductos.size(); i++) {
            String producto = listaProductos.get(i);
            JButton button = new JButton(producto);
            button.setBackground(Color.WHITE);
            button.setForeground(Color.BLACK);

            // Agregar un borde negro
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            button.setBorder(border);

            button.addActionListener(new BotonCatalogoListener(producto, this));
            this.add(button);
        }
    }

    private List<String> obtenerListaProductos() {
        return List.of(
                "Lampara de acrílico",
                "Recuerdos de acrílico",
                "Recuerdos de mdf",
                "Llaveros",
                "Alcancías",
                "Libretas",
                "Portarretratos",
                "Cajas en forma de letras",
                "Cajas personalizadas"
        );
    }

    private class BotonCatalogoListener implements ActionListener {
        private String producto;
        private JFrame catalogoFrame;

        public BotonCatalogoListener(String producto, JFrame catalogoFrame) {
            this.producto = producto;
            this.catalogoFrame = catalogoFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (producto) {
                case "Lampara de acrílico" -> mostrarVentanaLamparaAcrilico();
                case "Recuerdos de acrílico" -> mostrarVentanaRecuerdoAcrilico();
                case "Recuerdos de mdf" -> mostrarVentanaRecuerdoMDF();
                case "Llaveros" -> mostrarVentanaLlaveros();
                case "Alcancías" -> mostrarVentanaAlcancia();
                case "Libretas" -> mostrarVentanaLibretas();
                case "Portarretratos" -> mostrarVentanaPortarretratos();
                case "Cajas en forma de letras" -> mostrarVentanaCajasLetras();
                case "Cajas personalizadas" -> mostrarVentanaCajasPersonalizadas();
                default -> JOptionPane.showMessageDialog(null, "Has seleccionado: " + producto);
            }
        }

        private void mostrarVentanaLamparaAcrilico() {
            VentanaLamparaAcrilico ventanaLamparaAcrilico = new VentanaLamparaAcrilico();
            ventanaLamparaAcrilico.setVisible(true);
            catalogoFrame.dispose();
        }

        private void mostrarVentanaRecuerdoAcrilico() {
            VentanaRecuerdoAcrilico ventanaRecuerdoAcrilico = new VentanaRecuerdoAcrilico();
            ventanaRecuerdoAcrilico.setVisible(true);
            catalogoFrame.dispose();
        }

        private void mostrarVentanaRecuerdoMDF() {
            VentanaRecuerdoMDF ventanaRecuerdoMDF = new VentanaRecuerdoMDF();
            ventanaRecuerdoMDF.setVisible(true);
            catalogoFrame.dispose();
        }

        private void mostrarVentanaLlaveros() {
            VentanaLlaveros ventanaLlaveros = new VentanaLlaveros();
            ventanaLlaveros.setVisible(true);
            catalogoFrame.dispose();
        }

        private void mostrarVentanaAlcancia() {
            VentanaAlcancia ventanaAlcancia = new VentanaAlcancia();
            ventanaAlcancia.setVisible(true);
            catalogoFrame.dispose();
        }

        private void mostrarVentanaLibretas() {
            VentanaLibretas ventanaLibretas = new VentanaLibretas();
            ventanaLibretas.setVisible(true);
            catalogoFrame.dispose();
        }

        private void mostrarVentanaPortarretratos() {
            VentanaPortarretratos ventanaPortarretratos = new VentanaPortarretratos();
            ventanaPortarretratos.setVisible(true);
            catalogoFrame.dispose();
        }

        private void mostrarVentanaCajasLetras() {
            VentanaCajasLetras ventanaCajasLetras = new VentanaCajasLetras();
            ventanaCajasLetras.setVisible(true);
            catalogoFrame.dispose();
        }

        private void mostrarVentanaCajasPersonalizadas() {
            VentanaCajasPersonalizadas ventanaCajasPersonalizadas = new VentanaCajasPersonalizadas();
            ventanaCajasPersonalizadas.setVisible(true);
            catalogoFrame.dispose();
        }
    }

    public class Main {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Sistema sistema = new Sistema(); // Asegúrate de tener esta instancia
                    sistema.setVisible(true);
                }
            });
        }
    }

}

public class VentanaLamparaAcrilico extends JFrame {
    private CarritoDeCompras carrito;

    public VentanaLamparaAcrilico() {
        super("Lámpara de Acrílico");
        this.setSize(900, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 51, 102)); // Establecer color de fondo del contenedor principal

        carrito = new CarritoDeCompras();

        // Crear el panel de botones en la parte superior derecha
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonMenuPrincipal = new JButton("Menú Principal");
        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema sistema2 = new Sistema();
                sistema2.setVisible(true);
                dispose();
            }
        });
        menuPanel.add(botonMenuPrincipal);
        this.add(menuPanel, BorderLayout.NORTH); // Agregar el panel de botones en la parte norte

        // Crear el panel central con las lámparas
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel central

        // Spiderman
        JLabel labelSpiderman = createImageLabel("media/lamparaSpiderman.jpg");
        JButton botonSpiderman = createAddToCartButton("Lampara Spiderman", 20.0);
        centralPanel.add(createImagePanelWithButton(labelSpiderman, botonSpiderman));
        centralPanel.add(Box.createVerticalStrut(10));

        // Logo
        JLabel labelLogo = createImageLabel("media/lamparaLogo.jpg");
        JButton botonLogo = createAddToCartButton("Lampara Logo", 20.0);
        centralPanel.add(createImagePanelWithButton(labelLogo, botonLogo));
        centralPanel.add(Box.createVerticalStrut(10));

        // Corazones
        JLabel labelCorazones = createImageLabel("media/lamparaCorazones.jpg");
        JButton botonCorazones = createAddToCartButton("Lampara Corazones", 20.0);
        centralPanel.add(createImagePanelWithButton(labelCorazones, botonCorazones));

        JScrollPane scrollPane = new JScrollPane(centralPanel); // Agregar un JScrollPane para manejar el desplazamiento si es necesario
        this.add(scrollPane, BorderLayout.CENTER); // Agregar el panel central en el centro

        // Crear el panel de botones en la parte inferior
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel de botones

        JButton botonPagar = new JButton("Ver carrito");
        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.mostrarCarrito();
            }
        });
        buttonsPanel.add(botonPagar);

        JButton botonMenu = new JButton("Menú");
        botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema.VentanaCatalogo ventanaCatalogo = new Sistema.VentanaCatalogo();
                ventanaCatalogo.setVisible(true);
                dispose();
            }
        });
        buttonsPanel.add(botonMenu);

        bottomPanel.add(buttonsPanel, BorderLayout.CENTER);

        this.add(bottomPanel, BorderLayout.SOUTH); // Agregar el panel de botones en la parte sur
    }

    private JLabel createImageLabel(String imagePath) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel("", JLabel.CENTER);
        label.setMaximumSize(new Dimension(200, 200));
        label.setIcon(scaledIcon);

        return label;
    }

    private JButton createAddToCartButton(String nombre, double precio) {
        JButton button = new JButton("Añadir al carrito");

        // Establecer el fondo y el color del texto explícitamente
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.agregarProducto(new Producto(nombre, precio));
                System.out.println(nombre + " añadido al carrito");
            }
        });

        return button;
    }

    private JPanel createImagePanelWithButton(JLabel imageLabel, JButton addToCartButton) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 51, 102));  // Establecer color de fondo del panel

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(addToCartButton);
        panel.add(Box.createHorizontalStrut(10)); // Espacio entre el botón y la imagen
        panel.add(imageLabel);

        return panel;
    }
}

public class VentanaRecuerdoAcrilico extends JFrame {
    private CarritoDeCompras carrito;

    public VentanaRecuerdoAcrilico() {
        super("Recuerdos de acrílico");
        this.setSize(900, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0, 51, 102)); // Establecer color de fondo del contenedor principal
        this.setLayout(new BorderLayout());

        carrito = new CarritoDeCompras();

        // Crear el panel de botones en la parte superior derecha
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonMenuPrincipal = new JButton("Menú Principal");
        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema sistema2 = new Sistema();
                sistema2.setVisible(true);
                dispose();
            }
        });
        menuPanel.add(botonMenuPrincipal);
        this.add(menuPanel, BorderLayout.NORTH); // Agregar el panel de botones en la parte norte

        // Crear el panel central con las lámparas
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel central

        // Crear los elementos de la ventana
        JLabel labelBautizo = createImageLabel("media/recuerdoBautizo.jpg");
        JButton botonBautizo = createAddToCartButton("Recuerdo de Bautizo", 3.0);
        centralPanel.add(createImagePanelWithButton(labelBautizo, botonBautizo));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelBoda = createImageLabel("media/recuerdoBoda.jpg");
        JButton botonBoda = createAddToCartButton("Recuerdo de Boda", 3.0);
        centralPanel.add(createImagePanelWithButton(labelBoda, botonBoda));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelGrado = createImageLabel("media/recuerdoGrado.jpg");
        JButton botonGrado = createAddToCartButton("Recuerdo de Grado", 3.0);
        centralPanel.add(createImagePanelWithButton(labelGrado, botonGrado));

        JScrollPane scrollPane = new JScrollPane(centralPanel); // Agregar un JScrollPane para manejar el desplazamiento si es necesario
        this.add(scrollPane, BorderLayout.CENTER); // Agregar el panel central en el centro

        // Crear el panel de botones en la parte inferior
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel de botones

        JButton botonPagar = new JButton("Ver carrito");
        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.mostrarCarrito();
            }
        });
        buttonsPanel.add(botonPagar);

        JButton botonMenu = new JButton("Menú");
        botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema.VentanaCatalogo ventanaCatalogo = new Sistema.VentanaCatalogo();
                ventanaCatalogo.setVisible(true);
                dispose();
            }
        });
        buttonsPanel.add(botonMenu);

        bottomPanel.add(buttonsPanel, BorderLayout.CENTER);

        this.add(bottomPanel, BorderLayout.SOUTH); // Agregar el panel de botones en la parte sur
    }

    private JLabel createImageLabel(String imagePath) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel("", JLabel.CENTER);
        label.setMaximumSize(new Dimension(200, 200));
        label.setIcon(scaledIcon);

        return label;
    }

    private JButton createAddToCartButton(String nombre, double precio) {
        JButton button = new JButton("Añadir al carrito");

        // Establecer el fondo y el color del texto explícitamente
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.agregarProducto(new Producto(nombre, precio));
                System.out.println(nombre + " añadido al carrito");
            }
        });

        return button;
    }

    private JPanel createImagePanelWithButton(JLabel imageLabel, JButton addToCartButton) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 51, 102));  // Establecer color de fondo del panel

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(addToCartButton);
        panel.add(Box.createHorizontalStrut(10)); // Espacio entre el botón y la imagen
        panel.add(imageLabel);

        return panel;
    }
}

public class VentanaRecuerdoMDF extends JFrame {
    private CarritoDeCompras carrito;

    public VentanaRecuerdoMDF() {
        super("Recuerdos de MDF");
        this.setSize(900, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0, 51, 102)); // Establecer color de fondo del contenedor principal
        this.setLayout(new BorderLayout());

        carrito = new CarritoDeCompras();

        // Crear el panel de botones en la parte superior derecha
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonMenuPrincipal = new JButton("Menú Principal");
        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema sistema2 = new Sistema();
                sistema2.setVisible(true);
                dispose();
            }
        });
        menuPanel.add(botonMenuPrincipal);
        this.add(menuPanel, BorderLayout.NORTH); // Agregar el panel de botones en la parte norte

        // Crear el panel central con los recuerdos de MDF
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel central

        // Crear los elementos de la ventana
        JLabel labelBautizoMDF = createImageLabel("media/recuerdoBautizoMDF.jpg");
        JButton botonBautizoMDF = createAddToCartButton("Recuerdo de Bautizo MDF", 2.0);
        centralPanel.add(createImagePanelWithButton(labelBautizoMDF, botonBautizoMDF));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelBodaMDF = createImageLabel("media/recuerdoBodaMDF.jpg");
        JButton botonBodaMDF = createAddToCartButton("Recuerdo de Boda MDF", 2.0);
        centralPanel.add(createImagePanelWithButton(labelBodaMDF, botonBodaMDF));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelGradoMDF = createImageLabel("media/recuerdoGradoMDF.jpg");
        JButton botonGradoMDF = createAddToCartButton("Recuerdo de Grado MDF", 2.0);
        centralPanel.add(createImagePanelWithButton(labelGradoMDF, botonGradoMDF));

        JScrollPane scrollPane = new JScrollPane(centralPanel); // Agregar un JScrollPane para manejar el desplazamiento si es necesario
        this.add(scrollPane, BorderLayout.CENTER); // Agregar el panel central en el centro

        // Crear el panel de botones en la parte inferior
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel de botones

        JButton botonPagar = new JButton("Ver carrito");
        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.mostrarCarrito();
            }
        });
        buttonsPanel.add(botonPagar);

        JButton botonMenu = new JButton("Menú");
        botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema.VentanaCatalogo ventanaCatalogo = new Sistema.VentanaCatalogo();
                ventanaCatalogo.setVisible(true);
                dispose();
            }
        });
        buttonsPanel.add(botonMenu);

        bottomPanel.add(buttonsPanel, BorderLayout.CENTER);

        this.add(bottomPanel, BorderLayout.SOUTH); // Agregar el panel de botones en la parte sur
    }

    private JLabel createImageLabel(String imagePath) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel("", JLabel.CENTER);
        label.setMaximumSize(new Dimension(200, 200));
        label.setIcon(scaledIcon);

        return label;
    }

    private JButton createAddToCartButton(String nombre, double precio) {
        JButton button = new JButton("Añadir al carrito");

        // Establecer el fondo y el color del texto explícitamente
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.agregarProducto(new Producto(nombre, precio));
                System.out.println(nombre + " añadido al carrito");
            }
        });

        return button;
    }

    private JPanel createImagePanelWithButton(JLabel imageLabel, JButton addToCartButton) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 51, 102));  // Establecer color de fondo del panel

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(addToCartButton);
        panel.add(Box.createHorizontalStrut(10)); // Espacio entre el botón y la imagen
        panel.add(imageLabel);

        return panel;
    }
}

public class VentanaLlaveros extends JFrame {
    private CarritoDeCompras carrito;

    public VentanaLlaveros() {
        super("Llaveros");
        this.setSize(900, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0, 51, 102));
        this.setLayout(new BorderLayout()); // Cambiar el layout a BorderLayout para organizar los elementos más fácilmente

        carrito = new CarritoDeCompras();

        // Crear el panel de botones en la parte superior derecha
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonMenuPrincipal = new JButton("Menú Principal");
        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema sistema2 = new Sistema();
                sistema2.setVisible(true);
                dispose();
            }
        });
        menuPanel.add(botonMenuPrincipal);
        this.add(menuPanel, BorderLayout.NORTH); // Agregar el panel de botones en la parte norte

        // Crear el panel central con los llaveros
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel central

        // Crear los elementos de la ventana
        JLabel labelPokemon = createImageLabel("media/llaveroPokemon.jpg");
        JButton botonPokemon = createAddToCartButton("Llaveros Pokemon", 2.0);
        centralPanel.add(createImagePanelWithButton(labelPokemon, botonPokemon));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelAmigos= createImageLabel("media/llaveroAmigos.jpg");
        JButton botonAmigos = createAddToCartButton("Llaveros Amigos", 2.0);
        centralPanel.add(createImagePanelWithButton(labelAmigos, botonAmigos));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelVirgen = createImageLabel("media/llaveroVirgen.jpg");
        JButton botonVirgen = createAddToCartButton("Llavero Virgen", 2.0);
        centralPanel.add(createImagePanelWithButton(labelVirgen, botonVirgen));

        JScrollPane scrollPane = new JScrollPane(centralPanel); // Agregar un JScrollPane para manejar el desplazamiento si es necesario
        this.add(scrollPane, BorderLayout.CENTER); // Agregar el panel central en el centro

        // Crear el panel de botones en la parte inferior
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel de botones

        JButton botonPagar = new JButton("Ver carrito");
        botonPagar.setBackground(Color.WHITE);
        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.mostrarCarrito();
            }
        });
        bottomPanel.add(botonPagar);

        JButton botonMenu = new JButton("Menú");
        botonMenu.setBackground(Color.WHITE);
        botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema.VentanaCatalogo ventanaCatalogo = new Sistema.VentanaCatalogo();
                ventanaCatalogo.setVisible(true);
                dispose();
            }
        });
        bottomPanel.add(botonMenu);

        this.add(bottomPanel, BorderLayout.SOUTH); // Agregar el panel de botones en la parte sur
    }

    private JLabel createImageLabel(String imagePath) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel("", JLabel.CENTER);
        label.setMaximumSize(new Dimension(200, 200));
        label.setIcon(scaledIcon);

        return label;
    }

    private JButton createAddToCartButton(String nombre, double precio) {
        JButton button = new JButton("Añadir al carrito");

        // Establecer el fondo y el color del texto explícitamente
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.agregarProducto(new Producto(nombre, precio));
                System.out.println(nombre + " añadido al carrito");
            }
        });

        return button;
    }

    private JPanel createImagePanelWithButton(JLabel imageLabel, JButton addToCartButton) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 51, 102));  // Establecer color de fondo del panel

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(addToCartButton);
        panel.add(Box.createHorizontalStrut(10)); // Espacio entre el botón y la imagen
        panel.add(imageLabel);

        return panel;
    }
}

public class VentanaAlcancia extends JFrame {
    private CarritoDeCompras carrito;

    public VentanaAlcancia() {
        super("Alcancías");
        this.setSize(900, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout()); // Cambiar el layout a BorderLayout para organizar los elementos más fácilmente
        this.getContentPane().setBackground(new Color(0, 51, 102));

        carrito = new CarritoDeCompras();

        // Crear el panel de botones en la parte superior derecha
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonMenuPrincipal = new JButton("Menú Principal");
        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema sistema2 = new Sistema();
                sistema2.setVisible(true);
                dispose();
            }
        });
        menuPanel.add(botonMenuPrincipal);
        this.add(menuPanel, BorderLayout.NORTH); // Agregar el panel de botones en la parte norte

        // Crear el panel central con las alcancías
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel central

        // Crear los elementos de la ventana
        JLabel labelGato = createImageLabel("media/alcanciaGato.jpg");
        JButton botonGato = createAddToCartButton("Alcancía de Gato", 12.0);
        centralPanel.add(createImagePanelWithButton(labelGato, botonGato));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelJuego = createImageLabel("media/alcanciaJuego.jpg");
        JButton botonJuego = createAddToCartButton("Alcancía de la Suerte", 10.0);
        centralPanel.add(createImagePanelWithButton(labelJuego, botonJuego));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelSencilla = createImageLabel("media/alcanciaSencilla.jpg");
        JButton botonSencilla = createAddToCartButton("Alcancia con acrílico", 5.0);
        centralPanel.add(createImagePanelWithButton(labelSencilla, botonSencilla));

        JScrollPane scrollPane = new JScrollPane(centralPanel); // Agregar un JScrollPane para manejar el desplazamiento si es necesario
        this.add(scrollPane, BorderLayout.CENTER); // Agregar el panel central en el centro

        // Crear el panel de botones en la parte inferior
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel de botones

        JButton botonPagar = new JButton("Ver carrito");
        botonPagar.setBackground(Color.WHITE);
        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.mostrarCarrito();
            }
        });
        bottomPanel.add(botonPagar);

        JButton botonMenu = new JButton("Menú");
        botonMenu.setBackground(Color.WHITE);
        botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema.VentanaCatalogo ventanaCatalogo = new Sistema.VentanaCatalogo();
                ventanaCatalogo.setVisible(true);
                dispose();
            }
        });
        bottomPanel.add(botonMenu);

        this.add(bottomPanel, BorderLayout.SOUTH); // Agregar el panel de botones en la parte sur
    }

    private JLabel createImageLabel(String imagePath) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel("", JLabel.CENTER);
        label.setMaximumSize(new Dimension(200, 200));
        label.setIcon(scaledIcon);

        return label;
    }

    private JButton createAddToCartButton(String nombre, double precio) {
        JButton button = new JButton("Añadir al carrito");

        // Establecer el fondo y el color del texto explícitamente
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.agregarProducto(new Producto(nombre, precio));
                System.out.println(nombre + " añadido al carrito");
            }
        });

        return button;
    }

    private JPanel createImagePanelWithButton(JLabel imageLabel, JButton addToCartButton) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 51, 102));  // Establecer color de fondo del panel

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(addToCartButton);
        panel.add(Box.createHorizontalStrut(10)); // Espacio entre el botón y la imagen
        panel.add(imageLabel);

        return panel;
    }
}
public class VentanaLibretas extends JFrame {
    private CarritoDeCompras carrito;

    public VentanaLibretas() {
        super("Libretas");
        this.setSize(900, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout()); // Cambiar el layout a BorderLayout para organizar los elementos más fácilmente
        this.getContentPane().setBackground(new Color(0, 51, 102));

        carrito = new CarritoDeCompras();

        // Crear el panel de botones en la parte superior derecha
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonMenuPrincipal = new JButton("Menú Principal");
        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema sistema2 = new Sistema();
                sistema2.setVisible(true);
                dispose();
            }
        });
        menuPanel.add(botonMenuPrincipal);
        this.add(menuPanel, BorderLayout.NORTH); // Agregar el panel de botones en la parte norte

        // Crear el panel central con las libretas
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel central

        // Crear los elementos de la ventana
        JLabel labelBreaking = createImageLabel("media/libretaBreaking.jpg");
        JButton botonBreaking = createAddToCartButton("Libreta Breaking Bad", 10.0);
        centralPanel.add(createImagePanelWithButton(labelBreaking, botonBreaking));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelCitas = createImageLabel("media/libretaCitas.jpg");
        JButton botonCitas = createAddToCartButton("Libreta 100 Citas", 10.0);
        centralPanel.add(createImagePanelWithButton(labelCitas, botonCitas));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelSimpsons = createImageLabel("media/libretaSimpsons.jpg");
        JButton botonSimpsons = createAddToCartButton("Libreta Simpsons", 10.0);
        centralPanel.add(createImagePanelWithButton(labelSimpsons, botonSimpsons));

        JScrollPane scrollPane = new JScrollPane(centralPanel); // Agregar un JScrollPane para manejar el desplazamiento si es necesario
        this.add(scrollPane, BorderLayout.CENTER); // Agregar el panel central en el centro

        // Crear el panel de botones en la parte inferior
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel de botones

        JButton botonPagar = new JButton("Ver carrito");
        botonPagar.setBackground(Color.WHITE);
        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.mostrarCarrito();
            }
        });
        bottomPanel.add(botonPagar);

        JButton botonMenu = new JButton("Menú");
        botonMenu.setBackground(Color.WHITE);
        botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema.VentanaCatalogo ventanaCatalogo = new Sistema.VentanaCatalogo();
                ventanaCatalogo.setVisible(true);
                dispose();
            }
        });
        bottomPanel.add(botonMenu);

        this.add(bottomPanel, BorderLayout.SOUTH); // Agregar el panel de botones en la parte sur
    }

    private JLabel createImageLabel(String imagePath) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel("", JLabel.CENTER);
        label.setMaximumSize(new Dimension(200, 200));
        label.setIcon(scaledIcon);

        return label;
    }

    private JButton createAddToCartButton(String nombre, double precio) {
        JButton button = new JButton("Añadir al carrito");

        // Establecer el fondo y el color del texto explícitamente
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.agregarProducto(new Producto(nombre, precio));
                System.out.println(nombre + " añadido al carrito");
            }
        });

        return button;
    }

    private JPanel createImagePanelWithButton(JLabel imageLabel, JButton addToCartButton) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 51, 102));  // Establecer color de fondo del panel

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(addToCartButton);
        panel.add(Box.createHorizontalStrut(10)); // Espacio entre el botón y la imagen
        panel.add(imageLabel);

        return panel;
    }
}

public class VentanaPortarretratos extends JFrame {
    private CarritoDeCompras carrito;

    public VentanaPortarretratos() {
        super("Portarretratos");
        this.setSize(900, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0, 51, 102));
        this.setLayout(new BorderLayout()); // Cambiar el layout a BorderLayout para organizar los elementos más fácilmente

        carrito = new CarritoDeCompras();

        // Crear el panel de botones en la parte superior derecha
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonMenuPrincipal = new JButton("Menú Principal");
        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema sistema2 = new Sistema();
                sistema2.setVisible(true);
                dispose();
            }
        });
        menuPanel.add(botonMenuPrincipal);
        this.add(menuPanel, BorderLayout.NORTH); // Agregar el panel de botones en la parte norte

        // Crear el panel central con los portarretratos
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel central

        // Crear los elementos de la ventana
        JLabel labelLove = createImageLabel("media/portaLove.jpg");
        JButton botonLove = createAddToCartButton("Portarretrato Love", 5.0);
        centralPanel.add(createImagePanelWithButton(labelLove, botonLove));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelPapa = createImageLabel("media/portaPapa.jpg");
        JButton botonPapa = createAddToCartButton("Portarretrato día del padre", 15.0);
        centralPanel.add(createImagePanelWithButton(labelPapa, botonPapa));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelPareja = createImageLabel("media/portaPareja.jpg");
        JButton botonPareja = createAddToCartButton("Portarretrato para pareja", 15.0);
        centralPanel.add(createImagePanelWithButton(labelPareja, botonPareja));

        JScrollPane scrollPane = new JScrollPane(centralPanel); // Agregar un JScrollPane para manejar el desplazamiento si es necesario
        this.add(scrollPane, BorderLayout.CENTER); // Agregar el panel central en el centro

        // Crear el panel de botones en la parte inferior
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel de botones

        JButton botonPagar = new JButton("Ver carrito");
        botonPagar.setBackground(Color.WHITE);
        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.mostrarCarrito();
            }
        });
        bottomPanel.add(botonPagar);

        JButton botonMenu = new JButton("Menú");
        botonMenu.setBackground(Color.WHITE);
        botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema.VentanaCatalogo ventanaCatalogo = new Sistema.VentanaCatalogo();
                ventanaCatalogo.setVisible(true);
                dispose();
            }
        });
        bottomPanel.add(botonMenu);

        this.add(bottomPanel, BorderLayout.SOUTH); // Agregar el panel de botones en la parte sur
    }

    private JLabel createImageLabel(String imagePath) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel("", JLabel.CENTER);
        label.setMaximumSize(new Dimension(200, 200));
        label.setIcon(scaledIcon);

        return label;
    }

    private JButton createAddToCartButton(String nombre, double precio) {
        JButton button = new JButton("Añadir al carrito");

        // Establecer el fondo y el color del texto explícitamente
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.agregarProducto(new Producto(nombre, precio));
                System.out.println(nombre + " añadido al carrito");
            }
        });

        return button;
    }

    private JPanel createImagePanelWithButton(JLabel imageLabel, JButton addToCartButton) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 51, 102));  // Establecer color de fondo del panel

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(addToCartButton);
        panel.add(Box.createHorizontalStrut(10)); // Espacio entre el botón y la imagen
        panel.add(imageLabel);

        return panel;
    }
}

public class VentanaCajasLetras extends JFrame {
    private CarritoDeCompras carrito;

    public VentanaCajasLetras() {
        super("Cajas de Letras");
        this.setSize(600, 420);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0, 51, 102));
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        carrito = new CarritoDeCompras();

        JLabel labelImagen1 = createImageLabel("media/caja1.jpg");
        JLabel labelImagen2 = createImageLabel("media/caja2.jpg");
        JLabel labelImagen3 = createImageLabel("media/caja3.jpg");

        JPanel filaPanel = new JPanel();
        filaPanel.setLayout(new BoxLayout(filaPanel, BoxLayout.X_AXIS));
        filaPanel.add(createImagePanel(labelImagen1));
        filaPanel.add(createImagePanel(labelImagen2));
        filaPanel.add(createImagePanel(labelImagen3));
        this.add(filaPanel);

        JLabel mensajeLabel = new JLabel("Ingrese la Letra o número que desea en la caja:");
        mensajeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        mensajeLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.add(mensajeLabel);
        JTextField campoLetra = new JTextField();
        this.add(campoLetra);

        JButton botonAgregarAlCarrito = new JButton("Añadir al carrito");
        botonAgregarAlCarrito.setBackground(Color.WHITE);
        botonAgregarAlCarrito.setForeground(Color.BLACK);
        botonAgregarAlCarrito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.agregarProducto(new Producto("Caja de Letra en forma de " + campoLetra.getText(), 20));
                System.out.println("Cajas de Letras añadido al carrito");
            }
        });
        JPanel centroPanelAgregarAlCarrito = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centroPanelAgregarAlCarrito.add(botonAgregarAlCarrito);
        this.add(centroPanelAgregarAlCarrito);

        JButton botonPagar = new JButton("Ver carrito");
        botonPagar.setBackground(Color.WHITE);
        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.mostrarCarrito();
            }
        });
        JPanel centroPanelVerCarrito = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centroPanelVerCarrito.add(botonPagar);
        this.add(centroPanelVerCarrito);

        JButton botonMenu = new JButton("Menú");
        botonMenu.setBackground(Color.WHITE);
        botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema.VentanaCatalogo ventanaCatalogo = new Sistema.VentanaCatalogo();
                ventanaCatalogo.setVisible(true);
                dispose();
            }
        });
        JPanel centroPanelMenu = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centroPanelMenu.add(botonMenu);
        this.add(centroPanelMenu);

        // Botón Menú Principal al final
        JButton botonMenuPrincipal = new JButton("Menú Principal");
        botonMenuPrincipal.setBackground(Color.WHITE);
        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema sistema2 = new Sistema();
                sistema2.setVisible(true);
                dispose();
            }
        });
        JPanel centroPanelMenuPrincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centroPanelMenuPrincipal.add(botonMenuPrincipal);
        this.add(Box.createVerticalGlue()); // Espacio entre los botones y el centro
        this.add(centroPanelMenuPrincipal);

        // Espacio entre los botones y el borde inferior
        this.add(Box.createVerticalGlue());
    }

    private JPanel createImagePanel(JLabel imageLabel) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(imageLabel);
        return panel;
    }

    private JLabel createImageLabel(String imagePath) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel("", JLabel.CENTER);
        label.setMaximumSize(new Dimension(200, 200));
        label.setIcon(scaledIcon);

        return label;
    }

    private JPanel createImagePanelWithButton(JLabel imageLabel, JButton addToCartButton) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 51, 102));

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(addToCartButton);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(imageLabel);

        return panel;
    }
}

public class VentanaCajasPersonalizadas extends JFrame {
    private CarritoDeCompras carrito;

    public VentanaCajasPersonalizadas() {
        super("Cajas Personalizadas");
        this.setSize(900, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0, 51, 102));
        this.setLayout(new BorderLayout()); // Cambiar el layout a BorderLayout para organizar los elementos más fácilmente

        carrito = new CarritoDeCompras();

        // Crear el panel de botones en la parte superior derecha
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonMenuPrincipal = new JButton("Menú Principal");
        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema sistema2 = new Sistema();
                sistema2.setVisible(true);
                dispose();
            }
        });
        menuPanel.add(botonMenuPrincipal);
        this.add(menuPanel, BorderLayout.NORTH); // Agregar el panel de botones en la parte norte

        // Crear el panel central con las cajas personalizadas
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel central

        // Crear los elementos de la ventana
        JLabel labelKitty = createImageLabel("media/cajaKitty.jpg");
        JButton botonKitty = createAddToCartButton("Caja de Hello Kitty", 25.0);
        centralPanel.add(createImagePanelWithButton(labelKitty, botonKitty));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelMario = createImageLabel("media/cajaMario.jpg");
        JButton botonMario = createAddToCartButton("Caja de Mario Bros", 25.0);
        centralPanel.add(createImagePanelWithButton(labelMario, botonMario));
        centralPanel.add(Box.createVerticalStrut(10));

        JLabel labelRM = createImageLabel("media/cajaRM.jpg");
        JButton botonRM = createAddToCartButton("Caja de Rick y Morty", 15.0);
        centralPanel.add(createImagePanelWithButton(labelRM, botonRM));

        JScrollPane scrollPane = new JScrollPane(centralPanel); // Agregar un JScrollPane para manejar el desplazamiento si es necesario
        this.add(scrollPane, BorderLayout.CENTER); // Agregar el panel central en el centro

        // Crear el panel de botones en la parte inferior
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(new Color(0, 51, 102)); // Establecer color de fondo del panel de botones

        JButton botonPagar = new JButton("Ver carrito");
        botonPagar.setBackground(Color.WHITE);
        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.mostrarCarrito();
            }
        });
        bottomPanel.add(botonPagar);

        JButton botonMenu = new JButton("Menú");
        botonMenu.setBackground(Color.WHITE);
        botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema.VentanaCatalogo ventanaCatalogo = new Sistema.VentanaCatalogo();
                ventanaCatalogo.setVisible(true);
                dispose();
            }
        });
        bottomPanel.add(botonMenu);

        this.add(bottomPanel, BorderLayout.SOUTH); // Agregar el panel de botones en la parte sur
    }

    private JLabel createImageLabel(String imagePath) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel("", JLabel.CENTER);
        label.setMaximumSize(new Dimension(200, 200));
        label.setIcon(scaledIcon);

        return label;
    }

    private JButton createAddToCartButton(String nombre, double precio) {
        JButton button = new JButton("Añadir al carrito");

        // Establecer el fondo y el color del texto explícitamente
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.agregarProducto(new Producto(nombre, precio));
                System.out.println(nombre + " añadido al carrito");
            }
        });

        return button;
    }

    private JPanel createImagePanelWithButton(JLabel imageLabel, JButton addToCartButton) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 51, 102));  // Establecer color de fondo del panel

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(addToCartButton);
        panel.add(Box.createHorizontalStrut(10)); // Espacio entre el botón y la imagen
        panel.add(imageLabel);

        return panel;
    }
}
	   
class CatalogoProductosWindow extends VentanaBase {
    private Sistema sistema;
    private List<String> listaProductos;

    public CatalogoProductosWindow(Sistema sistema) {
        this.sistema = sistema;
        this.listaProductos = ProductosUtil.obtenerListaProductos();
        initComponents();
    }

    public CatalogoProductosWindow(Sistema sistema2, List<String> listaProductos2) {
		// TODO Auto-generated constructor stub
	}

	private void initComponents() {
		
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE, 5)); // Cambia el color a negro y ajusta el grosor a tu preferencia   
		

        // Crear un modelo de lista con los productos
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // Agregar los productos al modelo de lista
        listaProductos.forEach(listModel::addElement);

        // Crear la lista y asignarle el modelo
        JList<String> productList = new JList<>(listModel);

        // Crear un botón para cerrar la ventana
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(this::cerrarButtonActionPerformed);

        // Crear un panel y configurar el diseño
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(new JScrollPane(productList), GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(cerrarButton)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(new JScrollPane(productList), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cerrarButton)
                                .addContainerGap())
        );

        // Configurar la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);  // Centrar la ventana en la pantalla
    }

    private void cerrarButtonActionPerformed(ActionEvent evt) {
        // Cerrar la ventana actual
        this.dispose();
    }
}

class ClienteRegistroWindow extends VentanaBase {
    private Sistema sistema;
    private JTextField nombreTextField;
    private JTextField cedulaTextField;
    private JTextField correoTextField;
    private JTextField telefonoTextField;
    private JPasswordField passwordField;
    private JTextField direccionTextField;

    public ClienteRegistroWindow(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
    }

    private void initComponents() {
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 51, 102));

        JPanel franjaPanel = new JPanel();
        franjaPanel.setBackground(Color.WHITE);
        franjaPanel.setPreferredSize(new Dimension(80, getHeight()));

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(Color.WHITE);

        JLabel cedulaLabel = new JLabel("Cédula:");
        cedulaLabel.setForeground(Color.WHITE);

        JLabel correoLabel = new JLabel("Correo:");
        correoLabel.setForeground(Color.WHITE);

        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoLabel.setForeground(Color.WHITE);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setForeground(Color.WHITE);

        JLabel direccionLabel = new JLabel("Dirección:");
        direccionLabel.setForeground(Color.WHITE);

        nombreTextField = new JTextField();
        cedulaTextField = new JTextField();
        correoTextField = new JTextField();
        telefonoTextField = new JTextField();
        passwordField = new JPasswordField();
        direccionTextField = new JTextField();

        JButton registrarseButton = new JButton("Registrarse");
        JButton regresarButton = new JButton("Regresar");

        // Establecer el fondo blanco para los componentes
        nombreLabel.setBackground(Color.WHITE);
        cedulaLabel.setBackground(Color.WHITE);
        correoLabel.setBackground(Color.WHITE);
        telefonoLabel.setBackground(Color.WHITE);
        passwordLabel.setBackground(Color.WHITE);
        direccionLabel.setBackground(Color.WHITE);

        nombreTextField.setBackground(Color.WHITE);
        cedulaTextField.setBackground(Color.WHITE);
        correoTextField.setBackground(Color.WHITE);
        telefonoTextField.setBackground(Color.WHITE);
        passwordField.setBackground(Color.WHITE);
        direccionTextField.setBackground(Color.WHITE);

        registrarseButton.setBackground(Color.WHITE);
        regresarButton.setBackground(Color.WHITE);

        registrarseButton.addActionListener(this::registrarseButtonActionPerformed);
        regresarButton.addActionListener(this::regresarButtonActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(direccionLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(direccionTextField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(telefonoLabel)
                                        .addComponent(passwordLabel)
                                        .addComponent(correoLabel)
                                        .addComponent(cedulaLabel)
                                        .addComponent(nombreLabel))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nombreTextField)
                                        .addComponent(cedulaTextField)
                                        .addComponent(correoTextField)
                                        .addComponent(telefonoTextField)
                                        .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                            .addComponent(regresarButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(87, 87, 87)
                            .addComponent(registrarseButton)))
                    .addContainerGap(23, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nombreLabel)
                        .addComponent(nombreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cedulaLabel)
                        .addComponent(cedulaTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(correoLabel)
                        .addComponent(correoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(telefonoLabel)
                        .addComponent(telefonoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordLabel)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(direccionLabel)
                        .addComponent(direccionTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(registrarseButton)
                        .addComponent(regresarButton))
                    .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }

    
    private void registrarseButtonActionPerformed(ActionEvent evt) {
    	
    	getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 5)); // Cambia el color a negro y ajusta el grosor a tu preferencia

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 51, 102));


        JPanel franjaPanel = new JPanel();
        franjaPanel.setBackground(Color.WHITE);
        franjaPanel.setPreferredSize(new Dimension(80, getHeight()));

        String nombre = nombreTextField.getText();
        String cedula = cedulaTextField.getText();
        String correo = correoTextField.getText();
        String telefono = telefonoTextField.getText();
        String direccion = direccionTextField.getText();
        String password = new String(passwordField.getPassword());

        if (nombre.isEmpty() || cedula.isEmpty() || correo.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            // Crear el cliente
            Cliente nuevoCliente = new Cliente(nombre, cedula, correo, telefono, direccion, password);

            // Agregar el cliente al sistema
            sistema.agregarCliente(nuevoCliente);

            JOptionPane.showMessageDialog(this, "Registro exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
            sistema.setVisible(true);
            this.dispose();
        }
   }
   
    private void regresarButtonActionPerformed(ActionEvent evt) {
        ClienteOptionsWindow clienteOptionsWindow = new ClienteOptionsWindow(sistema); 
        clienteOptionsWindow.setVisible(true); 
        this.dispose(); 	
    }
}

public String getEnteredID() {
	// TODO Auto-generated method stub
	return null;
}
public List<Producto> getProductosComprados(String enteredID) {
	// TODO Auto-generated method stub
	return null;
}

}
