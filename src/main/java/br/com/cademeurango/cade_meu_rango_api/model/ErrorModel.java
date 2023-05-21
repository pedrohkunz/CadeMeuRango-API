package br.com.cademeurango.cade_meu_rango_api.model;

public class ErrorModel {
    private String erro;


    public ErrorModel(String erro) {
        this.erro = erro;
    }

    public String getErro() {
        return this.erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

}
