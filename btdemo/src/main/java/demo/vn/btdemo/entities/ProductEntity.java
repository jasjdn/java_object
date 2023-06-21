package demo.vn.btdemo.entities;

import lombok.Data;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto increment
     int id;

    @Column(name = "alias")
    String alias;

    @Column(name = "cost")
    String cost;

    @Column(name = "created_time")
    Date created_time;

    @Column(name = "discount_percent")
    Float discount_percent;

    @Column(name = "enabled")
    int enabled;

    @Column(name = "full_description")
    String full_description;

    @Column(name = "height")
    Float height;

    @Column(name = "in_stock")
    int in_stock;

    @Column(name = "length")
    Float length;

    @Column(name = "main_image")
    String main_image;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    Float price;

    @Column(name = "short_description")
    String short_description;

    @Column(name = "updated_time")
    Date updated_time;

    @Column(name = "weight")
    Float weight;

    @Column(name = "width")
    Float width;

    @Column(name = "brand_id")
    int brand_id;

    @Column(name = "category_id")
    int category_id;


}
