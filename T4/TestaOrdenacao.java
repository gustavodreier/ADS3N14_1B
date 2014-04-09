import java.util.Random;


public class TestaOrdenacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int lenght = 1000;
		
		int[] arrayBub = new int[lenght];
		int[] arraySel = new int[lenght];

		Random r = new Random(2);
		for (int i = 0; i < arraySel.length; i++) {
			arrayBub[i] = arraySel[i] = r.nextInt(lenght);
		}
		
		SelectionSort sel = new SelectionSort();
		arraySel = sel.ordena(arraySel);
		
		BubbleSort bub = new BubbleSort();
		arrayBub = bub.ordena(arrayBub);

		System.out.println("Numero de comparacoes do Selection Sort = "+sel.getNumComparacao());
		System.out.println("Numero de trocas do Selection Sort = "+sel.getNumTroca());

		System.out.println("Numero de comparacoes do Bubble Sort = "+bub.getNumComparacao());
		System.out.println("Numero de trocas do Bubble Sort = "+bub.getNumTroca());
		
	}

}
