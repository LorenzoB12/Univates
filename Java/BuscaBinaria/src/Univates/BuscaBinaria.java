package Univates;

public class BuscaBinaria {
	
	//  Método que faz a busca binária.
	//  Resumidamente o valor passado como parâmetro para busca é procurado sempre em duas metades de uma lista,
	//caso o valor seja maior que o menor número da lista com os valores mais altos, a lista com os valores mais
	//baixos é descartada o processo é continuado com a lista com maiores valores, seguindo assim por diante.
	public static int buscaBinaria(Integer[] s, int x) {
		int meio; 
		int inicio = 0; 
		int fim;
		fim = s.length - 1;
		while (inicio <= fim) {
			meio = (inicio + fim) / 2;
			if(s[meio] == x) {
				return meio;
			} else {
				if(s[meio] < x) {
					inicio = meio + 1;
				} else {
					if(s[meio] > x) {
						fim = meio - 1;
					}
				}
			}
		}
		return -1;
	}
}