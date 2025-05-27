
package model;

public class Equipamento {
    private int id;
    private String tipo;
    private String marca;
    private String modelo;
    private Corredor corredor; 

    public Equipamento() {} // Contrutor Vazio

    public Equipamento(int id, String tipo, String marca, String modelo, Corredor corredor) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.corredor = corredor;
    }

    // Getters e Setters
    public int getId() {
        return id; }
    
    public void setId(int id) {
        this.id = id; }

    public String getTipo() {
        return tipo; }
    
    public void setTipo(String tipo) {
        this.tipo = tipo; }

    public String getMarca() {
        return marca; }
    
    public void setMarca(String marca) {
        this.marca = marca; }

    public String getModelo() {
        return modelo; }
    
    public void setModelo(String modelo) {
        this.modelo = modelo; }

    public Corredor getCorredor() {
        return corredor;
    }
    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }
}

