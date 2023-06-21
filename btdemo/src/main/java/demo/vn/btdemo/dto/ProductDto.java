package demo.vn.btdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor// Tự động generate Khởi tạo khong tham số
@AllArgsConstructor// Tự động generate Khởi tạo tất cả tham số
public class ProductDto {

    int id;
    String alias;
    String cost;
    String created_time;
    Float discount_percent;
    int enabled;
    String full_description;
    Float height;
    int in_stock;
    Float length;
    MultipartFile main_image;
    String name;
    Float price;
    String short_description;
    String updated_time;
    Float weight;
    Float width;
    int brand_id;
    int category_id;

}
