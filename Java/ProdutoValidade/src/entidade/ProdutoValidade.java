/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author pretto
 */
public class ProdutoValidade {
    
    private Long id;
    private String nome;
    private String dataHoraCadastro;
    private String dataHoraCompra;
    private String dataHoraFabricacao;
    private String dataVencimento;
    private String observacao;

    public ProdutoValidade(Long id, String nome, String dataHoraCadastro, String dataHoraCompra, String dataHoraFabricacao, String dataVencimento, String observacao) {
        this.id = id;
        this.nome = nome;
        this.dataHoraCadastro = dataHoraCadastro;
        this.dataHoraCompra = dataHoraCompra;
        this.dataHoraFabricacao = dataHoraFabricacao;
        this.dataVencimento = dataVencimento;
        this.observacao = observacao;
    }

    public ProdutoValidade(String nome, String dataHoraCadastro, String dataHoraCompra, String dataHoraFabricacao, String dataVencimento, String observacao) {
        this.nome = nome;
        this.dataHoraCadastro = dataHoraCadastro;
        this.dataHoraCompra = dataHoraCompra;
        this.dataHoraFabricacao = dataHoraFabricacao;
        this.dataVencimento = dataVencimento;
        this.observacao = observacao;
    }

    public ProdutoValidade(){}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(String dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public String getDataHoraCompra() {
        return dataHoraCompra;
    }

    public void setDataHoraCompra(String dataHoraCompra) {
        this.dataHoraCompra = dataHoraCompra;
    }

    public String getDataHoraFabricacao() {
        return dataHoraFabricacao;
    }

    public void setDataHoraFabricacao(String dataHoraFabricacao) {
        this.dataHoraFabricacao = dataHoraFabricacao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
