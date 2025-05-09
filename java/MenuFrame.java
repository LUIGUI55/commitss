import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MenuFrame extends JFrame {
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Producto> pedido = new ArrayList<>();
    private JTextArea pedidoArea;
    
    public MenuFrame() {
        // Configuración de la ventana principal
        setTitle("Menú de Comida - Sistema de Pedidos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Inicializar productos
        inicializarProductos(); 
        
        // Panel principal con pestañas
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(new Color(240, 240, 240));
        tabbedPane.setForeground(new Color(70, 130, 180));
        
        // Panel de Comidas con JComboBox
        JPanel comidaPanel = crearComidaPanel();
        tabbedPane.addTab("Comidas", comidaPanel);
        
        // Panel de Bebidas con JComboBox
        JPanel bebidaPanel = crearBebidaPanel();
        tabbedPane.addTab("Bebidas", bebidaPanel);
        
        // Panel de Ingredientes Extra con JCheckBox
        JPanel ingredientesPanel = crearIngredientesPanel();
        tabbedPane.addTab("Extras", ingredientesPanel);
        
        // Panel del Pedido
        JPanel pedidoPanel = new JPanel(new BorderLayout());
        pedidoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pedidoPanel.setBackground(new Color(240, 240, 240));
        
        pedidoArea = new JTextArea(10, 40);
        pedidoArea.setEditable(false);
        pedidoArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(pedidoArea);
        
        JButton finalizarBtn = new JButton("Finalizar Pedido");
        finalizarBtn.setBackground(new Color(70, 130, 180));
        finalizarBtn.setForeground(Color.WHITE);
        finalizarBtn.setFocusPainted(false);
        finalizarBtn.addActionListener(e -> finalizarPedido());
        
        pedidoPanel.add(scrollPane, BorderLayout.CENTER);
        pedidoPanel.add(finalizarBtn, BorderLayout.SOUTH);
        
        // Diseño principal
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tabbedPane, pedidoPanel);
        splitPane.setResizeWeight(0.7);
        splitPane.setDividerLocation(400);
        
        add(splitPane);
        setVisible(true);
    }
    
    private void inicializarProductos() {
        // Comidas
        productos.add(new Comida("Enchiladas", 40.0));
        productos.add(new Comida("Chilaquiles rojos", 50.0));
        productos.add(new Comida("Tortas", 35.0));
        productos.add(new Comida("Tacos", 25.0));
        productos.add(new Comida("Quesadillas", 30.0));
        productos.add(new Comida("sincronizadas", 45.0));
        
        // Bebidas
        productos.add(new Bebida("Refresco", 25.0));
        productos.add(new Bebida("Agua", 15.0));
        productos.add(new Bebida("Café", 25.0));
        productos.add(new Bebida("Jugo Natural", 30.0));
        productos.add(new Bebida("Cerveza", 35.0));
        productos.add(new Bebida("Té", 20.0));
        
        // Ingredientes Extra
        productos.add(new IngredienteExtra("Queso extra", 15.0));
        productos.add(new IngredienteExtra("Verduras", 20.0));
        productos.add(new IngredienteExtra("Crema", 12.0));
        productos.add(new IngredienteExtra("Aguacate", 18.0));
        productos.add(new IngredienteExtra("Jalapeños", 10.0));
        productos.add(new IngredienteExtra("Tocino", 25.0));
    }
    
    private JPanel crearComidaPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(new Color(240, 240, 240));
        
        // ComboBox para seleccionar comida
        JComboBox<String> comidaCombo = new JComboBox<>();
        comidaCombo.setBackground(Color.WHITE);
        comidaCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Agregar comidas al ComboBox
        for (Producto producto : productos) {
            if (producto.getTipo().equals("Comida")) {
                comidaCombo.addItem(producto.getNombre() + " - $" + producto.getPrecio());
            }
        }
        
        // Botón para agregar comida al pedido
        JButton agregarBtn = new JButton("Agregar al Pedido");
        agregarBtn.setBackground(new Color(70, 130, 180));
        agregarBtn.setForeground(Color.WHITE);
        agregarBtn.setFocusPainted(false);
        
        agregarBtn.addActionListener(e -> {
            String seleccion = (String) comidaCombo.getSelectedItem();
            if (seleccion != null) {
                String nombreProducto = seleccion.split(" - \\$")[0];
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto) && producto.getTipo().equals("Comida")) {
                        pedido.add(producto);
                        actualizarPedido();
                        break;
                    }
                }
            }
        });
        
        // Panel para los controles
        JPanel controlPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        controlPanel.setBackground(new Color(240, 240, 240));
        controlPanel.add(comidaCombo);
        controlPanel.add(agregarBtn);
        
        // Imagen decorativa (puedes reemplazar con una imagen real)
        JLabel imagenLabel = new JLabel(new ImageIcon());
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagenLabel.setBorder(BorderFactory.createTitledBorder("Nuestras Comidas"));
        
        panel.add(controlPanel, BorderLayout.NORTH);
        panel.add(imagenLabel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel crearBebidaPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(new Color(240, 240, 240));
        
        // ComboBox para seleccionar bebida
        JComboBox<String> bebidaCombo = new JComboBox<>();
        bebidaCombo.setBackground(Color.WHITE);
        bebidaCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Agregar bebidas al ComboBox
        for (Producto producto : productos) {
            if (producto.getTipo().equals("Bebida")) {
                bebidaCombo.addItem(producto.getNombre() + " - $" + producto.getPrecio());
            }
        }
        
        // Botón para agregar bebida al pedido
        JButton agregarBtn = new JButton("Agregar al Pedido");
        agregarBtn.setBackground(new Color(70, 130, 180));
        agregarBtn.setForeground(Color.WHITE);
        agregarBtn.setFocusPainted(false);
        
        agregarBtn.addActionListener(e -> {
            String seleccion = (String) bebidaCombo.getSelectedItem();
            if (seleccion != null) {
                String nombreProducto = seleccion.split(" - \\$")[0];
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto) && producto.getTipo().equals("Bebida")) {
                        pedido.add(producto);
                        actualizarPedido();
                        break;
                    }
                }
            }
        });
        
        // Panel para los controles
        JPanel controlPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        controlPanel.setBackground(new Color(240, 240, 240));
        controlPanel.add(bebidaCombo);
        controlPanel.add(agregarBtn);
        
        // Imagen decorativa
        JLabel imagenLabel = new JLabel(new ImageIcon());
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagenLabel.setBorder(BorderFactory.createTitledBorder("Nuestras Bebidas"));
        
        panel.add(controlPanel, BorderLayout.NORTH);
        panel.add(imagenLabel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel crearIngredientesPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(new Color(240, 240, 240));
        
        // Panel para los checkboxes
        JPanel checkPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        checkPanel.setBackground(new Color(240, 240, 240));
        
        // Crear checkboxes para cada ingrediente extra
        ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getTipo().equals("Ingrediente Extra")) {
                JCheckBox checkBox = new JCheckBox(producto.getNombre() + " - $" + producto.getPrecio());
                checkBox.setBackground(new Color(240, 240, 240));
                checkBox.setFont(new Font("Arial", Font.PLAIN, 14));
                checkPanel.add(checkBox);
                checkBoxes.add(checkBox);
            }
        }
        
        // Botón para agregar ingredientes seleccionados
        JButton agregarBtn = new JButton("Agregar Seleccionados");
        agregarBtn.setBackground(new Color(70, 130, 180));
        agregarBtn.setForeground(Color.WHITE);
        agregarBtn.setFocusPainted(false);
        
        agregarBtn.addActionListener(e -> {
            for (JCheckBox checkBox : checkBoxes) {
                if (checkBox.isSelected()) {
                    String texto = checkBox.getText();
                    String nombreProducto = texto.split(" - \\$")[0];
                    for (Producto producto : productos) {
                        if (producto.getNombre().equals(nombreProducto) && 
                            producto.getTipo().equals("Ingrediente Extra")) {
                            pedido.add(producto);
                            checkBox.setSelected(false); // Desmarcar después de agregar
                        }
                    }
                }
            }
            actualizarPedido();
        });
        
        // Panel de desplazamiento para los checkboxes
        JScrollPane scrollPane = new JScrollPane(checkPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Seleccione Ingredientes Extra"));
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(agregarBtn, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void actualizarPedido() {
        StringBuilder sb = new StringBuilder();
        double total = 0.0;
        
        sb.append("Pedido actual:\n");
        sb.append("----------------------------------------\n");
        
        for (Producto producto : pedido) {
            sb.append(String.format("%-25s $%7.2f\n", producto.getNombre(), producto.getPrecio()));
            total += producto.getPrecio();
        }
        
        sb.append("----------------------------------------\n");
        sb.append(String.format("%-25s $%7.2f", "Total:", total));
        
        pedidoArea.setText(sb.toString());
    }
    
    private void finalizarPedido() {
        if (pedido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El pedido está vacío", 
                "Pedido vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "¿Confirmar pedido?\nTotal: $" + calcularTotal(), 
            "Confirmar pedido", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Pedido realizado con éxito", 
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            pedido.clear();
            pedidoArea.setText("");
        }
    }
    
    private double calcularTotal() {
        double total = 0.0;
        for (Producto producto : pedido) {
            total += producto.getPrecio();
        }
        return total;
    }
}

abstract class Producto {
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
    
    public abstract String getTipo();
}

class Comida extends Producto {
    public Comida(String nombre, double precio) {
        super(nombre, precio);
    }
    
    @Override
    public String getTipo() {
        return "Comida";
    }
}

class Bebida extends Producto {
    public Bebida(String nombre, double precio) {
        super(nombre, precio);
    }
    
    @Override
    public String getTipo() {
        return "Bebida";
    }
}

class IngredienteExtra extends Producto {
    public IngredienteExtra(String nombre, double precio) {
        super(nombre, precio);
    }
    
    @Override
    public String getTipo() {
        return "Ingrediente Extra";
    }
}