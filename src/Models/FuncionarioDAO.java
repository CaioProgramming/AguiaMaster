package Models;

import Beans.FuncionarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeferson Oliveira
 */
public class FuncionarioDAO {

    private Connection conexao;
    FuncionarioBean funcionarioBean = null;
    

//CONSTRUTOR QUE CRIA UMA CONEXAO COM O BANCO DE DADOS A CADA INSTANCIA DA CLASSE
    public FuncionarioDAO(Connection con, FuncionarioBean fb) {
        this.conexao = con;
        this.funcionarioBean = fb;
    }
    

    public int pegarID(FuncionarioBean funcionario) {
        int id = 0;
        try {
            String sql = "select cod_funcionario from tbl_funcionario where cpf = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, funcionario.getCpf());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                FuncionarioBean obj = new FuncionarioBean();
                obj.setCod_funcionario(rs.getInt(1));
                id = obj.getCod_funcionario();

            }

            rs.close();
            stmt.close();
            return id;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return 0;

        }

    }

    public void cadastrarFuncionario() {

        try {
            String sql = "insert into tbl_funcionarios(nome, cpf, sexo, data_nascimento, cargo, comissao, estatus, telefone, celular, email, login, senha) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

                stmt.setString(1, funcionarioBean.getNome());
                stmt.setString(2, funcionarioBean.getCpf());
                stmt.setString(3, funcionarioBean.getSexo());
                stmt.setString(4, funcionarioBean.getData_nascimento());
                stmt.setString(5, funcionarioBean.getCargo());
                stmt.setFloat(6, funcionarioBean.getComissao());
                stmt.setString(7, funcionarioBean.getEstatus());
                stmt.setString(8, funcionarioBean.getTelefone());
                stmt.setString(9, funcionarioBean.getCelular());
                stmt.setString(10, funcionarioBean.getEmail());
                stmt.setString(11, funcionarioBean.getLogin());
                stmt.setString(12, funcionarioBean.getSenha());

                stmt.executeUpdate();
                stmt.close();
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ERRO NO BANCO: " + ex.getMessage());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());

        }

    }

    public void alterarFuncionario() {

        String sql = "update tbl_funcionarios set nome = ?, cpf = ?, sexo = ?, data_nascimento = ?, cargo = ?, comissao = ?, "
                + "estatus = ?, telefone = ?, celular = ?, email = ?, login = ?, senha = ? where cod_funcionario = ?";

        try {

            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, funcionarioBean.getNome());
                stmt.setString(2, funcionarioBean.getCpf());
                stmt.setString(3, funcionarioBean.getSexo());
                stmt.setString(4, funcionarioBean.getData_nascimento());
                stmt.setString(5, funcionarioBean.getCargo());
                stmt.setFloat(6, funcionarioBean.getComissao());
                stmt.setString(7, funcionarioBean.getEstatus());
                stmt.setString(8, funcionarioBean.getTelefone());
                stmt.setString(9, funcionarioBean.getCelular());
                stmt.setString(10, funcionarioBean.getEmail());
                stmt.setString(11, funcionarioBean.getLogin());
                stmt.setString(12, funcionarioBean.getSenha());
                stmt.setInt(13, funcionarioBean.getCod_funcionario());
                
                stmt.execute();
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ERRO NO BANCO: " + ex);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERRO: " + e);

        }
    }

    public void desativarFuncioanrio() {

        String sql = "update tbl_funcionarios set estatus = 'D' where cod_funcionario = ? ";

        try {

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, funcionarioBean.getCod_funcionario());

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ERRO NO BANCO: " + ex);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERRO: " + e);

        }

    }

    public ArrayList<FuncionarioBean> listarTudo() {

        ArrayList<FuncionarioBean> listaFuncionario = new ArrayList();

        try {

            String sql = "select cod_funcionario, nome, cpf, sexo, data_nascimento, cargo, comissao, "
                    + "estatus, telefone, celular, email, login, senha from tbl_funcionarios where estatus = ? ";

            PreparedStatement stm = conexao.prepareStatement(sql);
            
            stm.setString(1, funcionarioBean.getEstatus());
            
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                FuncionarioBean obj = new FuncionarioBean();

                obj.setCod_funcionario(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setCpf(rs.getString(3));
                obj.setSexo(rs.getString(4));
                obj.setData_nascimento(rs.getString(5));
                obj.setCargo(rs.getString(6));
                obj.setComissao(rs.getFloat(7));
                obj.setEstatus(rs.getString(8));
                obj.setTelefone(rs.getString(9));
                obj.setCelular(rs.getString(10));
                obj.setEmail(rs.getString(11));
                obj.setLogin(rs.getString(12));
                obj.setSenha(rs.getString(13));

                listaFuncionario.add(obj);
            }

            return listaFuncionario;

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ERRO  NO BANCO: " + ex.getMessage());
            return null;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
            return null;

        }
    }

}
