package acumuladores;

public class Acumuladores {

	/**
	 * Dada una matriz de enteros y un número, verifica si existe alguna fila 
	 * donde todos sus elementos sean múltiplos del número recibido por 
	 * parámetro.
	 * 
	 * Si la matriz está vacía o si el número no es positivo, devuelve falso.
	 * 
	 * @param mat
	 * @param num
	 * @return
	 */
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
	    if (mat == null || mat.length == 0) return false;
	    if (num <= 0) return false;

	    boolean hayFila = false;
	    for (int i = 0; i < mat.length && !hayFila; i++) {
	        int[] fila = mat[i];
	        if (fila == null) continue;
	        
	        boolean todosMultiplos = true;
	        for (int j = 0; j < fila.length && todosMultiplos; j++) {
	            int elemento = fila[j];
	            todosMultiplos = todosMultiplos && (elemento % num == 0);
	        }

	        if (todosMultiplos) {
	            hayFila = true;
	        }
	    }

	    return hayFila;
	}

	
	/**
	 * Dado 2 matrices se verifica si hay intersección entre las filas de cada
	 * matriz, fila a fila.
	 * 
	 * Si las matrices tienen distinta cantidad de filas o si alguna matriz 
	 * está vacía, devuelve falso.
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorFila(int[][] mat1, int[][] mat2) {

	    if (mat1 == null || mat2 == null) return false;
	    if (mat1.length == 0 || mat2.length == 0) return false;
	    if (mat1.length != mat2.length) return false;

	    boolean interseccionEnTodasFilas = true;
	    for (int i = 0; i < mat1.length && interseccionEnTodasFilas; i++) {
	        int[] fila1 = mat1[i];
	        int[] fila2 = mat2[i];

	        if (fila1 == null || fila2 == null) {
	            interseccionEnTodasFilas = false;
	            continue;
	        }

	        boolean hayInterseccionEnFila = false;
	        for (int j = 0; j < fila1.length && !hayInterseccionEnFila; j++) {
	            int a = fila1[j];
	            for (int k = 0; k < fila2.length && !hayInterseccionEnFila; k++) {
	                int b = fila2[k];
	                if (a == b) {
	                    hayInterseccionEnFila = true;
	                }
	            }
	        }

	        interseccionEnTodasFilas = interseccionEnTodasFilas && hayInterseccionEnFila;
	    }

	    return interseccionEnTodasFilas;
	}

	
	/**
	 * Dada una matriz y el índice de una columna, se verifica si existe alguna
	 * fila cuya suma de todos sus elementos sea mayor estricto que la suma de
	 * todos los elementos de la columna indicada por parámetro.
	 * 
	 * Si el índice de la columna es inválido o la matriz está vacía, devuelve 
	 * falso.
	 * 
	 * @param mat
	 * @param nColum
	 * @return
	 */
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) {

	    if (mat == null || mat.length == 0) return false;

	    if (nColum < 0) return false;

	    for (int i = 0; i < mat.length; i++) {
	        if (mat[i] == null || mat[i].length <= nColum) {
	            return false;
	        }
	    }

	    int sumaColumna = 0;
	    for (int i = 0; i < mat.length; i++) {
	        sumaColumna += mat[i][nColum];
	    }

	    boolean encontrada = false;
	    for (int i = 0; i < mat.length && !encontrada; i++) {
	        int[] fila = mat[i];
	        int sumaFila = 0;

	        for (int j = 0; j < fila.length; j++) {
	            sumaFila += fila[j];
	        }

	        if (sumaFila > sumaColumna) {
	            encontrada = true;
	        }
	    }

	    return encontrada;
	}

	
	/**
	 * Dadas 2 matrices, se verifica si hay intersección entre las columnas de
	 * cada matriz, columna a columna.
	 * 
	 * Si las matrices tienen distinta cantidad de columnas o alguna matriz 
	 * está vacía, devuelve falso. 
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][] mat2) {

	    if (mat1 == null || mat2 == null) return false;
	    if (mat1.length == 0 || mat2.length == 0) return false;

	    if (mat1[0] == null || mat2[0] == null) return false;

	    int numCols1 = mat1[0].length;
	    int numCols2 = mat2[0].length;
	    if (numCols1 != numCols2) return false;

	    for (int i = 0; i < mat1.length; i++) {
	        if (mat1[i] == null || mat1[i].length != numCols1) return false;
	    }
	    for (int i = 0; i < mat2.length; i++) {
	        if (mat2[i] == null || mat2[i].length != numCols2) return false;
	    }

	    boolean interseccionEnTodasColumnas = true;
	    for (int c = 0; c < numCols1 && interseccionEnTodasColumnas; c++) {
	        boolean hayInterseccionEnColumna = false;

	        for (int i = 0; i < mat1.length && !hayInterseccionEnColumna; i++) {
	            int valor1 = mat1[i][c];
	            for (int j = 0; j < mat2.length && !hayInterseccionEnColumna; j++) {
	                if (valor1 == mat2[j][c]) {
	                    hayInterseccionEnColumna = true;
	                }
	            }
	        }

	        interseccionEnTodasColumnas = interseccionEnTodasColumnas && hayInterseccionEnColumna;
	    }

	    return interseccionEnTodasColumnas;
	}

}
