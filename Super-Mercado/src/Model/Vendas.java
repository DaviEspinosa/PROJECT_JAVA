package Model;

public class Vendas {

    //Atributos
    private String codigoBarras;
    private String clientes;
    private String descontoAplicado;
    private String quantidade;
    private String total;

    //Construtor
    public Vendas(String codigoBarras, String clientes, String descontoAplicado, String quantidade, String total) {
       
        this.codigoBarras = codigoBarras;
        this.clientes = clientes;
        this.descontoAplicado = descontoAplicado;
        this.quantidade = quantidade;
        this.total = total;
    }

    //Getters and Setters
    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setNome(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getClientes() {
        return clientes;
    }

    public void setPreco(String clientes) {
        this.clientes = clientes;
    }

     public String getDescontoAplicado() {
        return descontoAplicado;
    }

    public void setDescontoAplicado(String descontoAplicado) {
        this.descontoAplicado = descontoAplicado;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getTotal() {
        return total;
    }

    public void setCodigoBarra(String total) {
        this.total = total;
    }
}
