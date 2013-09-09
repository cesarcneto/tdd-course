package br.com.atech.tddcourse.autonomia;

public class PlanoDeVoo {

	private int eet;
	private TipoDePlano tipoDoPlano;

	public TipoDePlano getTipoDoPlano() {
		return tipoDoPlano;
	}

	public TipoDeEquipamento getTipoEquipamento() {
		return tipoEquipamento;
	}

	public PeriodoDoVoo getPeriodoDoVoo() {
		return periodoDoVoo;
	}

	private TipoDeEquipamento tipoEquipamento;
	private PeriodoDoVoo periodoDoVoo;

	public int getAutonomiaRequerida() {

		if (TipoDePlano.INTERNACIONAL.equals(tipoDoPlano)) {
			return eet;
		}

		if (TipoDePlano.NACIONAL.equals(tipoDoPlano)) {
			if (TipoDeEquipamento.ASA_FIXA.equals(tipoEquipamento) //
					&& PeriodoDoVoo.DIURNO.equals(periodoDoVoo)) {
				return eet + 30;
			}
		}

		return 0;
	}

	public int getEET() {
		return eet;
	}

	public void setEET(int eet) {
		this.eet = eet;
	}

	public void setTipo(TipoDePlano tipo) {
		this.tipoDoPlano = tipo;
	}

	public void setTipoEquipamento(TipoDeEquipamento tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}

	public void setPeriodoDoVoo(PeriodoDoVoo periodo) {
		this.periodoDoVoo = periodo;

	}

}
