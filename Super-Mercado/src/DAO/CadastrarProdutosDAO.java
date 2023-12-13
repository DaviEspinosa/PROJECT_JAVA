package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Model.Produtos;

public class CadastrarProdutosDAO {
    
    private Connection connection;
    private List<Produtos> produtos;

    public CadastrarProdutosDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

        //criar Tabela
        public void criarTabela() {

            //Criando Tabela Caso Não Exista
            String sql = "CREATE TABLE IF NOT EXISTS produtos_mercado ( NOME VARCHAR(30),PRECO VARCHAR(255),QUANTIDADE VARCHAR(255),CODIGOBARRAS VARCHAR(255) PRIMARY KEY)";
            try (Statement stmt = this.connection.createStatement()) {https://github.com/IgorOliverx/React_laravel.git
                // Statement executando o sql para criar a tabela 
                stmt.execute(sql);
                System.out.println("Tabela criada com sucesso.");
            } catch (SQLException e) {
                //Caso ocorra um erro, prinatr
                throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
            } finally {
                //Obrigatoriamente fecha conexão
                ConnectionFactory.closeConnection(this.connection);
            }
        }


        //Cadastrar Carro no banco
    public void cadastrar(String nome, String preco, String quantidade, String codigoBarra) {
        PreparedStatement stmt = null;
        // Define a instrução para cadastrar na tabela
        String sql = "INSERT INTO produtos_mercado (nome, preco, quantidade, codigo) VALUES (?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, preco);
            stmt.setString(3, quantidade);
            stmt.setString(4, codigoBarra);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException( e + " Erro ao inserir dados no banco de dados." );
        } finally {
            ConnectionFactory.closeConnection(connection,stmt);
        }
    }

            // Listar todos os valores cadastrados
    public List<Produtos> listarTodos() {
        PreparedStatement stmt = null; //objeto PreparedStatement para executar a consulta
        ResultSet rs = null; // objeto ResultSet para armazenar os resultados da consulta
        produtos = new ArrayList<>(); // Cria uma lista para armazenar os carros recuperados do banco de dados
    
        try {
            stmt = connection.prepareStatement("select * from produtos_mercado"); 
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery(); 
            // Executa a consulta e armazena os resultados no ResultSet
            
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Carros com os valores do registro
                Produtos produto = new Produtos(
                    rs.getString("nome"),
                    rs.getString("preço"),
                    rs.getString("quantidade"),
                    rs.getString("código")
                );
                produtos.add(produto); // Adiciona o objeto produto à lista de produtos
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {

            ConnectionFactory.closeConnection(connection, stmt, rs); // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return produtos; // Retorna a lista de carros recuperados do banco de dados
    }
}
