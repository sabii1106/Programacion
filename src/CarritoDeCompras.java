import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.LocalDate;

public class CarritoDeCompras extends Sistema{
    private ArrayList<Producto> productosComprados;
    
    public double getPrecioTotal() {
        double precioTotal = 0;
        for (Producto producto : productosComprados) {
            precioTotal += producto.getPrecio();
        }
        return precioTotal;
    }
    
    public CarritoDeCompras() {
        this.productosComprados = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productosComprados.add(producto);
    }

    public ArrayList<Producto> getProductosComprados() {
        return productosComprados;
    }

    public void mostrarCarrito() {
        JFrame frame = new JFrame("Carrito de Compras");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0); // Espaciado

        panel.add(new JLabel("Producto"), gbc);

        gbc.gridx = 2;
        panel.add(new JLabel("Precio"), gbc);

        double precioTotal = 0;
        gbc.gridwidth = 1;

        for (int i = 0; i < productosComprados.size(); i++) {
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            panel.add(new JLabel(productosComprados.get(i).getNombre()), gbc);

            gbc.gridx = 2;
            panel.add(new JLabel(String.valueOf(productosComprados.get(i).getPrecio())), gbc);

            precioTotal += productosComprados.get(i).getPrecio();
        }

        gbc.gridx = 0;
        gbc.gridy = productosComprados.size() + 1;
        gbc.gridwidth = 2;
        panel.add(new JLabel("Total: "), gbc);

        gbc.gridx = 2;
        panel.add(new JLabel(String.valueOf(precioTotal)), gbc);

        JButton continuarButton = new JButton("Continuar");
        continuarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                mostrarOpcionesDeEntrega();
            }
        });

        gbc.gridx = 1;
        gbc.gridy = productosComprados.size() + 2;
        gbc.gridwidth = 1;
        panel.add(continuarButton, gbc);

        frame.add(new JScrollPane(panel));

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }

    private void mostrarOpcionesDeEntrega() {
        JFrame opcionesFrame = new JFrame("Opciones de entrega");
        opcionesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton domicilioButton = new JButton("Entrega a domicilio");
        JButton localButton = new JButton("Entrega en el local");

        domicilioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                opcionesFrame.dispose();
                JFrame direccionFrame = new JFrame("Dirección de entrega");
                String direccion = JOptionPane.showInputDialog(direccionFrame, "Ingrese su dirección dentro del Dstrito Metropolitano de Quito:");
                direccionFrame.dispose();
                mostrarMetodosDePago(getPrecioTotal(), true, direccion);
            }
        });

        localButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                opcionesFrame.dispose();
                mostrarMetodosDePago(getPrecioTotal(), false, null);
            }
        });

        panel.add(domicilioButton);
        panel.add(localButton);

        opcionesFrame.add(panel);
        opcionesFrame.setSize(300, 200);
        opcionesFrame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        opcionesFrame.setVisible(true);
    }
    


    private void mostrarMetodosDePago(double precioTotal, boolean entregaADomicilio, String direccionEntrega) {
        JFrame metodosFrame = new JFrame("Métodos de pago");
        metodosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel precioLabel = new JLabel("Precio Total: $" + precioTotal);
        panel.add(precioLabel);

        double nuevoPrecio = precioTotal;
        if (entregaADomicilio) {
            nuevoPrecio += 3.5; // Aumenta el precio total por la entrega a domicilio
            JLabel mensajeLabel = new JLabel("Su pedido será enviado a la dirección indicada: " + direccionEntrega);
            panel.add(mensajeLabel);

            JLabel nuevoPrecioLabel = new JLabel("Precio Total con envío: $" + nuevoPrecio);
            panel.add(nuevoPrecioLabel);
        } else {
            JLabel mensajeLabel = new JLabel("Puede ir a retirar su pedido a la siguiente dirección:");
            panel.add(mensajeLabel);
            JLabel mensajeLabel1 = new JLabel("Solanda sector 3 Calle Juan Aragón , S19D, Quito");
            panel.add(mensajeLabel1);
        }

        // Obtener la fecha dentro de dos días
        LocalDate fechaDosDiasDespues = LocalDate.now().plusDays(2);
        JLabel fechaLabel = new JLabel("Su pedido estará listo el: " + fechaDosDiasDespues);
        panel.add(fechaLabel);

        final double finalPrecio = nuevoPrecio;

        JButton pagarButton = new JButton("Pagar");
        pagarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                metodosFrame.dispose();
                JFrame mensajeFrame = new JFrame("Pago realizado");
                JPanel mensajePanel = new JPanel();
                mensajePanel.setLayout(new BoxLayout(mensajePanel, BoxLayout.Y_AXIS)); // Establecer un diseño para el panel
                JLabel mensajeLabel = new JLabel("Realice el depósito al número de cuenta: 123456 con el valor de $" + finalPrecio);
                JLabel mensajeLabel1 = new JLabel("Y envíe el comprobante con cualquier indicación adicional al número:");
                JLabel mensajeLabel2 = new JLabel("0983710243");
                mensajePanel.add(mensajeLabel);
                mensajePanel.add(mensajeLabel1);
                mensajePanel.add(mensajeLabel2);
                mensajeFrame.add(mensajePanel); 
                mensajeFrame.setSize(500, 150);
                mensajeFrame.setLocationRelativeTo(null);
                mensajeFrame.setVisible(true);
                
                JButton finalizarButton = new JButton("Finalizar");
                finalizarButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mensajeFrame.dispose(); 
                    }
                });
                mensajeFrame.add(finalizarButton, BorderLayout.SOUTH); 
            }
        });
        panel.add(pagarButton);

        metodosFrame.add(panel);
        metodosFrame.setSize(400, 200);
        metodosFrame.setLocationRelativeTo(null);
        metodosFrame.setVisible(true);
    }





    public static void main(String[] args) {
        CarritoDeCompras carrito = new CarritoDeCompras();
        carrito.agregarProducto(new Producto("Producto 1", 10.0));
        carrito.agregarProducto(new Producto("Producto 2", 15.0));
        carrito.mostrarCarrito();
    }
}

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
