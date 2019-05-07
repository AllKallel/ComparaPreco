package br.com.comparapreo;

import java.io.Serializable;

public class Combustivel implements Serializable {
    String etanol;
    String gas;

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getEtanol() {
        return etanol;
    }

    public void setEtanol(String etanol) {
        this.etanol = etanol;
    }
}
