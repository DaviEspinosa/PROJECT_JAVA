package Model;

public class Produtos {
    
    //atributos
    private String nome;
    private String preco;
    private String quantidade;
    private String codigoBarra;
    
    //construtor
    public Produtos(String nome, String preco, String quantidade, String codigoBarra){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.codigoBarra = codigoBarra;
    }

    //getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    
}
