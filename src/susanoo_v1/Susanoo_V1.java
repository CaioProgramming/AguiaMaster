package susanoo_v1;

import Beans.FuncionarioBean;
import Conexao.ConnectionFactory;
import Models.FuncionarioDAO;

/**
 *
 * @author Jeferson Oliveira
 */
public class Susanoo_V1 {


    public static void main(String[] args) {

        FuncionarioBean fb = new FuncionarioBean();
        FuncionarioDAO fd = new FuncionarioDAO(new ConnectionFactory().getConnection(), fb);
        
        
        fb.setNome("Mylena Soares");
        fb.setCpf("47199518803");
        fb.setSexo("F");
        fb.setData_nascimento("19981209");
        fb.setCargo("Venderdora");
        fb.setComissao((float) 3.2);
        fb.setEstatus("A");
        fb.setTelefone("81286341");
        fb.setCelular("981286341");
        fb.setEmail("mylena@gmail.com");
        fb.setLogin("mylena");
        fb.setSenha("1234");
        fb.setCod_funcionario(2);
        
        System.out.println("akk " + fb.getNome());
        
        fd.alterarFuncionario();
        
    }
    
}
