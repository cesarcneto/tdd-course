package br.com.atech.tddcourse.dojo1;

public class Produto implements Comparable<Produto>{

	private String nomeProduto;
	private int corredor;
	private int posicao;
	
	public Produto(String nomeProduto, int corredor, int posicao) {
		this.nomeProduto = nomeProduto;
		this.corredor = corredor;
		this.posicao = posicao;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public int getCorredor() {
		return corredor;
	}
	public void setCorredor(int corredor) {
		this.corredor = corredor;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	@Override
	public int compareTo(Produto o) {
		if(this.corredor < o.corredor ){
			return -1;
		} else if (this.corredor > o.corredor) {
			return 1;
		} else {//corredor igual
			if(this.posicao < o.posicao ){
				return -1;
			} else if (this.posicao > o.posicao) {
				return 1;
			} else {
				return 0;
			}
		}
	}	
	
	
}
