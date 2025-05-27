
package controller;

import dao.EquipamentoDAO;
import java.util.List;
import model.Equipamento;

public class EquipamentoController {
    private EquipamentoDAO equipamentoDAO;
    
    public EquipamentoController(){
        this.equipamentoDAO = new EquipamentoDAO();
    }
    
    public void adicionarEquipamento(Equipamento eq) {
        equipamentoDAO.inserir(eq);
    }
    
    public List<Equipamento> listarEquipamentos() {
        return equipamentoDAO.listarTodos();
    }
    
    public void atualizarEquipamento(Equipamento eq){
        equipamentoDAO.atualizar(eq);
    }
    
    public void excluirEquipamento(int id) {
        equipamentoDAO.excluir(id);
    }   
}
