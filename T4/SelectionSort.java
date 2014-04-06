
public class SelectionSort {
	
	private int menor;
	private int auxiliar;
	
	public int[] ordena(int[] array ) {
		//quando ordenar o penultimo automaticamente ja ordenará o ultimo
		for (int i = 0; i < (array.length - 1); i++) {
			menor = i;
			for (int j = (i + 1); j < array.length; j++) {
				
				if (array[j] < array[menor]) {
					menor = j;
				}
			}//fim for j
			//apos encontrar o menor coloca na primeira posicao nao ordenada
			auxiliar = array[i];
			array[i] = array[menor];
			array[menor] = auxiliar;
		}//fim for i
		
		return array;
	}

}
