/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ticketmachine.core;

public class PapelMoeda {

	protected double valor;
	protected int quantidade;
        protected boolean isNota;

	public PapelMoeda(double valor, int quantidade, boolean isNota) {
		this.valor = valor;
		this.quantidade = quantidade;
                this.isNota = isNota;
	}

	public double getValor() {
		return valor;
	}

	public int getQuantidade() {
		return quantidade;
	}
        
        public boolean getisNota(){
            return isNota;
        }
}