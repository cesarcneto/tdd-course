package dojo2;


public class Pagina {

	private int altura;
	private int largura;

	private Foto foto1;
	private Foto foto2;

	public Pagina(int altura, int largura) {
		this.setAltura(altura);
		this.setLargura(largura);
	}

	private boolean sePaginaVazia() {
		return foto1 == null && foto2 == null;
	}

	public boolean cabeFotos() {
		if (sePaginaVazia())
			return true;

		return calcula();
	}

	private boolean calcula() {
		int max = Math.max(largura, altura);
		int min = Math.min(largura, altura);

		if (foto1.getAltura() + foto2.getAltura() <= max //
				&& Math.max(foto1.getLargura(), foto2.getLargura()) <= min) {
			return true;
		}

		if (foto1.getLargura() + foto2.getAltura() <= max //
				&& Math.max(foto1.getAltura(), foto2.getLargura()) <= min) {
			return true;
		}

		if (foto1.getAltura() + foto2.getLargura() <= max //
				&& Math.max(foto1.getLargura(), foto2.getAltura()) <= min) {
			return true;
		}

		if (foto1.getLargura() + foto2.getLargura() <= max //
				&& Math.max(foto1.getLargura(), foto2.getLargura()) <= min) {
			return true;
		}

		return false;
	}

	public Foto getFoto1() {
		return foto1;
	}

	public void setFoto1(Foto foto1) {
		this.foto1 = foto1;
	}

	public Foto getFoto2() {
		return foto2;
	}

	public void setFoto2(Foto foto2) {
		this.foto2 = foto2;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

}
