public class BubbleSort {
	
	int atual;
	int auxiliar;
	boolean troca;
	public int[] ordena(int[] array) {
		
		for (int i = (array.length - 1); i > 0; i--) {
			troca = false;
			for (int j = 0; j < i; j++) {
				
				if (array[j]>array[j+1]) {
					auxiliar = array[j];
					array[j] = array[j+1];
					array[j+1] = auxiliar;
					troca = true;
				}
			}
			//se nao realizou trocas significa que ja esta ordenado
			if (troca == false)
				return array;
			
		}//fim for
			
		return array;
	}//fim class ordena
	
}
