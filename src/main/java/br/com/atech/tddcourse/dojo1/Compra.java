package br.com.atech.tddcourse.dojo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Compra {

	private List<Produto> produtos;

	public Compra() {
		produtos = new ArrayList<>();
		produtos.add(new Produto("Desodorante", 5, 3));
		produtos.add(new Produto("Alho", 1, 9));
		produtos.add(new Produto("Shampoo", 5, 2));
		produtos.add(new Produto("Suco", 1, 1));
		produtos.add(new Produto("Ovo", 1, 8));
		produtos.add(new Produto("Iogurt", 1, 7));
		produtos.add(new Produto("Escova dental", 4, 7));
		Collections.sort(produtos);
	}
	
	public Iterable<Produto> getProdutosEmEstoque(){
		return produtos;
	}
	
	
	public Produto getPosicao(String nomeProduto){
		for (Produto p : produtos) {
			if (p.getNomeProduto().equalsIgnoreCase(nomeProduto))
				return p;
		}
		return null;		
	}

	public static void main(String[] args) {
		Produto posicao = new Compra().getPosicao("Iogurt");
		System.out.println(posicao);
	}
	
	
	
	
}
