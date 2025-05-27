package dao;

import model.AvaliacaoTecnica;
import model.Corredor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoTecnicaDAO implements AvaliacaoTecnicaDAOI {

    @Override
    public void inserir(AvaliacaoTecnica a) {
        String sql = "INSERT INTO avaliacao_tecnica (id_corredor, data_avaliacao, frequencia_passos, tempo, observacoes, recomendacoes) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            p.setInt(1, a.getCorredor().getId());
            p.setDate(2, Date.valueOf(a.getDataAvaliacao()));
            p.setInt(3, a.getFrequenciaPassos());
            p.setInt(4, a.getTempo());
            p.setString(5, a.getObservacoes());
            p.setString(6, a.getRecomendacoes());

            p.executeUpdate();
            System.out.println("Avaliação inserida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir avaliação: " + e.getMessage());
        }
    }

    @Override
    public List<AvaliacaoTecnica> listarTodos() {
        List<AvaliacaoTecnica> lista = new ArrayList<>();
        String sql = "SELECT * FROM avaliacao_tecnica";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement p = conn.prepareStatement(sql);
             ResultSet rs = p.executeQuery()) {
            
            CorredorDAO corredorDAO = new CorredorDAO();

            while (rs.next()) {
                AvaliacaoTecnica a = new AvaliacaoTecnica();
                a.setId(rs.getInt("id_avaliacao"));
                a.setDataAvaliacao(rs.getDate("data_avaliacao").toLocalDate());
                a.setFrequenciaPassos(rs.getInt("frequencia_passos"));
                a.setTempo(rs.getInt("tempo"));
                a.setObservacoes(rs.getString("observacoes"));
                a.setRecomendacoes(rs.getString("recomendacoes"));

                int corredorId = rs.getInt("id_corredor");
                Corredor corredor = corredorDAO.buscarPorId(corredorId);
                a.setCorredor(corredor);

                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar avaliações: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public void atualizar(AvaliacaoTecnica a) {
        String sql = "UPDATE avaliacao_tecnica SET id_corredor=?, data_avaliacao=?, frequencia_passos=?, tempo=?, observacoes=?, recomendacoes=? WHERE id_avaliacao=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            p.setInt(1, a.getCorredor().getId());
            p.setDate(2, Date.valueOf(a.getDataAvaliacao()));
            p.setInt(3, a.getFrequenciaPassos());
            p.setInt(4, a.getTempo());
            p.setString(5, a.getObservacoes());
            p.setString(6, a.getRecomendacoes());
            p.setInt(7, a.getId());

            p.executeUpdate();
            System.out.println("Avaliação atualizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar avaliação: " + e.getMessage());
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM avaliacao_tecnica WHERE id_avaliacao = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement p = conn.prepareStatement(sql)) {

            p.setInt(1, id);

            int linhasAfetadas = p.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Avaliação excluída com sucesso!");
            } else {
                System.out.println("Nenhuma avaliação encontrada com o ID informado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir avaliação: " + e.getMessage());
        }
    }
    
    @Override
public AvaliacaoTecnica buscarPorId(int id) {
    String sql = "SELECT * FROM avaliacao_tecnica WHERE id_avaliacao = ?";
    AvaliacaoTecnica a = null;

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement p = conn.prepareStatement(sql)) {

        p.setInt(1, id);
        ResultSet rs = p.executeQuery();

        if (rs.next()) {
            a = new AvaliacaoTecnica();
            a.setId(rs.getInt("id_avaliacao"));
            a.setDataAvaliacao(rs.getDate("data_avaliacao").toLocalDate());
            a.setFrequenciaPassos(rs.getInt("frequencia_passos"));
            a.setTempo(rs.getInt("tempo"));
            a.setObservacoes(rs.getString("observacoes"));
            a.setRecomendacoes(rs.getString("recomendacoes"));

            int corredorId = rs.getInt("corredor_id");
            CorredorDAO corredorDAO = new CorredorDAO();
            Corredor corredor = corredorDAO.buscarPorId(corredorId);
            a.setCorredor(corredor);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao buscar avaliação técnica: " + e.getMessage());
    }

    return a;
}   
}
