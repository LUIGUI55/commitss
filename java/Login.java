import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Login {
    public static void main(String[] args) {
        // Crear algunos usuarios de prueba
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("admin", "1234"));
        usuarios.add(new Usuario("cliente", "cliente123"));
        
        // Mostrar la ventana de login
        SwingUtilities.invokeLater(() -> new LoginFrame(usuarios));
    }
}

class Usuario {
    private String username;
    private String password;
    
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public boolean autenticar(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

class LoginFrame extends JFrame {
    private ArrayList<Usuario> usuarios;
    
    public LoginFrame(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
        
        setTitle("Login - Sistema de Menú");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel principal con color de fondo
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Título
        JLabel titleLabel = new JLabel("Sistema de Menú", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(70, 130, 180));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(titleLabel, gbc);
        
        // Campos de usuario y contraseña
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        panel.add(new JLabel("Usuario:"), gbc);
        
        gbc.gridx = 1;
        JTextField userField = new JTextField(15);
        panel.add(userField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Contraseña:"), gbc);
        
        gbc.gridx = 1;
        JPasswordField passField = new JPasswordField(15);
        panel.add(passField, gbc);
        
        // Botón de login
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        JButton loginBtn = new JButton("Ingresar");
        loginBtn.setBackground(new Color(70, 130, 180));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        panel.add(loginBtn, gbc);
        
        loginBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            
            boolean autenticado = false;
            for (Usuario usuario : usuarios) {
                if (usuario.autenticar(username, password)) {
                    autenticado = true;
                    break;
                }
            }
            
            if (autenticado) {
                dispose(); // Cerrar ventana de login
                // Llamar al menú principal
                new MenuFrame();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", 
                    "Error de autenticación", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        add(panel);
        setVisible(true);
    }
}
