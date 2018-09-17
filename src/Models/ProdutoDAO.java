/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Beans.FuncionarioBean;
import Beans.ProdutoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cacai
 */
public class ProdutoDAO implements DAO {

    ProdutoBean pb;
    private Connection conexao;

    public ProdutoDAO(Connection conexao, ProdutoBean produtoBean) {
        this.conexao = conexao;
        this.pb = produtoBean;

    }

    @Override
    public void Cadastrar() {
        String sql = "insert into tbl_produtos("
                + "fk_categoriaProduto,"
                + "fk_fornecedorProduto,"
                + "nome_produto,"
                + "descricao_produto,"
                + "preco_produto,"
                + "unidade,"
                + "imagem) values (?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, this.pb.getId_categoria());
            stmt.setInt(2, this.pb.getId_fornecedor());
            stmt.setString(3, this.pb.getNome_produto());
            stmt.setString(4, this.pb.getDescricao_produto());
            stmt.setFloat(5, this.pb.getPreco_produto());

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void Alterar() {
        String sql = "update tbl_produtos set nome_produto = ?,"
                + "descricao_produto = ?,"
                + "preco_produto = ?,"
                + "unidade = ?,"
                + "imagem = ?,"
                + "fk_categoriaProduto = ?,"
                + "fk_fornecedorProduto = ? where cod_produto = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, this.pb.getNome_produto());
            stmt.setString(2, this.pb.getDescricao_produto());
            stmt.setFloat(3, this.pb.getPreco_produto());
            stmt.setString(4, this.pb.getUnidade());
            stmt.setString(5, this.pb.getImagem());
            stmt.setInt(6, this.pb.getId_categoria());
            stmt.setInt(6, this.pb.getId_fornecedor());

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void Desativar() {
        String sql = "Delete from tbl_produtos where cod_produto = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
      public ArrayList<ProdutoBean> listarTudo() {

        ArrayList<ProdutoBean> listaProdutos = new ArrayList();

        try {

            String sql = "select * from tbl_produtos ";

            PreparedStatement stm = conexao.prepareStatement(sql);
            
             
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                ProdutoBean obj = new ProdutoBean();

                obj.setCod_produto(rs.getInt(1));
                obj.setNome_produto(rs.getString(2));
                obj.setDescricao_produto(rs.getString(3));
                obj.setPreco_produto(rs.getFloat(4));
                obj.setUnidade(rs.getString(5));
                obj.setImagem(rs.getString(6));
                 /*Precisa de uma view para que possa carregar nomes e ids
                 de categoria e fornecedores*/
                listaProdutos.add(obj);
            }

            return listaProdutos;

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ERRO  NO BANCO: " + ex.getMessage());
            return null;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
            return null;

        }
    }


}
