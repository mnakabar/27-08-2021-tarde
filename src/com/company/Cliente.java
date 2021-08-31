package com.company;

public abstract class Cliente {
    private String Nome;
    private int NumConta;
    private String Cpf;
    private double Saldo;

    public Cliente(String nome, int numeroConta, String cpf, double saldo){
        this.Nome = nome;
        this.NumConta = numeroConta;
        this.Cpf = cpf;
        this.Saldo = saldo;
    }

    private boolean transactionOk(){
        return true;
    }

    private boolean transactionNoOk(){
        return false;
    }

    protected boolean InserirDinheiro(double valor){
        if(valor >= 0.0){
            this.Saldo += valor;
            return transactionOk();
        }
        else{
            return transactionNoOk();
        }
    }

    protected boolean RetirarDinheiro(double valor){
        if(this.Saldo >= 0.0 && this.Saldo >= valor){
            this.Saldo -= valor;
            return transactionOk();
        }
        else{
            return transactionNoOk();
        }
    }

    public double ConsultarSaldo(){
        return this.Saldo;
    }

    public boolean BuscarConta(int numConta, String cpf){
        if(numConta > 0){
            if(numConta == this.NumConta){
                return true;
            }

            return false;
        }
        else if(cpf != null && cpf.length() > 0){
            if(this.Cpf.equals(cpf)){
                return true;
            }

            return false;
        }

        return false;
    }
}
