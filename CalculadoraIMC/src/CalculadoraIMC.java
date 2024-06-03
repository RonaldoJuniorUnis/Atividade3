package CalculadoraIMC;

public class CalculadoraIMC {
	
	public static void main(String[] args) {
		import javax.swing.*;
		import java.awt.event.*;

		public class CalculadoraIMC extends JFrame {
		    private JTextField textPeso;
		    private JTextField textAltura;
		    private JButton calcularButton;
		    private JLabel resultadoLabel;

		    public CalculadoraIMC() {
		        setTitle("Calculadora de IMC");
		        setSize(300, 200);
		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		        add(new JLabel("Peso em kg:"));
		        textPeso = new JTextField();
		        add(textPeso);

		        add(new JLabel("Altura em cm:"));
		        textAltura = new JTextField();
		        add(textAltura);

		        calcularButton = new JButton("Calcular IMC");
		        calcularButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                double peso = Double.parseDouble(textPeso.getText());
		                double altura = Double.parseDouble(textAltura.getText()) / 100; // Convertendo para metros
		                double imc = peso / (altura * altura);
		                resultadoLabel.setText("IMC: " + String.format("%.2f", imc) + " - " + situacaoIMC(imc));
		            }
		        });
		        add(calcularButton);

		        resultadoLabel = new JLabel("Resultado: ");
		        add(resultadoLabel);

		        setVisible(true);
		    }

		    private String situacaoIMC(double imc) {
		        if (imc < 17) return "Muito abaixo do peso";
		        else if (imc >= 17 && imc <= 18.49) return "Abaixo do peso";
		        else if (imc >= 18.50 && imc <= 24.99) return "Peso normal";
		        else if (imc >= 25 && imc <= 29.99) return "Acima do peso";
		        else if (imc >= 30 && imc <= 34.99) return "Obesidade I";
		        else if (imc >= 35 && imc <= 39.99) return "Obesidade II (severa)";
		        else return "Obesidade III (mórbida)";
		    }

		    public static void main(String[] args) {
		        SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                new CalculadoraIMC();
		            }
		        });
		    }
		}

