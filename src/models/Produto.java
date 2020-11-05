package models;

public class Produto {
    
    private int id;
    private String nome;
    private String data_compra;
    private float vl_compra;
    private float vl_venda;
    private float qtde;
    private int id_pessoa;
    private int id_ordem;
    private boolean excluido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_compra() {
        return data_compra;
    }

    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }

    public float getVl_compra() {
        return vl_compra;
    }

    public void setVl_compra(float vl_compra) {
        this.vl_compra = vl_compra;
    }

    public float getVl_venda() {
        return vl_venda;
    }

    public void setVl_venda(float vl_venda) {
        this.vl_venda = vl_venda;
    }

    public float getQtde() {
        return qtde;
    }

    public void setQtde(float qtde) {
        this.qtde = qtde;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getId_ordem() {
        return id_ordem;
    }

    public void setId_ordem(int id_ordem) {
        this.id_ordem = id_ordem;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    

    
    
    
}
