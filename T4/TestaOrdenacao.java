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
		
		//SelectionSort sel = new SelectionSort();
		BubbleSort bub = new BubbleSort();
		
		//array = sel.ordena(array);
		array = bub.ordena(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("Posicao " + i  + " = " + array[i]);
		}

	}

}
