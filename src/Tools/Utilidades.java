package Tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {
    // UTILIDADES
    
    public String data2String(String data) throws ParseException {
        //RECEBEMOS A DATA QUE VEM DO BANCO. NOS TEMOS QUE DAR UM toString() NELA
        SimpleDateFormat input = new SimpleDateFormat("yyyy-mm-dd");
        //CRIAMOS O OBJETO TIPO DATE PRA RECEBER A DATA COM FORMATACAO DO BANCO...
        Date dataConvertida = input.parse(data);
        //CRIAMOS OUTRA MASCARA
	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        //CRIAMOS UMA STRING QUE IRA RECEBER A DATA FORMATADA DE ACORDO COM O PADRÃO BRASILEIRO
	String dataFormatada = sdf.format(dataConvertida);
        return dataFormatada;
    }
    
    public java.sql.Date data2SQL(String data) throws ParseException{
        //PADRAO DE DATA BRASILEIRO
	SimpleDateFormat input = new SimpleDateFormat("dd/mm/yyyy");
        //APLICAMOS NA DATA, PARA GARANTIR A FORMATACAO.
        Date dataConvertida = input.parse(data);
        //MASCARA ADEQUADA PARA DATA DO MYSQL
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        //FORMATAMOS A DATA DO USUARIO PARA DATA DO SQL
	String dataFormatada = sdf.format(dataConvertida);        
	Date dataFinal = sdf.parse(dataFormatada);
        //CONVERTEMOS PARA O TIPO DE DATA DO MYSQL (REPARE NNO 'TYPECAST' PARA NAO CONFUNDIR COM O OBJETO DATE DO JAVA)
	java.sql.Date dataSQL = new java.sql.Date(dataFinal.getTime());
        return dataSQL;
    }
}
