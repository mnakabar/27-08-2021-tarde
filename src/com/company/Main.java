package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        ClienteBasico basico = new ClienteBasico("Igor", 123456, "12345678911", 10000.0);
        ClienteExecutivo executivo = new ClienteExecutivo("Mauricio", 789456, "98765432199", 50000.0);
        ClienteColetor coletor = new ClienteColetor("Camila", 456123, "65498732155", 60000.0);

        List<ClienteBasico> clientesBasicos = new ArrayList<ClienteBasico>();
        List<ClienteExecutivo> clientesExecutivos = new ArrayList<ClienteExecutivo>();
        List<ClienteColetor> clientesColetores = new ArrayList<ClienteColetor>();

        clientesBasicos.add(basico);
        clientesExecutivos.add(executivo);
        clientesColetores.add(coletor);

        System.out.println("Para começar vamos preciso te localizar, você prefere ser localizado pelo CPF ou pelo numero da Conta!");
        System.out.println("1 - Para CPF");
        System.out.println("2 - Para Numero de conta");

        int opcao = teclado.nextInt();
        teclado.nextLine();

        ClienteBasico clienteBasico  = null;
        ClienteExecutivo clienteExecutivo = null;
        ClienteColetor clientesColetor = null;

        if(opcao == 1){
            System.out.println("Certo me informe seu CPF");
            String cpf = teclado.nextLine();

            clienteBasico = clientesBasicos
                    .stream().filter(c -> c.BuscarConta(0, cpf)).findAny().orElse(null);

            clienteExecutivo = clientesExecutivos
                    .stream().filter(c -> c.BuscarConta(0, cpf)).findAny().orElse(null);

            clientesColetor = clientesColetores
                    .stream().filter(c -> c.BuscarConta(0, cpf)).findAny().orElse(null);
        }
        else{
            System.out.println("Certo me informe o numero da sua conta");
            int numConta = teclado.nextInt();
            teclado.nextLine();

            clienteBasico = clientesBasicos
                    .stream().filter(c -> c.BuscarConta(numConta, null)).findAny().orElse(null);

            clienteExecutivo = clientesExecutivos
                    .stream().filter(c -> c.BuscarConta(numConta, null)).findAny().orElse(null);

            clientesColetor = clientesColetores
                    .stream().filter(c -> c.BuscarConta(numConta, null)).findAny().orElse(null);
        }

        if(clienteBasico != null)
        {
            System.out.println("A sua conta permite as seguintes opções:");
            System.out.println("1 - Consulta de Saldo");
            System.out.println("2 - Pagamento de Serviços");
            System.out.println("3 - Saque em dinheiro");
            System.out.println("4 - Encerrar");
            opcao = teclado.nextInt();
            teclado.nextLine();
            boolean finalizar = false;

            do{
                if(opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4){
                    System.out.println("Opção invalida!");
                }
                else{
                    if(opcao == 4){
                        finalizar = true;
                    }
                    else{
                        switch(opcao){
                            case 1:
                                double saldo = clienteBasico.ConsultarSaldo();
                                System.out.println("Seu saldo é "+ saldo);
                                break;
                            case 2:
                                System.out.println("Informe o valor a ser pago!");
                                double valor = teclado.nextDouble();
                                clienteBasico.Pagamento(valor);
                                break;
                            case 3:
                                System.out.println("Informe o valor do saque!");
                                double saque = teclado.nextDouble();
                                clienteBasico.Saque(saque);
                                break;
                            case 4:
                                finalizar = true;
                        }

                        System.out.println("O que quer fazer agora?");
                        System.out.println("1 - Consulta de Saldo");
                        System.out.println("2 - Pagamento de Serviços");
                        System.out.println("3 - Saque em dinheiro");
                        System.out.println("4 - Encerrar");
                        opcao = teclado.nextInt();
                        teclado.nextLine();
                    }
                }

            }while(!finalizar);
        }
        else if(clienteExecutivo != null)
        {
            System.out.println("A sua conta permite as seguintes opções:");
            System.out.println("1 - Deposito");
            System.out.println("2 - Transferencia");
            System.out.println("3 - Encerrar");
            opcao = teclado.nextInt();
            teclado.nextLine();
            boolean finalizar = false;

            do{
                if(opcao != 1 && opcao != 2 && opcao != 3){
                    System.out.println("Opção invalida!");
                }
                else{
                    if(opcao == 3){
                        finalizar = true;
                    }
                    else{
                        switch(opcao){
                            case 1:
                                System.out.println("Informe o valor a ser depositado!");
                                double valor = teclado.nextDouble();
                                clienteExecutivo.Deposito(valor);
                                break;
                            case 2:
                                System.out.println("Informe o valor a ser transferido!");
                                double transferencia = teclado.nextDouble();
                                System.out.println("Informe o numero da conta para ser transferido");
                                int numConta = teclado.nextInt();
                                clienteExecutivo.Transferencia(transferencia, numConta);
                                break;
                            case 3:
                                finalizar = true;
                        }

                        System.out.println("O que quer fazer agora?");
                        System.out.println("1 - Deposito");
                        System.out.println("2 - Transferencia");
                        System.out.println("3 - Encerrar");
                        opcao = teclado.nextInt();
                        teclado.nextLine();
                    }
                }


            }while(!finalizar);
        }
        else if(clientesColetor != null)
        {
            System.out.println("A sua conta permite as seguintes opções:");
            System.out.println("1 - Consulta de Saldo");
            System.out.println("2 - Saque");
            System.out.println("3 - Encerrar");
            opcao = teclado.nextInt();
            teclado.nextLine();
            boolean finalizar = false;

            do{
                if(opcao != 1 && opcao != 2 && opcao != 3){
                    System.out.println("Opção invalida!");
                }
                else{
                    if(opcao == 4){
                        finalizar = true;
                    }
                    else{
                        switch(opcao){
                            case 1:
                                System.out.println("Seu saldo é " + clientesColetor.ConsultarSaldo());
                                break;
                            case 2:
                                System.out.println("Informe o valor do saque!");
                                double saque = teclado.nextDouble();
                                clientesColetor.Saque(saque);
                                break;
                            case 3:
                                finalizar = true;
                        }

                        System.out.println("O que quer fazer agora?");
                        System.out.println("1 - Consulta de Saldo");
                        System.out.println("2 - Saque");
                        System.out.println("3 - Encerrar");
                        opcao = teclado.nextInt();
                        teclado.nextLine();
                    }
                }


            }while(!finalizar);
        }
        else
        {
            System.out.println("Conta não encontrada!");
        }

        System.out.println("Até logo!");
    }
}
