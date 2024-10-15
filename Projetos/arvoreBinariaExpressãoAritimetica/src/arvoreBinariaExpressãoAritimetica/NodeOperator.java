//Feito por Matheus Hidalgo do Nascimento Fest Ferreira
package arvoreBinariaExpressãoAritimetica;

// Classe que representa um nó operador na árvore
public class NodeOperator extends Node {
    private char operator; // O operador (+, -, *, /)
    private Node left; // Filho à esquerda
    private Node right; // Filho à direita

    // Construtor para o nó operador
    public NodeOperator(char operator, Node left, Node right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public char getOperator() {
        return operator; // Retorna o operador
    }

    public Node getLeft() {
        return left; // Retorna o filho à esquerda
    }

    public Node getRight() {
        return right; // Retorna o filho à direita
    }

    // Avalia a expressão do nó operador
    @Override
    public float visit() {
        switch (operator) {
            case '+':
                return left.visit() + right.visit(); // Soma
            case '-':
                return left.visit() - right.visit(); // Subtração
            case '*':
                return left.visit() * right.visit(); // Multiplicação
            case '/':
                return left.visit() / right.visit(); // Divisão
            default:
                return Float.NaN; // Retorna NaN para operador inválido
        }
    }
}

