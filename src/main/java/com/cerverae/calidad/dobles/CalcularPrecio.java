package com.cerverae.calidad.dobles;



public class CalcularPrecio {

	public float precioProducto;
	public float porcentaje;
	public CalcularIVA formulaIVA;
	
	public CalcularPrecio() {
		precioProducto = 100;
		porcentaje = .16f;
	}
	
	public float calcularIva(CalcularIVA formula) {
		 formulaIVA = formula;
		 float iva = formulaIVA.getIVA(porcentaje, precioProducto);
		 return iva + precioProducto;
	}
}
