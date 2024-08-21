package com.example.demo.enums;

public enum TipoRegistro {
	HEADER("00"), DETALHE("01"), TRAILLER("99");

	private TipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	private String tipoRegistro;

	public String getTipoRegistro() {
		return this.tipoRegistro;
	}

	public String toString() {
		return this.tipoRegistro;
	}
}
