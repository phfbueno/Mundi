package br.com.alura.mvc.mudi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Usuario {

    @Id
    private  String username;
    private  String password;
    private  Boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario" , fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

}
