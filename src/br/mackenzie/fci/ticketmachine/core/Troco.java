/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ticketmachine.core;

import java.math.BigDecimal;
import java.util.Iterator;

class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(double valor) {
        papeisMoeda = new PapelMoeda[13];
        int count = 0;
        while (valor - 100 >= 0 && valor > 0) {
            count++;
            valor = valor - 100;
        }
        valor = new BigDecimal(valor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        papeisMoeda[12] = new PapelMoeda(100, count, true);
        count = 0;
        while (valor - 50 >= 0 && valor > 0) {
            count++;
            valor = valor - 50;
        }
        valor = new BigDecimal(valor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        papeisMoeda[11] = new PapelMoeda(50, count, true);
        count = 0;
        while (valor - 20 >= 0 && valor > 0) {
            count++;
            valor = valor - 20;
        }
        valor = new BigDecimal(valor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        papeisMoeda[10] = new PapelMoeda(20, count, true);
        count = 0;
        while (valor - 10 >= 0 && valor > 0) {
            count++;
            valor = valor - 10;
        }
        valor = new BigDecimal(valor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        papeisMoeda[9] = new PapelMoeda(10, count, true);
        count = 0;
        while (valor - 5 >= 0 && valor > 0) {
            count++;
            valor = valor - 5;
        }
        valor = new BigDecimal(valor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        papeisMoeda[8] = new PapelMoeda(5, count, true);
        count = 0;
        while (valor - 2 >= 0 && valor > 0) {
            count++;
            valor = valor - 2;
        }
        valor = new BigDecimal(valor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        papeisMoeda[7] = new PapelMoeda(2, count, true);
        count = 0;
        while (valor - 1 >= 0 && valor > 0) {
            count++;
            valor = valor - 1;
        }
        valor = new BigDecimal(valor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        papeisMoeda[6] = new PapelMoeda(1, count, false);
        count = 0;
        while (valor - 0.5 >= 0 && valor > 0) {
            count++;
            valor = valor - 0.5;
        }
        valor = new BigDecimal(valor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        papeisMoeda[5] = new PapelMoeda(0.5, count, false);
        count = 0;
        while (valor - 0.25 >= 0 && valor > 0) {
            count++;
            valor = valor - 0.25;
        }
        valor = new BigDecimal(valor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        papeisMoeda[4] = new PapelMoeda(0.25, count, false);
        count = 0;
        while (valor - 0.1 >= 0 && valor > 0) {
            count++;
            valor = valor - 0.1;
        }
        valor = new BigDecimal(valor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        papeisMoeda[3] = new PapelMoeda(0.1, count, false);
        count = 0;
        while (valor - 0.05 >= 0 && valor > 0) {
            count++;
            valor = valor - 0.05;
        }
        valor = new BigDecimal(valor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        papeisMoeda[2] = new PapelMoeda(0.05, count, false);
        count = 0;
        while (valor - 0.01 >= 0 && valor > 0) {
            count++;
            valor = valor - 0.01;
        }
        valor = new BigDecimal(valor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        papeisMoeda[1] = new PapelMoeda(0.01, count, false);
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }
    
    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 12; i >= 1; i--) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 12; i >= 1; i--) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                    return ret;
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            next();
        }
    }
}