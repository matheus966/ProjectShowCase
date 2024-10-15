//Feito por Matheus Hidalgo do Nascimento Fest Ferreira
package arvoreBinariaExpressãoAritimetica;

// Classe que representa um nó operando na árvore
public class NodeOperand extends Node {
    private float value; // O valor do operando

    // Construtor para o nó operando
    public NodeOperand(float value) {
        this.value = value;
    }

    public float getValue() {
        return value; // Retorna o valor do operando
    }

    // Retorna o valor do nó operando
    @Override
    public float visit() {
        return value; // Retorna o valor do operando
    }
}

