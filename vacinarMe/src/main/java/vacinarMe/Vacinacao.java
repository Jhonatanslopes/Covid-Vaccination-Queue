
package vacinarMe;

public class Vacinacao {
    private String nome;
    private int idade;
    private String endereco;
    private String areaSaude;
    private int nivelPrioridade;
    private String dataVacinacao;
    private int id;
    private String dataFim;
    private String dataInicio;
    
    // Construtor para cadastrar pessoas 
    public Vacinacao(String nome, int idade, String endereco, String areaSaude, int nivelPrioridade) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.areaSaude = areaSaude;
        this.nivelPrioridade = nivelPrioridade;
    }
    
    // Construtor para inserir data de vacinação
    public Vacinacao(String dataVacinacao, int id) {
        this.dataVacinacao = dataVacinacao;
        this.id = id;
    }
    
    // Construtuor para gerar relatorio
    public Vacinacao(String dataInicio, String dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }    
            
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getAreaSaude() {
        return areaSaude;
    }

    public void setAreaSaude(String areaSaude) {
        this.areaSaude = areaSaude;
    }

    public int getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setNivelPrioridade(int nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }

    public String getDataVacinacao() {
        return dataVacinacao;
    }

    public void setDataVacinacao(String data) {
        this.dataVacinacao = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
}
