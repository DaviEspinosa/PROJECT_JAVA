package Model;

public class Clientes {
    
    //atributos
    private String cpf;
    private String email;
    private String telefone;
 

    //construtor
    public Clientes(String cpf, String email, String telefone, String endereco) {
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;

    }

    //getters and setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    
}
