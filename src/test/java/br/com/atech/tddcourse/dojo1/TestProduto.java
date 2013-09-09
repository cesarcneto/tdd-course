package br.com.atech.tddcourse.dojo1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestProduto {

	private List<Produto> esperado;

	@Before
	public void setup() {
		esperado = new ArrayList<>();
	}

	@Test
	public void testCompraOrdenadaPorCorredorEPrateleira() {
		Iterable<Produto> estoque = new Compra().getProdutosEmEstoque();
		List<Produto> produtosEsperados = getProdutosEsperados();
		// org.hamcrest.CoreMatchers.
	}

	private List<Produto> getProdutosEsperados() {
		esperado.add(new Produto("Suco", 1, 1));
		esperado.add(new Produto("Iogurt", 1, 7));
		esperado.add(new Produto("Ovo", 1, 8));
		esperado.add(new Produto("Alho", 1, 9));
		esperado.add(new Produto("Escova dental", 4, 7));
		esperado.add(new Produto("Shampoo", 5, 2));
		esperado.add(new Produto("Desodorante", 5, 3));
		return esperado;
	}

}
