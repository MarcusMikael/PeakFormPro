
package controller;
import java.util.List;
import dao.CorredorDAO;
import model.Corredor;


public class CorredorController {
    private CorredorDAO corredorDAO;
    
    public CorredorController() {
        this.corredorDAO = new CorredorDAO();
    }
    
    public void inserir(Corredor c) {
        corredorDAO.inserir(c);
    }
    
    public List<Corredor> listarTodos() {
        return corredorDAO.listarTodos();
    }
    
    public void atualizar(Corredor c) {
        corredorDAO.atualizar(c);
    }
    
    public void excluir(int id) {
        corredorDAO.excluir(id);
    }
}
