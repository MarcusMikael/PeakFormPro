// Interface corredor
package dao;
import java.util.List;
import model.Corredor;

public interface CorredorDAOI {
    void inserir(Corredor c);
    List<Corredor> listarTodos();
    void atualizar(Corredor c);
    void excluir(int id);
    Corredor buscarPorId(int id);
}
