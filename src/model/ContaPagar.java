/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author ls
 */
public class ContaPagar {
    
    int id;
    String identificacao_da_conta;
    float valor;
    String tipo_de_conta;
    String fornecedor_ou_beneficiario;
    String recorrencia;
    String data_pagamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificacao_da_conta() {
        return identificacao_da_conta;
    }

    public void setIdentificacao_da_conta(String identificacao_da_conta) {
        this.identificacao_da_conta = identificacao_da_conta;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipo_de_conta() {
        return tipo_de_conta;
    }

    public void setTipo_de_conta(String tipo_de_conta) {
        this.tipo_de_conta = tipo_de_conta;
    }

    public String getFornecedor_ou_beneficiario() {
        return fornecedor_ou_beneficiario;
    }

    public void setFornecedor_ou_beneficiario(String fornecedor_ou_beneficiario) {
        this.fornecedor_ou_beneficiario = fornecedor_ou_beneficiario;
    }

    public String getRecorrencia() {
        return recorrencia;
    }

    public void setRecorrencia(String recorrencia) {
        this.recorrencia = recorrencia;
    }

    public String getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    
}
