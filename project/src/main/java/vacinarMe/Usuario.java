package vacinarMe;

public class Usuario {
    private String login;
    private String senha;
    private String tipoUsuario;
    private String nomeUsuario;
    private String cpf;
    private String nome;

    // Construtor para validar usuario e remover usuario
    public Usuario(String a, String b) {
        this.login = a;
        this.senha = b; 
    }
    // Construtor para para cadastrar usuario
    public Usuario(String login, String senha, String tipoUsuario, String nomeUsuario, String cpf) {
        this.login = login;
        this.senha = senha; 
        this.tipoUsuario = tipoUsuario;
        this.nomeUsuario = nomeUsuario;
        this.cpf = cpf;     
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
