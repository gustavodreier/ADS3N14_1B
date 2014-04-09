import java.util.Random;


public class TestaOrdenacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = new int[1000];
		
		Random r = new Random(1);
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(1000);
			//System.out.println("Posicao "+i+" = "+array[i]);
		}
		
		SelectionSort sel = new SelectionSort();
		BubbleSort bub = new BubbleSort();
		
		int[] arraySel = sel.ordena(array);
		int[] arrayBub = bub.ordena(array);
		
		System.out.println("Numero de comparacoes do Selection Sort = "+sel.getNumComparacao);
		System.out.println("Numero de trocas do Selection Sort = "+sel.getNumTroca);
		
		System.out.println("Numero de comparacoes do Bubble Sort = "+bub.getNumComparacao);
		System.out.println("Numero de trocas do Bubble Sort = "+bub.getNumTroca);
		/*
		for (int i = 0; i < array.length; i++) {
			System.out.println("Posicao " + i  + " = " + array[i]);
		}
		*/

	}

}
