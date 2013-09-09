package br.com.atech.tddcourse.autonomia;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AutonomiaTest {

	private PlanoDeVoo plano;

	@Before
	public void testSetup() {
		plano = new PlanoDeVoo();
	}

	@Test
	//o - Voo internacional = Autonomia >= EET
	public void testAutonomiaRequeridaParaVooInternacional() {
		plano.setTipo(TipoDePlano.INTERNACIONAL);
		plano.setEET(100);

		assertTrue("Autonomia requerida maior ou igual ao EET",//
				plano.getAutonomiaRequerida() >= plano.getEET());
	}
	
	@Test
	//x - Tipo de voo VISUAL, diurno e tipo de equipamento ASA FIXA, autonomia deve ser maior ou igual a EET + 30
	public void testAutonomiaRequeridaParaVooNacionalTipoVisualDiurnoComEqptAsaFixa(){
		
		plano.setTipo(TipoDePlano.NACIONAL);
		plano.setTipoEquipamento(TipoDeEquipamento.ASA_FIXA);
		plano.setPeriodoDoVoo(PeriodoDoVoo.DIURNO);
		plano.setEET(100);
		
		assertTrue("Autonomia requerida maior ou igual ao EET + 30",//
				plano.getAutonomiaRequerida() >= plano.getEET() + 30);
	}

}
