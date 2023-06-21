package demo.vn.btdemo.sevice.product;

import demo.vn.btdemo.dto.ProductDto;
import demo.vn.btdemo.dto.Response;
import demo.vn.btdemo.dto.UserDto;
import demo.vn.btdemo.entities.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService  {
    Response saveOrUpdate(ProductDto productDto, String type);

    List<ProductEntity> getAll();
}
