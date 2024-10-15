//Feito por Matheus Hidalgo do Nascimento Fest Ferreira
package arvoreBinariaExpressãoAritimetica;

import java.util.Stack;

public class BinaryTree {
    private Node root; // Raiz da árvore binária

    // Define a raiz da árvore
    public void setRoot(Node root) {
        this.root = root;
    }

    // Avalia a expressão armazenada na árvore
    public float evaluate() {
        return root.visit(); // Chama o método visit() do nó raiz
    }

    // Exibe a árvore em pré-ordem
    public void preOrder(Node node) {
        if (node != null) {
            // Verifica se o nó é um operador
            if (node instanceof NodeOperator) {
                System.out.print(((NodeOperator) node).getOperator() + " ");
            }
            // Se for um operando, imprime o valor
            else if (node instanceof NodeOperand) {
                System.out.print(((NodeOperand) node).getValue() + " ");
            }
            preOrder(node instanceof NodeOperator ? ((NodeOperator) node).getLeft() : null);
            preOrder(node instanceof NodeOperator ? ((NodeOperator) node).getRight() : null);
        }
    }

    // Exibe a árvore em ordem
    public void inOrder(Node node) {
        if (node != null) {
            if (node instanceof NodeOperator) {
                System.out.print("(");
            }
            inOrder(node instanceof NodeOperator ? ((NodeOperator) node).getLeft() : null);
            if (node instanceof NodeOperator) {
                System.out.print(((NodeOperator) node).getOperator() + " ");
            } else if (node instanceof NodeOperand) {
                System.out.print(((NodeOperand) node).getValue() + " ");
            }
            inOrder(node instanceof NodeOperator ? ((NodeOperator) node).getRight() : null);
            if (node instanceof NodeOperator) {
                System.out.print(")");
            }
        }
    }

    // Exibe a árvore em pós-ordem
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node instanceof NodeOperator ? ((NodeOperator) node).getLeft() : null);
            postOrder(node instanceof NodeOperator ? ((NodeOperator) node).getRight() : null);
            if (node instanceof NodeOperator) {
                System.out.print(((NodeOperator) node).getOperator() + " ");
            } else if (node instanceof NodeOperand) {
                System.out.print(((NodeOperand) node).getValue() + " ");
            }
        }
    }

    // Retorna a raiz da árvore
    public Node getRoot() {
        return root;
    }

    // Constrói a árvore a partir da expressão fornecida
    public void buildTree(String expression) {
        Stack<Node> values = new Stack<>(); // Pilha para armazenar operandos
        Stack<Character> operators = new Stack<>(); // Pilha para armazenar operadores

        // Itera pelos caracteres da expressão
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Se o caractere for um espaço, ignore
            if (Character.isWhitespace(c)) continue;

            // Se o caractere for um número (ou parte de um número)
            if (Character.isDigit(c) || c == '.') {
                StringBuilder buffer = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    buffer.append(expression.charAt(i++));
                }
                values.push(new NodeOperand(Float.parseFloat(buffer.toString())));
                i--; // Decrementar porque o loop aumentará i novamente
            }
            // Se o caractere for '('
            else if (c == '(') {
                operators.push(c); // Adiciona o operador à pilha
            }
            // Se o caractere for ')'
            else if (c == ')') {
                // Adiciona nós até encontrar o correspondente '('
                while (!operators.isEmpty() && operators.peek() != '(') {
                    values.push(createNode(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop(); // Remove '('
            }
            // Se o caractere for um operador
            else if ("+-*/".indexOf(c) != -1) {
                // Adiciona nós enquanto a precedência for maior ou igual
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    values.push(createNode(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(c); // Adiciona o operador atual
            }
        }

        // Adiciona nós restantes na pilha
        while (!operators.isEmpty()) {
            values.push(createNode(operators.pop(), values.pop(), values.pop()));
        }

        root = values.pop(); // O último item da pilha de valores é a raiz da árvore
    }

    // Cria um novo nó operador
    private Node createNode(char operator, Node right, Node left) {
        return new NodeOperator(operator, left, right);
    }

    // Define a precedência dos operadores
    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}
