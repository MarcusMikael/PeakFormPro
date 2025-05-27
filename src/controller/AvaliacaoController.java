
package controller;

import dao.AvaliacaoTecnicaDAO;
import java.util.List;
import model.AvaliacaoTecnica;

public class AvaliacaoController {
    private AvaliacaoTecnicaDAO avaliacaoDAO;
    
    public AvaliacaoController() {
        this.avaliacaoDAO = new AvaliacaoTecnicaDAO();
    }
    
    public void adicionarAvaliacao(AvaliacaoTecnica a) {
        avaliacaoDAO.inserir(a);
    }
    
    public List<AvaliacaoTecnica> listarAvaliacao() {
        return avaliacaoDAO.listarTodos();
    }
    
    public void atualizarAvaliacao(AvaliacaoTecnica a) {
        avaliacaoDAO.atualizar(a);
    }
    
    public void excluirAvaliacao(int id) {
        avaliacaoDAO.excluir(id);
    }
    
}
