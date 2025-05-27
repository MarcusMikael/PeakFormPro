
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.Equipamento;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Corredor;


public class EquipamentoDAO implements EquipamentoDAOI {

    @Override
    public void inserir(Equipamento eq) {
        String sql = "INSERT INTO equipamento (tipo, marca, modelo, corredor_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            p.setString(1, eq.getTipo());
            p.setString(2, eq.getMarca());
            p.setString(3, eq.getModelo());
            p.setInt(4, eq.getCorredor().getId());

            p.executeUpdate();

            System.out.println("Equipamento inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir equipamento: " + e.getMessage());
        }
    }

    @Override
    public List<Equipamento> listarTodos() {
        List<Equipamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipamento";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement p = conn.prepareStatement(sql);
             ResultSet rs = p.executeQuery()) {
            
            CorredorDAO corredorDAO = new CorredorDAO();

            while (rs.next()) {
                Equipamento eq = new Equipamento();
                eq.setId(rs.getInt("id_equipamento"));
                eq.setTipo(rs.getString("tipo"));
                eq.setMarca(rs.getString("marca"));
                eq.setModelo(rs.getString("modelo"));

                int corredorId = rs.getInt("corredor_id");
                Corredor corredor = corredorDAO.buscarPorId(corredorId);
                eq.setCorredor(corredor);

                lista.add(eq);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar equipamentos: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public void atualizar(Equipamento e) {
        String sql = "UPDATE equipamento SET tipo = ?, marca = ?, modelo = ?, corredor_id = ? WHERE id_equipamento = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            p.setString(1, e.getTipo());
            p.setString(2, e.getMarca());
            p.setString(3, e.getModelo());
            p.setInt(4, e.getCorredor().getId());
            p.setInt(5, e.getId());

            p.executeUpdate();

            System.out.println("Equipamento atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar equipamento: " + ex.getMessage());
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM equipamento WHERE id_equipamento = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            p.setInt(1, id);

            int linhasAfetadas = p.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Equipamento excluído com sucesso!");
            } else {
                System.out.println("Nenhum equipamento encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir equipamento: " + e.getMessage());
        }
    }
    
    @Override
public Equipamento buscarPorId(int id) {
    String sql = "SELECT * FROM equipamento WHERE id_equipamento = ?";
    Equipamento eq = null;

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement p = conn.prepareStatement(sql)) {

        p.setInt(1, id);
        ResultSet rs = p.executeQuery();

        if (rs.next()) {
            eq = new Equipamento();
            eq.setId(rs.getInt("id_equipamento"));
            eq.setTipo(rs.getString("tipo"));
            eq.setMarca(rs.getString("marca"));
            eq.setModelo(rs.getString("modelo"));

            int corredorId = rs.getInt("corredor_id");
            CorredorDAO corredorDAO = new CorredorDAO();
            Corredor corredor = corredorDAO.buscarPorId(corredorId);
            eq.setCorredor(corredor);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao buscar equipamento: " + e.getMessage());
    }

    return eq;
}
}
