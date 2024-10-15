//Feito por Matheus Hidalgo do Nascimento Fest Ferreira
package arvoreBinariaExpressãoAritimetica;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // Criação de um scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        String expression = "";
        BinaryTree binaryTree = new BinaryTree(); // Instancia a árvore binária
        boolean exit = false;

        // Loop principal do menu
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1) Entrada da expressão");
            System.out.println("2) Criação da árvore");
            System.out.println("3) Exibição da árvore");
            System.out.println("4) Cálculo da expressão");
            System.out.println("5) Encerramento do programa");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            // Switch para lidar com as opções do menu
            switch (choice) {
                case 1:
                    // Lê a expressão aritmética do usuário
                    System.out.print("\nDigite a expressão aritmética: ");
                    expression = scanner.nextLine().replaceAll("\\s", ""); // Remove espaços
                    if (isValidInfix(expression)) {
                        System.out.println("Expressão válida!");
                    } else {
                        System.out.println("Expressão inválida!");
                        expression = ""; // Reseta a expressão se inválida
                    }
                    break;

                case 2:
                    // Cria a árvore binária se a expressão for válida
                    if (expression.isEmpty()) {
                        System.out.println("Primeiro, insira uma expressão válida!");
                    } else {
                        binaryTree.buildTree(expression);
                        System.out.println("Árvore criada com sucesso!");
                    }
                    break;

                case 3:
                    // Exibe a árvore em pré-ordem, em ordem e pós-ordem
                    Node root = binaryTree.getRoot();
                    if (root != null) {
                        System.out.print("Pré-ordem: ");
                        binaryTree.preOrder(root);
                        System.out.println();
                        System.out.print("Em ordem: ");
                        binaryTree.inOrder(root);
                        System.out.println();
                        System.out.print("Pós-ordem: ");
                        binaryTree.postOrder(root);
                        System.out.println();
                    } else {
                        System.out.println("Árvore ainda não foi criada.");
                    }
                    break;

                case 4:
                    // Calcula e exibe o resultado da expressão
                    root = binaryTree.getRoot();
                    if (root != null) {
                        float result = binaryTree.evaluate();
                        System.out.println("Resultado da expressão: " + result);
                    } else {
                        System.out.println("Árvore ainda não foi criada.");
                    }
                    break;

                case 5:
                    // Encerra o programa
                    exit = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close(); // Fecha o scanner ao final do programa
    }

    // Método para validar a expressão infixa
    static boolean isValidInfix(String expression) {
        Stack<Character> stack = new Stack<>(); // Pilha para verificar parênteses
        boolean lastWasOperator = true; // Para validar operadores
        boolean pointUsed = false; // Para controlar pontos em números decimais

        // Verifica se a expressão começa ou termina com operadores inválidos
        if (expression.startsWith(".") || expression.startsWith("*") || expression.startsWith("/") ||
                expression.startsWith("+") || expression.startsWith("-")) {
            return false;
        }
        if (expression.endsWith(".") || expression.endsWith("*") || expression.endsWith("/") ||
                expression.endsWith("+") || expression.endsWith("-")) {
            return false;
        }

        // Validação dos caracteres da expressão
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                lastWasOperator = false;
                pointUsed = false;
            } else if (c == '.') {
                if (pointUsed) {
                    return false; // Não permite múltiplos pontos
                }
                pointUsed = true;
            } else if (c == '(') {
                stack.push(c);
                lastWasOperator = true; // Abre um novo escopo
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false; // Verifica se os parênteses estão balanceados
                }
                lastWasOperator = false;
            } else if ("+-*/".indexOf(c) != -1) {
                if (lastWasOperator) {
                    return false; // Não permite operadores consecutivos
                }
                lastWasOperator = true;
            } else if (!Character.isWhitespace(c)) {
                return false; // Caracteres inválidos
            }
        }

        return stack.isEmpty() && !lastWasOperator; // Verifica se todos os parênteses foram fechados e se a expressão é válida
    }
}

