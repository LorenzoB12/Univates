/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author loren
 */
public class Pessoas {
    private Long codId;
    private String nome;
    private String email;
    private String telefone;

    public Long getCodId() {
        return codId;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setCodId(Long codId) {
        this.codId = codId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pessoas(Long codId, String nome, String email, String telefone) {
        this.codId = codId;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    
    
}
