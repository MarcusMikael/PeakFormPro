// Implementação para a interface do corredor - CorredorDAOI
package dao;

// Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import model.Corredor;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class CorredorDAO implements CorredorDAOI {

    @Override
    public void inserir(Corredor c) { // Para receber um "objeto" corredor e salvar ele no banco de dados
        String sql = "INSERT INTO corredor (nome, email, data_nascimento, sexo, peso, altura, nivel_experiencia) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)"; // Consulta SQL

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) { // Try tenta se conectar com o banco de dados, se ser erro pula pro catch.

            p.setString(1, c.getNome());
            p.setString(2, c.getEmail());
            p.setDate(3, Date.valueOf(c.getDataNascimento()));
            p.setString(4, c.getSexo());
            p.setDouble(5, c.getPeso());
            p.setDouble(6, c.getAltura());
            p.setString(7, c.getNivel_experiencia());

            p.executeUpdate();

            System.out.print("Corredor Inserido no banco de dados!!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dado no banco de dados " + e.getMessage());
        }
    }

    @Override // Sobrescrever um metodo.
    public List<Corredor> listarTodos() {
        List<Corredor> lista = new ArrayList<>();
        String sql = "SELECT * FROM corredor";

        try (Connection conn = ConnectionFactory.getConnection(); // Conexão com o banco de dados.
             PreparedStatement p = conn.prepareStatement(sql); // Execulta comandos SQL com mais segurança.
             ResultSet rs = p.executeQuery()) { // Armazenar os dados da consulta SQL.

            while (rs.next()) { // Vai percorrer os dados do resultSet, e passa pro proximo. 
                Corredor c = new Corredor();
                c.setId(rs.getInt("id_corredor"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                c.setSexo(rs.getString("sexo"));
                c.setPeso(rs.getDouble("peso"));
                c.setAltura(rs.getDouble("altura"));
                c.setNivel_experiencia(rs.getString("nivel_experiencia"));

                lista.add(c); // adicionar os dados na lista.
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar corredores: " + e.getMessage()); // Se ocorrer algum erro, o getMessage vai retorna esse erro.
        }

        return lista;
    }

    @Override
    public void atualizar(Corredor c) {
        String sql = "UPDATE corredor SET nome=?, email=?, data_nascimento=?, sexo=?, peso=?, altura=?, nivel_experiencia=? WHERE id_corredor=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            p.setString(1, c.getNome());
            p.setString(2, c.getEmail());
            p.setDate(3, Date.valueOf(c.getDataNascimento()));
            p.setString(4, c.getSexo());
            p.setDouble(5, c.getPeso());
            p.setDouble(6, c.getAltura());
            p.setString(7, c.getNivel_experiencia());
            p.setInt(8, c.getId());

            p.executeUpdate();

            System.out.println("Atualizado com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar" + e.getMessage());
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM corredor WHERE id_corredor = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            p.setInt(1, id); // define o ID a ser excluído
            int linhasAfetadas = p.executeUpdate(); // executa e retorna quantas linhas foram afetadas

            if (linhasAfetadas > 0) {
                System.out.println("Corredor excluído com sucesso!");
            } else {
                System.out.println("Nenhum corredor encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir corredor: " + e.getMessage());
        }
    }

    @Override
    public Corredor buscarPorId(int id) {
        String sql = "SELECT * FROM corredor WHERE id_corredor = ?";
        Corredor c = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            p.setInt(1, id); // id a ser buscado
            try (ResultSet rs = p.executeQuery()) {
                if (rs.next()) {
                    c = new Corredor();
                    c.setId(rs.getInt("id_corredor"));
                    c.setNome(rs.getString("nome"));
                    c.setEmail(rs.getString("email"));
                    c.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                    c.setSexo(rs.getString("sexo"));
                    c.setPeso(rs.getDouble("peso"));
                    c.setAltura(rs.getDouble("altura"));
                    c.setNivel_experiencia(rs.getString("nivel_experiencia"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar corredor: " + e.getMessage());
        }

        return c;
    }
}
