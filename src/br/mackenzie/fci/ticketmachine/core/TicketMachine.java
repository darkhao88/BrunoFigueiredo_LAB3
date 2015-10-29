/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ticketmachine.core;

import br.mackenzie.fci.ticketmachine.exception.PapelMoedaInvalidaException;
import br.mackenzie.fci.ticketmachine.exception.SaldoInsuficienteException;
import java.math.BigDecimal;
import java.util.Iterator;

public class TicketMachine {

    protected double valor;
    protected double saldo;
    protected double[] papelMoeda = {0.01, 0.05, 0.1, 0.25, 0.5, 1, 2, 5, 10, 20, 50, 100};

    public TicketMachine(double valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(double quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = new BigDecimal(saldo).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public Iterator<PapelMoeda> getTroco() {
        return null;
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}