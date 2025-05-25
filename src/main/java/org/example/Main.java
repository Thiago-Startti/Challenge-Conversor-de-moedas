package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        ArquivoDeCotacao arquivo = new ArquivoDeCotacao();

        System.out.println("Bem vindo ao Alura-Exchange!");
        System.out.println("Seu conversor de moedas prático e rápido!");

        while (true) {
            String moedaOrigem;
            String moedaDestino;

        System.out.println("\nEscolha a moeda base para cotação: ");
        System.out.println("__________Menu de Moedas__________");
        System.out.println("1. BRL - Real Brasileiro");
        System.out.println("2. USD - Dólar Americano");
        System.out.println("3. EUR - Euro");
        System.out.println("4. JPY - Iene Japonês");
        System.out.println("5. CNY - Renminbi Chinês");
        System.out.println("6. ARS - Peso Argentino");
        var opcaoOrigem = scanner.nextInt();

        if (opcaoOrigem == 1) {
            moedaOrigem = "BRL";
        } else if (opcaoOrigem == 2) {
            moedaOrigem = "USD";
        } else if (opcaoOrigem == 3) {
            moedaOrigem = "EUR";
        } else if (opcaoOrigem == 4) {
            moedaOrigem ="JPY";
        } else if (opcaoOrigem == 5) {
            moedaOrigem = "CNY";
        } else if (opcaoOrigem == 6) {
            moedaOrigem = "ARS";
        } else {
            throw new IllegalArgumentException("Opção inválida.");
        }

        System.out.println("Escolha a moeda de comparação: ");
        System.out.println("__________Menu de Moedas__________");
        System.out.println("1. BRL - Real Brasileiro");
        System.out.println("2. USD - Dólar Americano");
        System.out.println("3. EUR - Euro");
        System.out.println("4. JPY - Iene Japonês");
        System.out.println("5. CNY - Renminbi Chinês");
        System.out.println("6. ARS - Peso Argentino");
        var opcaoDestino = scanner.nextInt();

        if (opcaoDestino == 1) {
            moedaDestino = "BRL";
        } else if (opcaoDestino == 2) {
            moedaDestino = "USD";
        } else if (opcaoDestino == 3) {
            moedaDestino = "EUR";
        } else if (opcaoDestino == 4) {
            moedaDestino ="JPY";
        } else if (opcaoDestino == 5) {
            moedaDestino = "CNY";
        } else if (opcaoDestino == 6) {
            moedaDestino = "ARS";
        } else {
            throw new IllegalArgumentException("Opção inválida.");
        }

        System.out.println("Agora digite um valor para conversão: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Voce escolheu: " + moedaOrigem + " como sua moeda base");
        System.out.println("Voce escolheu: " + moedaDestino + " como sua moeda para comparação");

        try {
            Cambio cambio = client.consultaCambio(moedaOrigem, moedaDestino, valor);
            System.out.println(valor + " - " + moedaOrigem);
            System.out.println("Equivale a: " + cambio.valorConvertido() + " - " + moedaDestino);
            arquivo.salvaJson(cambio);
        } catch (Exception e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }

            System.out.println("\nDeseja fazer outra conversão? (s/n)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n") || resposta.equalsIgnoreCase("não") || resposta.equalsIgnoreCase("nao")) {
                System.out.println("Obrigado por usar o Alura-Exchange. Até mais!");
                break;
            }
        }

        scanner.close();
   }
}
