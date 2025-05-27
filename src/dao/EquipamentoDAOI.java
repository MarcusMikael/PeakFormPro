
package dao;

import java.util.List;
import model.Equipamento;

public interface EquipamentoDAOI {
    void inserir(Equipamento eq);
    List<Equipamento> listarTodos();
    void atualizar(Equipamento eq);
    void excluir(int id);
    Equipamento buscarPorId(int id);
}
