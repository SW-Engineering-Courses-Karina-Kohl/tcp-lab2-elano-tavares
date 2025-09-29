import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI implements ActionListener {

    private JFrame frame;
    private JTextField campoNum1, campoNum2;
    private JButton botaoSomar, botaoDividir;
    private JLabel labelResultado;
    private Calculadora calculadora;

    public CalculadoraGUI() {
        frame = new JFrame("Calculadora Gráfica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLayout(new FlowLayout());

        calculadora = new Calculadora();

        campoNum1 = new JTextField(10);
        campoNum2 = new JTextField(10);
        botaoSomar = new JButton("Somar");
        botaoDividir = new JButton("Dividir");
        labelResultado = new JLabel("Resultado:");

        botaoSomar.addActionListener(this);
        botaoDividir.addActionListener(this);

        frame.add(new JLabel("Número 1:"));
        frame.add(campoNum1);
        frame.add(new JLabel("Número 2:"));
        frame.add(campoNum2);
        frame.add(botaoSomar);
        frame.add(botaoDividir);
        frame.add(labelResultado);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(campoNum1.getText());
            int num2 = Integer.parseInt(campoNum2.getText());

            int resultado = 0;

            if (e.getSource() == botaoSomar) {
                resultado = calculadora.somar(num1, num2);
                labelResultado.setText("Resultado: " + resultado);
            } else if (e.getSource() == botaoDividir) {
                resultado = calculadora.dividir(num1, num2);
                labelResultado.setText("Resultado: " + resultado);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Erro: Por favor, insira números válidos.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(frame, "Erro: " + ex.getMessage(), "Erro de Cálculo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraGUI());
    }
}