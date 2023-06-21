package demo.vn.btdemo.entities;


import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto increment
    int ID;

    @Column(name="EMAIL")
    String EMAIL;

    @Column(name="ADDRESS")
    String  ADDRESS;

    @Column(name = "PASSWORD")
    String PASSWORD;

    @Column(name = "AVATAR")
    String AVATAR;

    @Column(name = "STATUS")
    int STATUS;

}
