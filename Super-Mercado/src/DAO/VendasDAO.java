package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


import Connection.ConnectionFactory;
import Model.Vendas;

public class VendasDAO {

    private Connection connection;
    private List<Vendas> vendas;

    // Construtor
    public VendasDAO() {

        this.connection = ConnectionFactory.getConnection();
        System.out.println("Conexão 'VendasDAO' estabelecida.");
    }

    /* Métodos aqui */

    public void criarTabelaVendas() {
        String sqlCriarTabelaVendas = "CREATE TABLE IF NOT EXISTS venda_mercadoo (CODIGOBARRAS VARCHAR(255), CPF VARCHAR(255), DESCONTO_APLICADO VARCHAR(255), QUANTIDADE VARCHAR(255), TOTAL VARCHAR(255), HORARIO VARCHAR(255), DIA VARCHAR(255))";

        try (Statement stmt = this.connection.createStatement()) {

            /* Ejetor de código SQL */
            stmt.execute(sqlCriarTabelaVendas);
            System.out.println("Tabela 'vendas_mercado' criada com sucesso.");
        } catch (SQLException e) {

            throw new RuntimeException("Erro ao criar a tabela 'venda_mercadoo'.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }


    public double obterPrecoPorCodigoDeBarras(String codigoBarras) {
       
        String sqlBuscarPreco = "SELECT preco FROM produtos WHERE CODIGOBARRAS = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlBuscarPreco)) {

            preparedStatement.setString(1, codigoBarras);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Retorna o preço obtido do banco de dados
                    return resultSet.getDouble("preco");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Lide com as exceções de banco de dados de acordo com sua aplicação
        }

        // Se não encontrou o produto, você pode retornar um valor padrão, como 0.0
        return 0.0;
    }


    public void realizarVenda(String codigoBarras, String cpf, String quantidade, String descontoAplicado,
            String total) {
        PreparedStatement stmtInserir = null;
        PreparedStatement stmtDeletar = null;

        String sqlCadastrarVenda = "INSERT INTO venda_mercadoo (CODIGOBARRAS, cpf, quantidade, desconto_aplicado, total) VALUES(?, ?, ?, ?, ?)";
        String deletarItemVendido = "DELETE FROM produtos_mercado WHERE CODIGOBARRAS = ?";
        try {
            connection.setAutoCommit(false);
            stmtInserir = this.connection.prepareStatement(sqlCadastrarVenda);

            /* Ejetor SQL */
            stmtInserir.setString(1, codigoBarras);
            stmtInserir.setString(2, cpf);
            stmtInserir.setString(3, quantidade);
            stmtInserir.setString(4, descontoAplicado);
            stmtInserir.setString(5, total);

            int linhasAfetadasInserir = stmtInserir.executeUpdate();

            // Deletar item vendido
            stmtDeletar = connection.prepareStatement(deletarItemVendido);
            stmtDeletar.setString(1, codigoBarras);

            int linhasAfetadasDeletar = stmtDeletar.executeUpdate();

            // Verifica se ambas acoes foram realizadas
            if (linhasAfetadasInserir > 0 && linhasAfetadasDeletar > 0) {
                connection.commit();// confirma a opereção
                System.out.println("Venda realizada com sucesso.");
            } else {
                connection.rollback();// reverte a opereção, caso haja falhas
                System.out.println("[Falha] Não foi possível realizar a venda.");
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            System.out.println("Não foi possível realizar a venda.");
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);//Retorna ao modo autocommit
                ConnectionFactory.closeConnection(connection);
                ConnectionFactory.closeConnection(stmtInserir);
                ConnectionFactory.closeConnection(stmtDeletar);
            } catch (Exception e) {
                System.out.println("Não foi possível fechar as conexões em realizarVenda.");
                e.printStackTrace();
            }
        }

    }

}
