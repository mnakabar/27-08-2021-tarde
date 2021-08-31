package com.company;

public class ClienteColetor extends Cliente {

    public ClienteColetor(String nome, int numeroConta, String cpf, double saldo) {
        super(nome, numeroConta, cpf, saldo);
    }

    public void Saque(double valor){
        if(this.RetirarDinheiro(valor)){
            System.out.println("Saque realizado com sucesso, o saldo atual é: " + this.ConsultarSaldo());
        }
        else{
            System.out.println("Não foi possivel realizar o Saque, valor do saque não pode ser maior que o saldo atual!");
        }
    }
}
