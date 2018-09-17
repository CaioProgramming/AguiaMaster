package Beans;

/**
 *
 * @author Jeferson Oliveira
 */
public class PedidoBean {
    
    private int cod_cliente;
    private String datahora_pedido;
    private String data_entrega;
    private String tipo_pagamento;
    private float valor_pedido;
    private String vencimento_pedido;
    private String estatus_pedido;

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getDatahora_pedido() {
        return datahora_pedido;
    }

    public void setDatahora_pedido(String datahora_pedido) {
        this.datahora_pedido = datahora_pedido;
    }

    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(String tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }

    public float getValor_pedido() {
        return valor_pedido;
    }

    public void setValor_pedido(float valor_pedido) {
        this.valor_pedido = valor_pedido;
    }

    public String getVencimento_pedido() {
        return vencimento_pedido;
    }

    public void setVencimento_pedido(String vencimento_pedido) {
        this.vencimento_pedido = vencimento_pedido;
    }

    public String getEstatus_pedido() {
        return estatus_pedido;
    }

    public void setEstatus_pedido(String estatus_pedido) {
        this.estatus_pedido = estatus_pedido;
    }

   
}
