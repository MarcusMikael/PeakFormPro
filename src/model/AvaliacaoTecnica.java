package model;
import java.time.LocalDate;

public class AvaliacaoTecnica { // Atributos private
    private int id;
    private LocalDate dataAvaliacao;
    private int frequenciaPassos;
    private int tempo;
    private String observacoes;
    private String recomendacoes;
    private Corredor corredor;
    
    public AvaliacaoTecnica() {
    	// Construtor vazio
    }

    // Construtor
    public AvaliacaoTecnica(int id, LocalDate dataAvaliacao, int frequenciaPassos, int tempo, 
                            String observacoes, String recomendacoes, Corredor corredor) {
        this.id = id;
        this.dataAvaliacao = dataAvaliacao;
        this.frequenciaPassos = frequenciaPassos;
        this.tempo = tempo;
        this.observacoes = observacoes;
        this.recomendacoes = recomendacoes;
        this.corredor = corredor;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getFrequenciaPassos() {
        return frequenciaPassos;
    }

    public void setFrequenciaPassos(int frequenciaPassos) {
        this.frequenciaPassos = frequenciaPassos;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getRecomendacoes() {
        return recomendacoes;
    }

    public void setRecomendacoes(String recomendacoes) {
        this.recomendacoes = recomendacoes;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }
}
