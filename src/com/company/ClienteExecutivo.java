package com.company;

public class ClienteExecutivo extends Cliente {

    public ClienteExecutivo(String nome, int numeroConta, String cpf, double saldo) {
        super(nome, numeroConta, cpf, saldo);
    }

    public void Deposito(double valor){
        if(this.InserirDinheiro(valor)){
            System.out.println("Deposito realizado com sucesso, o saldo atual é: " + this.ConsultarSaldo());
        }
        else{
            System.out.println("Não foi possivel realizar o deposito, valor do deposito deve ser positivo");
        }
    }

    public void Transferencia(double valor, int numConta){
        if(this.RetirarDinheiro(valor)){
            System.out.println("Transferencia para a conta " + numConta +" realizado com sucesso, o saldo atual é: " + this.ConsultarSaldo());
        }
        else{
            System.out.println("Não foi possivel realizar a Transferencia.");
        }
    }
}