package Tools;

import javax.swing.JOptionPane;

public class ValidacaoCadastro {
    
    //PARTE DO USUARIO
    public String validaNome(String nome){
        if(nome.length() > 4 && nome.length() < 40){
            return nome;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: nome não atende os requisitos");
            throw new IllegalArgumentException("Erro: nome não atende aos requisitos.");
        }
    }
    
    public String validaCpf(String cpf){
        if(cpf.length() == 14){
            return cpf;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: CPF não atende os requisitos");
            throw new IllegalArgumentException("Erro: CPF não atende aos requisitos.");
        }
    }
    
    public String validaData(String data){
        if (data.length() == 10){
            return data;
        }else{
            JOptionPane.showMessageDialog(null, data.length());
            JOptionPane.showMessageDialog(null, "Erro: Data de nascimento não atende os requisitos");
            throw new IllegalArgumentException("Erro: Data não atende aos requisitos.");
        }
    }
    
    //PARTE DO FUNCIONARIO
    public String validaCargo(String cargo){
        if (cargo.length() > 5 && cargo.length() < 30){
            return cargo;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Cargo não atende os requisitos");
            throw new IllegalArgumentException("Erro: Cargo não atende aos requisitos.");
        }
    }
    
    public Float validaSalario(Float salario){
        if (salario > 400f && salario < 10000f){
            return salario;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Salário não atende os requisitos");
            throw new IllegalArgumentException("Erro: Salário não atende aos requisitos.");
        }
    }
    
    //PARTE DE LOGIN
    public String validaLogin(String login){
        if(login.length() > 4 && login.length() < 20){
            return login;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Login não atende os requisitos");
            throw new IllegalArgumentException("Erro: Login não atende aos requisitos.");
        }
    }
    
    public String validaSenha(String senha01, String senha02){
        if(senha01.length() > 5 && senha01.length() < 21 && senha01.equals(senha02)){
            return senha01;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Senha não atende os requisitos ou foi digitada incorretamente nos dois campos");
            throw new IllegalArgumentException("Erro: senha não atende aos requisitos.");
        }
    }
    
    //PARTE DO ENDERECO
    public String validaRua(String rua){
        if(rua.length() > 6 && rua.length() < 30){
            return rua;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: rua não atende os requisitos");
            throw new IllegalArgumentException("Erro: rua não atende aos requisitos.");
        }
    }
    
    public String validaBairro(String bairro){
        if(bairro.length() > 6 && bairro.length() < 30){
            return bairro;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Bairro não atende os requisitos");
            throw new IllegalArgumentException("Erro: bairro não atende aos requisitos.");
        }
    }
    
    public String validaCidade(String cidade){
        if(cidade.length() > 6 && cidade.length() < 30){
            return cidade;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: rua não atende os requisitos");
            throw new IllegalArgumentException("Erro: cidade não atende aos requisitos.");
        }
    }
    
    //PARTE DO CONTATO
    public String validaEmail(String email){
        if(email.length() > 10 && email.length() < 60){
            return email;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Email não atende os requisitos");
            throw new IllegalArgumentException("Erro: Email não atende aos requisitos.");
        }
    }
    
    public String validaTelefone(String telefone){
        if(telefone.length() == 13){
            return telefone;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: telefone não atende os requisitos");
            throw new IllegalArgumentException("Erro: telefone não atende aos requisitos.");
        }
    }
    
    public String validaCelular(String celular){
        if(celular.length() <= 14){
            return celular;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Celular não atende os requisitos");
            throw new IllegalArgumentException("Erro: Celular não atende aos requisitos.");
        }
    }
}