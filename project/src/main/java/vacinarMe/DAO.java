package vacinarMe;


import vacinarMe.ConexaoBD;
import com.mysql.cj.conf.PropertyKey;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DAO {
    
    // Metodo para validar usuario
    public boolean existeUsuario(Usuario usuario) throws Exception {
        String sql = "SELECT * FROM tb_usuario WHERE login = ? AND senha = ?";
        try (Connection conn = ConexaoBD.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    // Metodo para autenticar usuario 
    public boolean existeAtendente (Usuario usuario) throws Exception {
         String sql2 = "SELECT tipo_usuario FROM tb_usuario WHERE login = ? AND senha = ? AND tipo_usuario = 'Administrador'";
        try (Connection conn = ConexaoBD.obtemConexao();
            PreparedStatement ps2 = conn.prepareStatement(sql2)) {
            ps2.setString(1, usuario.getLogin());
            ps2.setString(2, usuario.getSenha());
            try (ResultSet rs = ps2.executeQuery()) {
                return rs.next();
            }
        }
    }
    // Metodo para cadstrar usuario
    public void cadastrarUsuario(Usuario usuario) throws Exception {
        String sql = "INSERT INTO tb_usuario (login, senha, tipo_usuario, nome, cpf) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getTipoUsuario());
            ps.setString(4, usuario.getNomeUsuario());
            ps.setString(5, usuario.getCpf());
            ps.execute();
    }
  }
    // Metodo para remover usuario
    public void excluirUsuario(Usuario usuario) throws Exception {
        String sql = "DELETE FROM tb_usuario WHERE nome = ? AND cpf = ?";
        try (Connection conn = ConexaoBD.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.execute();
    }
  }
    // Metodo para verificar se o usuario existe para remove-lo
      public boolean verificarUsuario(Usuario usuario) throws Exception {
        String sql = "SELECT * FROM tb_usuario WHERE nome = ? AND cpf = ?";
        try (Connection conn = ConexaoBD.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
      // Método para cadastrar pacientes
    public void cadastrarPessoas(Vacinacao vacinacao) throws Exception {
        String sql = "INSERT INTO tb_vacinacao (nome, idade, endereco, profissao_saude, nivel_prioridade) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, vacinacao.getNome());
            ps.setInt(2, vacinacao.getIdade());
            ps.setString(3, vacinacao.getEndereco());
            ps.setString(4, vacinacao.getAreaSaude());
            ps.setInt(5, vacinacao.getNivelPrioridade());
            ps.execute();
    }     
  }
    // Fila de vacinação
    public ArrayList<FilaVacincao> visualizarFila() {
        ArrayList<FilaVacincao> fila = new ArrayList<>();
        String sql = "SELECT id, nome, nivel_prioridade FROM tb_vacinacao WHERE data_vacinacao IS NULL ORDER BY nivel_prioridade";
        int contador = 0;
        try (Connection conn = ConexaoBD.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                FilaVacincao filaVacina = new FilaVacincao();
                filaVacina.setId(rs.getInt("id"));
                filaVacina.setNome(rs.getString("nome"));
                filaVacina.setOrdemFila(rs.getInt("nivel_prioridade"));
                contador +=1;
                filaVacina.setOrdem(contador);
                
                fila.add(filaVacina);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar");
        }
        return fila;
    }
    // Método pra inserir data após confirmação da vacina
    public void preencherData(Vacinacao cadastroData) throws SQLException {
        String sql = "UPDATE tb_vacinacao SET data_vacinacao = ? WHERE id = ?";
        try (Connection conn = ConexaoBD.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cadastroData.getDataVacinacao());
            ps.setInt(2, cadastroData.getId());
            ps.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }     
    }
    // Metodo para gerar relatorio
int maior90 = 0; // Aumentando escopo da variavel para usar em outras telas
   public  void consultarIdadeMaior90(Vacinacao relatorio) throws SQLException {
       String sql = "SELECT COUNT(idade) FROM tb_vacinacao WHERE idade >= 90 AND data_vacinacao BETWEEN ? AND ?";
       try (Connection conn = ConexaoBD.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, relatorio.getDataInicio());
            ps.setString(2, relatorio.getDataFim());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maior90 = rs.getInt(1);
            } else {
                maior90 = 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar pessoas vacinadas");
        } 
   }
   // Metodo para gerar relatorio
int entre7090 = 0; // Aumentando escopo da variavel para usar em outras telas  
   public  void consultarIdadeEntre7090(Vacinacao relatorio) throws SQLException {
       String sql = "SELECT COUNT(idade) FROM tb_vacinacao WHERE idade >= 70 AND idade < 90 AND data_vacinacao BETWEEN ? AND ?";
       try (Connection conn = ConexaoBD.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, relatorio.getDataInicio());
            ps.setString(2, relatorio.getDataFim());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                entre7090 = rs.getInt(1);
            } else {
                entre7090 = 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar pessoas vacinadas");
        } 
   }
    // Metodo para gerar relatorio
int entre5070 = 0; // Aumentando escopo da variavel para usar em outras telas  
   public  void consultarIdadeEntre5070(Vacinacao relatorio) throws SQLException {
       String sql = "SELECT COUNT(idade) FROM tb_vacinacao WHERE idade >= 50 AND idade < 70 AND data_vacinacao BETWEEN ? AND ?";
       try (Connection conn = ConexaoBD.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, relatorio.getDataInicio());
            ps.setString(2, relatorio.getDataFim());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                entre5070 = rs.getInt(1);
            } else {
                entre5070 = 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar pessoas vacinadas");
        } 
   }
    // Metodo para gerar relatorio
int menor50 = 0; // Aumentando escopo da variavel para usar em outras telas
   public  void consultarIdadeMenor50(Vacinacao relatorio) throws SQLException {
       String sql = "SELECT COUNT(idade) FROM tb_vacinacao WHERE idade < 50 AND data_vacinacao BETWEEN ? AND ?";
       try (Connection conn = ConexaoBD.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, relatorio.getDataInicio());
            ps.setString(2, relatorio.getDataFim());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                menor50 = rs.getInt(1);
            } else {
                menor50 = 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar pessoas vacinadas");
        } 
   }
}


