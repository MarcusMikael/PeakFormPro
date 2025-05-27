
package dao;

import java.util.List;
import model.AvaliacaoTecnica;

public interface AvaliacaoTecnicaDAOI {
    void inserir(AvaliacaoTecnica a);
    List<AvaliacaoTecnica> listarTodos();
    void atualizar(AvaliacaoTecnica a);
    void excluir(int id);
    AvaliacaoTecnica buscarPorId(int id);
}
