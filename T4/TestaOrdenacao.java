import java.util.Random;


public class TestaOrdenacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = new int[1000];
		//int[] array2 = new int[array.length];
		//int[] array = {
		
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(2000);
		}
		
		
		SelectionSort sel = new SelectionSort();
		
		array = sel.ordena(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("Posicao " + i  + " = " + array[i]);
		}

	}

}
