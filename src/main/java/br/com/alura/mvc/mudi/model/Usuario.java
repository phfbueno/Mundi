package br.com.alura.mvc.mudi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private  String username;
    private  String password;
    private  Boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario" , fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Pedido> pedidos;

}
