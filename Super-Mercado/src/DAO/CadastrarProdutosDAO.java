// // package DAO;

// // import java.sql.Connection;
// // <<<<<<< HEAD
// // import java.sql.SQLException;
// // =======
// // >>>>>>> 981fe96ac053a52dc9defa774c0be3eb69c016b0
// // import java.sql.PreparedStatement;
// // import java.sql.ResultSet;
// // import java.sql.Statement;
// // import java.util.ArrayList;
// // import java.util.List;
// // <<<<<<< HEAD

// // import javax.swing.JOptionPane;

// // import Connection.ConnectionFactory;
// // import Model.Clientes;
// // public class CadastrarProdutosDAO {
// //  private Connection connection;
// //     private List<Clientes> clientes;

// //     public CadastrarProdutosDAO() {

// //         this.connection = ConnectionFactory.getConnection();
// //         System.out.println("Conexão 'ClientesVipDao' estabelecida.");
// //     }

// //     /* Métodos aqui */

// //     public void criarTabelaCliente() {
// //         String sqlCriarTabelaCliente = "CREATE TABLE IF NOT EXISTS clientes_mercado (CPF VARCHAR(11) PRIMARY KEY NOT NULL, TELEFONE VARCHAR(255), EMAIL VARCHAR(255), ENDERECO VARCHAR(255))";

// //         try (Statement stmt = this.connection.createStatement()) {

// //             /* Ejetor de código SQL */
// //             stmt.execute(sqlCriarTabelaCliente);
// //             System.out.println("Tabela 'clientes_mercado' criada com sucesso.");
// //         } catch (SQLException e) {

// //             throw new RuntimeException("Erro ao criar a tabela 'clients-mercado'.", e);
// //         } finally {
// //             ConnectionFactory.closeConnection(this.connection);
// //         }
// //     }

// //     /* Listar todos */

// //     public List<Clientes> listarTodosClientes() {
// //         PreparedStatement stmt = null;
// //         ResultSet rs = null;
// //         /* Instanciando clientes */
// //         clientes = new ArrayList<>();

// //         try {
// //             stmt = this.connection.prepareStatement("SELECT * FROM clientes_mercado");
// //             rs = stmt.executeQuery();

// //             while (rs.next()) {
// //                 Clientes clientes = new Clientes(
// //                         rs.getString("cpf"),
// //                         rs.getString("telefone"),
// //                         rs.getString("email"),
// //                         rs.getString("endereco"));
// //                 this.clientes.add(clientes);
// //             }
// //         } catch (SQLException e) {
// //             System.out.println("Erro ao listar 'clientes'");
// //             e.printStackTrace();
// //         } finally {
// //             try {
// //                 ConnectionFactory.closeConnection(connection, stmt, rs);
// //             } catch (Exception e) {
// //                 System.out.println("Não foi possível fechar as conexões em listarTodosClientes.");
// //                 e.printStackTrace();
// //             }
// //         }
// //         return clientes;/* Retorno no método */
// //     }

// //     public void cadastrarClientes(String cpf, String telefone, String email, String endereco) {
// //         PreparedStatement stmt = null;

// //         String sqlCadastrarClientes = "INSERT INTO clientes_mercado (cpf, telefone, email, endereco) VALUES (?,?,?,?)";

// //         try {
// //             stmt = this.connection.prepareStatement(sqlCadastrarClientes);

// //             /* Ejetor de SQL */

// //             stmt.setString(1, cpf);
// //             stmt.setString(2, telefone);
// //             stmt.setString(3, email);
// //             stmt.setString(4, endereco);

// //             int linhasAfetadas = stmt.executeUpdate();
// //             System.out.println(linhasAfetadas > 0 ? "Cliente cadastrado com sucesso"
// //                     : "O cliente pode não ter sido cadastrado. Verifique se ele realmente foi cadastrado.");
// //         } catch (SQLException e) {
// //             throw new RuntimeException("Erro ao cadastrar 'cliente'", e);
// //         } finally {
// //             try {
// //                 ConnectionFactory.closeConnection(connection, stmt);
// //             } catch (Exception e) {
// //                 System.out.println("Não foi possível fechar as conexões em cadastrarClientes.");
// //                 e.printStackTrace();
// //             }
// //         }
// //     }

// //     /* Atualizar dados do banco */

// //     public void atualizarClientes(String cpf, String telefone, String email, String endereco) {
// //         PreparedStatement stmt = null;

// //         String sqlAtualizarCliente = "UPDATE clientes_mercado SET telefone = ?, email = ?, endereco = ? WHERE cpf = ?";

// //         try {
// //             stmt = this.connection.prepareStatement(sqlAtualizarCliente);
// //             stmt.setString(1, cpf);
// //             stmt.setString(2, telefone);
// //             stmt.setString(3, email);
// //             stmt.setString(4, endereco);

// //             int linhasAfetadas = stmt.executeUpdate();
// //             System.out.println(linhasAfetadas > 0 ? "Cliente atualizado com sucesso"
// //                     : "O cliente pode não ter tido seus dados atualizados. Verifique se ele realmente teve seus dados atualizados.");
// //         } catch (SQLException e) {
// //             System.out.println("Não foi possível atualizar os dados do 'cliente'");
// //             e.printStackTrace();
// //         }finally{
// //             try {
// //                 ConnectionFactory.closeConnection(connection, stmt);
// //             } catch (Exception e) {
// //                 System.out.println("Não foi possível fechar as conexões em atualizarClientes.");
// //                 e.printStackTrace();
// //             }
// //         }
// //     }

// //     /*Apagar dados do banco */

// //     public void apagarCliente(String cpf){
// //         String menssagem = "Deseja realmente apagar este cliente?";
// //         PreparedStatement stmt = null;

// //         String apagarCliente = "DELETE FROM clientes_mercado WHERE cpf = ?";
// //         try {
// //             int escolhaJOptionP = JOptionPane.showConfirmDialog(null, menssagem);
// //             if (escolhaJOptionP == JOptionPane.YES_OPTION) {
// //                 stmt = this.connection.prepareStatement(apagarCliente);
// //                 stmt.setString(1, cpf);
// //                 stmt.executeUpdate();
// //                 System.out.println("Cliente apagado com sucesso.");
// //             }else if (escolhaJOptionP == JOptionPane.NO_OPTION) {
// //                 return;
// //             }
// //         } catch (SQLException e) {
// //             System.out.println("Oops, talvez o cliente não tenha sido apagado, verifique se ele realmente foi deletado.");
// //         }finally{
// //             try {
// //                 ConnectionFactory.closeConnection(connection, stmt);
// //             } catch (Exception e) {
// //                 System.out.println("Não foi possível fechar as conexões em apagarCliente.");
// //                 e.printStackTrace();
// //             }
// //         }
// //     }
// // }
// // =======
// import java.sql.SQLException;

// import Connection.ConnectionFactory;
// import Model.Produtos;

// public class CadastrarProdutosDAO {
    
//     private Connection connection;
//     private List<Produtos> produtos;

//     public CadastrarProdutosDAO() {
//         this.connection = ConnectionFactory.getConnection();
//     }

//         //criar Tabela
//         public void criarTabela() {

//             //Criando Tabela Caso Não Exista
//             String sql = "CREATE TABLE IF NOT EXISTS produtos_mercado ( NOME VARCHAR(30),PRECO VARCHAR(255),QUANTIDADE VARCHAR(255),CODIGO VARCHAR(255) PRIMARY KEY)";
//             try (Statement stmt = this.connection.createStatement()) {
//                 // Statement executando o sql para criar a tabela 
//                 stmt.execute(sql);
//                 System.out.println("Tabela criada com sucesso.");
//             } catch (SQLException e) {
//                 //Caso ocorra um erro, prinatr
//                 throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
//             } finally {
//                 //Obrigatoriamente fecha conexão
//                 ConnectionFactory.closeConnection(this.connection);
//             }
//         }


//         //Cadastrar Carro no banco
//     public void cadastrar(String nome, String preco, String quantidade, String codigoBarra) {
//         PreparedStatement stmt = null;
//         // Define a instrução para cadastrar na tabela
//         String sql = "INSERT INTO produtos_mercado (nome, preco, quantidade, codigoBarra) VALUES (?, ?, ?, ?)";
//         try {
//             stmt = connection.prepareStatement(sql);
//             stmt.setString(1, nome);
//             stmt.setString(2, preco);
//             stmt.setString(3, quantidade);
//             stmt.setString(4, codigoBarra);
//             stmt.executeUpdate();
//             System.out.println("Dados inseridos com sucesso");

//         } catch (SQLException e) {
//             throw new RuntimeException( e + " Erro ao inserir dados no banco de dados." );
//         } finally {
//             ConnectionFactory.closeConnection(connection,stmt);
//         }
//     }

//             // Listar todos os valores cadastrados
//     public List<Produtos> listarTodos() {
//         PreparedStatement stmt = null; //objeto PreparedStatement para executar a consulta
//         ResultSet rs = null; // objeto ResultSet para armazenar os resultados da consulta
//         produtos = new ArrayList<>(); // Cria uma lista para armazenar os carros recuperados do banco de dados
    
//         try {
//             stmt = connection.prepareStatement("select * from produtos_mercado"); 
//             // Prepara a consulta SQL para selecionar todos os registros da tabela
//             rs = stmt.executeQuery(); 
//             // Executa a consulta e armazena os resultados no ResultSet
            
//             while (rs.next()) {
//                 // Para cada registro no ResultSet, cria um objeto Carros com os valores do registro
//                 Produtos produto = new Produtos(
//                     rs.getString("nome"),
//                     rs.getString("preço"),
//                     rs.getString("quantidade"),
//                     rs.getString("código")
//                 );
//                 produtos.add(produto); // Adiciona o objeto produto à lista de produtos
//             }
//         } catch (SQLException ex) {
//             System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
//         } finally {

//             ConnectionFactory.closeConnection(connection, stmt, rs); // Fecha a conexão, o PreparedStatement e o ResultSet
//         }
//         return produtos; // Retorna a lista de carros recuperados do banco de dados
//     }
// }
// >>>>>>> 981fe96ac053a52dc9defa774c0be3eb69c016b0
