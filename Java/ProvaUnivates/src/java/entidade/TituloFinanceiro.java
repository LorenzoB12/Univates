/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author loren
 */
public class TituloFinanceiro {
    private Long id;
    private Long codPessoa;
    private String dtaVencimento;
    private Double valorDevido;
    private String dtaPagamento;
    private Double valorPago;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(Long codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getDtaVencimento() {
        return dtaVencimento;
    }

    public void setDtaVencimento(String dtaVencimento) {
        this.dtaVencimento = dtaVencimento;
    }

    public Double getValorDevido() {
        return valorDevido;
    }

    public void setValorDevido(Double valorDevido) {
        this.valorDevido = valorDevido;
    }

    public String getDtaPagamento() {
        return dtaPagamento;
    }

    public void setDtaPagamento(String dtaPagamento) {
        this.dtaPagamento = dtaPagamento;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public TituloFinanceiro(Long id, Long codPessoa, String dtaVencimento, Double valorDevido, String dtaPagamento, Double valorPago) {
        this.id = id;
        this.codPessoa = codPessoa;
        this.dtaVencimento = dtaVencimento;
        this.valorDevido = valorDevido;
        this.dtaPagamento = dtaPagamento;
        this.valorPago = valorPago;
    }

    public TituloFinanceiro() {
    }

   
}
