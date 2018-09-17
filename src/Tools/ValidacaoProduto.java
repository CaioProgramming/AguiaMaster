package Tools;

import javax.swing.JOptionPane;

public class ValidacaoProduto {
    
    public String validaNomeProduto(String nomeDoProduto){
        if(nomeDoProduto.length() > 3 && nomeDoProduto.length() < 40){
            return nomeDoProduto;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Nome do produto não atende os requisitos");
            throw new IllegalArgumentException("Erro: Nome do produto não atende aos requisitos.");
        }
    }
    
    public String validaDescricaoDoProduto(String descricaoDoProduto){
        if(descricaoDoProduto.length() > 3 && descricaoDoProduto.length() < 250){
            return descricaoDoProduto;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Descrição do produto não atende os requisitos");
            throw new IllegalArgumentException("Erro: Descrição do produto não atende aos requisitos.");
        }
    }
    
    public Float validaPrecoDoProduto(Float preco){
        if(preco > 0.10 && preco < 1000){
            return preco;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Descrição do produto não atende os requisitos");
            throw new IllegalArgumentException("Erro: Descrição do produto não atende aos requisitos.");
        }
    }
    
    public int validaQuantidadeDoProduto(int quantidade){
        if(quantidade > 0 && quantidade < 10000){
            return quantidade;
        }else{
            JOptionPane.showMessageDialog(null, "Erro: Quantidade do produto não atende os requisitos");
            throw new IllegalArgumentException("Erro: Quantidade do produto não atende aos requisitos.");
        }
    }
}