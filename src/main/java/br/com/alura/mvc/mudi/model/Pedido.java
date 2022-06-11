package br.com.alura.mvc.mudi.model;

import br.com.alura.mvc.mudi.enums.StatusPedido;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "valor_negociado")
    private BigDecimal valorNegociado;

    @Column(name = "data_entrega")
    private LocalDate dataEntrega;

    @Column(name = "url_produto")
    private String urlProduto;

    @Column(name = "url_imagem")
    private String urlImagem;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pedido")
    private StatusPedido statusPedido;

}
