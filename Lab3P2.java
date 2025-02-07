/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lab3P2;
 
/**
 *
 * @author 50488
 */
public class Lab3P2 extends SudokuPadre{
 
    @Override
    public void llenarTablero(int[][] tablero){
        int[] tablerodigitos={
            5, 3, 0, 0, 7, 0, 0, 0, 0,
            6, 0, 0, 1, 9, 5, 0, 0, 0,
            0, 9, 8, 0, 0, 0, 0, 6, 0,
            8, 0, 0, 0, 6, 0, 0, 0, 3,
            4, 0, 0, 8, 0, 3, 0, 0, 1,
            7, 0, 0, 0, 2, 0, 0, 0, 6,
            0, 6, 0, 0, 0, 0, 2, 8, 0,
            0, 0, 0, 4, 1, 9, 0, 0, 5,
            0, 0, 0, 0, 8, 0, 0, 7, 9
        };
        int contador=0;
        for(int i=0;i<tablero.length;i++){
 
            for(int col=0;col<tablero[i].length;col++){
 
                tablero[i][col]=tablerodigitos[contador];
                contador++;
            }
 
        }
 
    }
 
    @Override 
    public void llenarSolucion(int[][] solucion){
        int[] soluciondigitos={5, 3, 4, 6, 7, 8, 9, 1, 2,
            6, 7, 2, 1, 9, 5, 3, 4, 8,
            1, 9, 8, 3, 4, 2, 5, 6, 7,
            8, 5, 9, 7, 6, 1, 4, 2, 3,
            4, 2, 6, 8, 5, 3, 7, 9, 1,
            7, 1, 3, 9, 2, 4, 8, 5, 6,
            9, 6, 1, 5, 3, 7, 2, 8, 4,
            2, 8, 7, 4, 1, 9, 6, 3, 5,
            3, 4, 5, 2, 8, 6, 1, 7, 9};
        int contador=0;
        for(int i=0;i<solucion.length;i++){
 
            for(int col=0;col<solucion[i].length;col++){
 
                solucion[i][col]=soluciondigitos[contador];
                contador++;
            }
 
        }
    }
    public static void main(String[] args) {
 
        SudokuPadre sudoku=new Lab3P2();
        int[][] tablero=new int[9][9];
        int[][] solucion=new int[9][9];
        sudoku.llenarTablero(tablero);
        sudoku.llenarSolucion(solucion);
        sudoku sudokuGame=new sudoku(tablero,solucion);
 
    }
}