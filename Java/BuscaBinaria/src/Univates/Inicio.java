package Univates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Inicio {
	public static void main(String[] args) throws IOException {
		
		//Array com as palavras da frase para serem buscadas nas pesquisa linear.
		String[] palavrasParaBuscar = { "NAO", "ATIRE", "O", "PAU", "NO", "GATO", "PORQUE", "ISSO", "NAO", "SE", "FAZ",
				"O", "GATINHO", "E", "NOSSO", "AMIGO", "NAO", "DEVEMOS", "MALTRATAR", "OS", "ANIMAIS", "JAMAIS" };

		//Importação do arquivo PALAVRAS.CSV para um HashMap para que possa ser feita a pesquisa linear de uma forma que 
		//nao tao demorada quanto seria em um ArrayList. 
		BufferedReader br = new BufferedReader(new FileReader("\\Users\\loren\\OneDrive\\Área de Trabalho\\PALAVRAS.csv"));
		String line = null;
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		//Importação do arquivo FRASE.CSV para fazer a busca na pesquisa binária.
		BufferedReader brFrase = new BufferedReader(new FileReader("\\Users\\loren\\OneDrive\\Área de Trabalho\\FRASE.csv"));
		String lineFrase = null;
		HashMap<Integer, String> mapFrase = new HashMap<Integer, String>();
		
		//Script para colocar as PALAVRAS dentro do seu devido HashMap
		while ((line = br.readLine()) != null) {
			String[] valor = line.split(";");
			valor[0] = valor[0].replaceAll("[^a-zA-Z0-9]", "");
			valor[1] = valor[1].replaceAll("[^a-zA-Z0-9]", "");
			map.put(Integer.parseInt(valor[0]), valor[1]);
		}
		
		//Script para colocar as palavras da FRASE dentro do seu devido HashMap
		while ((lineFrase = brFrase.readLine()) != null) {
			String[] valorFrase = lineFrase.split(";");
			valorFrase[0] = valorFrase[0].replaceAll("[^a-zA-Z0-9]", "");
			valorFrase[1] = valorFrase[1].replaceAll("[^a-zA-Z0-9]", "");
			mapFrase.put(Integer.parseInt(valorFrase[0]), valorFrase[1]);
		}
		
		//Aqui começa a pesquisa de forma linear, sendo que todos os itens do HashMap são percorridos para que sejam encontrados
		//os valores das palavras da frase.

		int contador = 1;
		int contador2 = 0;

		//Contador de tempo inicial da BUSCA LINEAR
		Long tempoInicial = System.currentTimeMillis();
		Long tempo;
		
		//Enquanto houverem itens para serem buscados a pesquisa continuará, sempre voltando ao começo para procurar
		//as palavras da frase
		while (true) {
			for (int i = 0; i < palavrasParaBuscar.length; i++) {
				if (palavrasParaBuscar[i].equals(map.get(contador).toUpperCase())) {
					contador2++;
				}
			}
			contador++;
			if (contador2 == palavrasParaBuscar.length) {
				//Contador de tempo final da BUSCA LINEAR
				tempo = System.currentTimeMillis();
				break;
			}
		}
		Set<Integer> listaInts = map.keySet();
		Integer[] arrayInts = listaInts.toArray(new Integer[listaInts.size()]);
		System.out.println("TEMPO TOTAL DA PESQUISA LINEAR: " + (tempo - tempoInicial));

		
		
		//  PESQUISA BINARIA:
		//  Aqui começa a pesquisa binária, que chama o método no outro arquivo denominado BuscaBinaria.java, o método
		//passa como parâmetro uma lista das chaves das palavras e o indíce da palavra a ser buscada.
		//  São passados todas as palavras da frase para serem procuradas, sendo que é feita uma pesquisa com o tempo
		//de espera sendo igual a O(log n), ou seja, o tempo de espera é divído por 2 a cada passo.
		Set<Integer> listaIntsFrase = mapFrase.keySet();
		Integer[] arrayIntsFrase = listaIntsFrase.toArray(new Integer[listaIntsFrase.size()]);
		
		Long tempoInicialBin = System.currentTimeMillis();
		for(int i = 0; i < arrayIntsFrase.length; i++) {
			
			//Aqui é chamado o método que retorna o próprio valor(caso encontrado) ou -1, caso nao identifique o valor na lista.
			BuscaBinaria.buscaBinaria(arrayInts, arrayIntsFrase[i]);
		}
		Long tempofinalBin = System.currentTimeMillis();
		
		System.out.println("TEMPO TOTAL DA PESQUISA BINARIA EM MILISSEGUNDOS: " + (tempofinalBin - tempoInicialBin));
	}
}