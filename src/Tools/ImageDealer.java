package Tools;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageDealer {
    
    public BufferedImage setarDimensao(String caminhoIMG, Integer imgLargura, Integer imgAltura) {
        Double novaImgLargura = null;
        Double novaImgAltura = null;
        Double proporcao = null;
        Graphics2D g2d = null;
        BufferedImage imagem = null, novaImagem = null;
        try{
            imagem = ImageIO.read(new File(caminhoIMG));
        }
        catch(IOException e){
            System.out.println("ERRO: " + e.getMessage());
        }
        
        novaImgLargura = (double) imagem.getWidth();
        novaImgAltura = (double) imagem.getHeight();
        
        if(novaImgLargura >= imgLargura){
            proporcao = (novaImgAltura / novaImgLargura);
            novaImgLargura = (double) imgLargura;
            
            novaImgAltura = (novaImgLargura * proporcao);
            while(novaImgAltura > imgAltura){
                novaImgLargura = (double) (--imgLargura);
                novaImgAltura = (novaImgLargura * proporcao);
            }
        }
        else if (novaImgAltura >= imgAltura){
            proporcao = (novaImgLargura / novaImgAltura);
            novaImgAltura = (double) imgAltura;
            
            while(novaImgLargura > imgLargura){
                novaImgAltura = (double) (--imgAltura);
                novaImgLargura = (novaImgAltura * proporcao);
            }
        }
        
        novaImagem = new BufferedImage(novaImgLargura.intValue(),novaImgAltura.intValue(), BufferedImage.TYPE_INT_RGB);
        g2d = novaImagem.createGraphics();
        g2d.drawImage(imagem, 0, 0,novaImgLargura.intValue(),novaImgAltura.intValue(),null);
        return novaImagem;        
    }
    
    public byte[] pegarBytesDaImagem(BufferedImage imagem){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            ImageIO.write(imagem,"PNG",baos);
        } catch(IOException e){
            System.out.println("ERRO: " + e.getMessage());
        }
        
        InputStream is = new ByteArrayInputStream(baos.toByteArray());
        
        return baos.toByteArray();
    }
    
    public void exibirImagemEmLabel(byte[] imagem, JLabel label){
        if(imagem != null){
            InputStream input = new ByteArrayInputStream(imagem);
            try{
                BufferedImage img = ImageIO.read(input);
                label.setIcon(new ImageIcon(imagem));
            }
            catch(IOException e){
                System.out.println("ERRO: "+e.getMessage());
            }
        }else{
            label.setIcon(null);
        }
    }
}
