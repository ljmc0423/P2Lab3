/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3P2;
 
/**
 *
 * @author ljmc2
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class sudoku {
    private JFrame frame;
    private JTextField[][] cells;
    private int[][] solution;

    public sudoku(int[][] board, int[][] solution) {
        this.solution = solution;
        frame = new JFrame("Sudoku");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(9, 9)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                for (int i = 0; i <= 9; i++) {
                    if (i % 3 == 0 && i != 9) {
                        g.fillRect(i * getWidth() / 9 - 2, 0, 4, getHeight());
                        g.fillRect(0, i * getHeight() / 9 - 2, getWidth(), 4);
                    }
                }
            }
        };
        cells = new JTextField[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new JTextField();
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                if ((i / 3 + j / 3) % 2 == 0) {
                    cells[i][j].setBackground(new Color(220, 235, 255)); // Tonos azulados
                } else {
                    cells[i][j].setBackground(Color.WHITE);
                }
                
                //Validacion para que no me pemita ingresar mas de dos digitos
                if (board[i][j] != 0) {
                    cells[i][j].setText(String.valueOf(board[i][j]));
                    cells[i][j].setEditable(false);
                    cells[i][j].setForeground(Color.BLACK);
                } else {
                    cells[i][j].addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            char c = e.getKeyChar();
                            if (!Character.isDigit(c) || c == '0' || ((JTextField) e.getSource()).getText().length() >= 1) {
                                e.consume(); // Bloquea letras, números mayores a 9 y más de un dígito
                            }
                        }
                    });
                }
                panel.add(cells[i][j]);
            }
        }

        JButton checkButton = new JButton("Verificar");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkSolution();
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(checkButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void checkSolution() {
        boolean hasErrors = false;
        StringBuilder errorMessage = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                try {
                    int value = Integer.parseInt(cells[i][j].getText());
                    if (value != solution[i][j]) {
                        errorMessage.append("Número incorrecto en la casilla (").append(i + 1).append(", ").append(j + 1).append(").\n");
                        cells[i][j].setText(""); // Borra el número incorrecto
                        hasErrors = true;
                    } else {
                        cells[i][j].setEditable(false);
                    }
                } catch (NumberFormatException ex) {
                    // Ignorar si está vacío
                }
            }
        }

        if (hasErrors) {
            JOptionPane.showMessageDialog(frame, errorMessage.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "¡Felicidades! Has completado correctamente!", null, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[9][9]; // Your Sudoku board
        int[][] solution = new int[9][9]; // Solution
        new sudoku(board, solution);
    }
}