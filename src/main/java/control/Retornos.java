/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package control;

/**
 *
 * @author 0068948
 */
public enum Retornos {
    ERRODEPREENCHIMENTO("É necessário preencher todos os campos", false),
    ERRODECADASTRO("Não foi possível cadastrar", false),
    ERROIMAGEMCONVERTIDA("Imagem não convertida", false),
    ERROLOGIN("USUÁRIO OU SENHA INCORRETOS", false),
    OK("", true);
    
    private String mensagem;
    private boolean retorno;

    private Retornos(String mensagem, boolean retorno) {
        this.mensagem = mensagem;
        this.retorno = retorno;
    }

    public String getMensagem() {
        return mensagem;
    }

    public boolean isRetorno() {
        return retorno;
    }
}
