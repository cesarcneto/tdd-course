package dojo2;

import junit.framework.Assert;

import org.junit.Test;

public class AlbumDeFotosTest {

	private Foto foto1;
	private Foto foto2;
	private Pagina pagina;

	@Test
	public void testCabeFotosEmPaginaVazia() {
		Pagina pagina = new Pagina(7,5);
		Assert.assertTrue(pagina.cabeFotos());
	}
	
	@Test
	public void testCabeFotosEmPagina() {
		foto1 = new Foto(3,4);
		foto2 = new Foto(3,4);
		createPagina(7, 5);
		
		Assert.assertTrue(pagina.cabeFotos());
	}

	private void createPagina(int largura, int altura) {
		pagina = new Pagina(largura, altura);
		
		pagina.setFoto1(foto1);
		pagina.setFoto2(foto2);
	}
	
	@Test
	public void testCabeFotosEmPagina2() {
		foto1 = new Foto(6,6);
		foto2 = new Foto(6,6);
		createPagina(10, 10);
		
		Assert.assertFalse(pagina.cabeFotos());
	}
	
	@Test
	public void testCabeFotosEmPagina3() {
		foto1 = new Foto(4,9);
		foto2 = new Foto(6,5);
		createPagina(13, 8);
		
		Assert.assertFalse(pagina.cabeFotos());
	}
	
	@Test
	public void testCabeFotosEmPagina4() {
		foto1 = new Foto(3,4);
		foto2 = new Foto(5,3);
		createPagina(7, 5);
		
		Assert.assertTrue(pagina.cabeFotos());
	}
	
	@Test
	public void testCabeFotosEmPagina5() {
		foto1 = new Foto(7,6);
		foto2 = new Foto(7,6);
		createPagina(7, 12);
		
		Assert.assertTrue(pagina.cabeFotos());
	}
}