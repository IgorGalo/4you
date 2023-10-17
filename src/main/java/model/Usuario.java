package model;

public class Usuario {
    
    private int IDusuario;
    private String NomeCompleto;
    private String NomeUsuario;
    private String Email;
    private String Senha;

    public int getIDusuario() {
        return IDusuario;
    }

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public void setNomeCompleto(String NomeCompleto) {
        this.NomeCompleto = NomeCompleto;
    }

    public String getNomeUsuario() {
        return NomeUsuario;
    }

    public void setNomeUsuario(String NomeUsuario) {
        this.NomeUsuario = NomeUsuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    @Override
    public String toString() {
        return this.NomeUsuario;
    }

    public Usuario(int IDusuario, String NomeCompleto, String NomeUsuario, String Email, String Senha) {
        this.IDusuario = IDusuario;
        this.NomeCompleto = NomeCompleto;
        this.NomeUsuario = NomeUsuario;
        this.Email = Email;
        this.Senha = Senha;
    }

    public Usuario( String NomeCompleto) {
        this.NomeCompleto = NomeCompleto;
    }

    public Usuario( ) {

    }
    
    

}
