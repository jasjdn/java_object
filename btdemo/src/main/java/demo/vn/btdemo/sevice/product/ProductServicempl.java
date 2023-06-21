package demo.vn.btdemo.sevice.product;

import demo.vn.btdemo.dto.ProductDto;
import demo.vn.btdemo.dto.Response;
import demo.vn.btdemo.entities.ProductEntity;
import demo.vn.btdemo.entities.UserEntity;
import demo.vn.btdemo.repository.ProductRepository;

import demo.vn.btdemo.utils.CheckDate;
import demo.vn.btdemo.utils.Upload_fire_google_cloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class ProductServicempl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Upload_fire_google_cloud upload_fire_google_cloud;

    @Autowired
    CheckDate checkDate;


    @Override
    public Response saveOrUpdate(ProductDto productDto, String type) {

        if(productDto ==null)
            return Response.builder().message("không dữ liệu cho hàm đang bị null").code(1).build();
//        if (productDto==null){
//            return Response.builder().code(1).message("không được bỏ trống password").build();
//        }

        String img = "";
        if(productDto.getMain_image() != null){

            try{
                 img = upload_fire_google_cloud.uploadFile(productDto.getMain_image());
            }
            catch (Exception ex){

                return Response.builder().message("lỗi upload file").code(1).build();
            }


        }

        ///////////////////
        ProductEntity productEntity = null;
        if(type ==  "add"){
            productEntity = productRepository.findById(productDto.getId()).orElse(new ProductEntity());


        }

        if (type == "update")
        {
            productEntity = new ProductEntity();
            if(productDto.getId() != 0)
                productEntity.setId(productDto.getId());
        }


        productEntity.setAlias(productDto.getAlias());
        productEntity.setBrand_id(productDto.getBrand_id());
        productEntity.setCategory_id(productDto.getCategory_id());
        productEntity.setCost(productDto.getCost());

        Date create_time = checkDate.check(productDto.getCreated_time(),"yyyy/mm/dd");
        if (create_time != null){
            productEntity.setCreated_time(create_time);
        }


        productEntity.setDiscount_percent(productDto.getDiscount_percent());
        productEntity.setEnabled(productDto.getEnabled());
        productEntity.setFull_description(productDto.getFull_description());
        productEntity.setHeight(productDto.getHeight());
        if(productDto.getIn_stock()>1 || productDto.getIn_stock()<0)
        {
            System.out.println("không được đặt giá trị stock nằm ngoài giá trị 0 - 1");
            productEntity.setIn_stock(1);

        }
        else {
            productEntity.setIn_stock(productDto.getIn_stock());
        }
        productEntity.setLength(productDto.getLength());

        if(img != ""){
            productEntity.setMain_image(img);
        }
        productEntity.setName(productDto.getName());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setShort_description(productDto.getShort_description());

        Date update_time = checkDate.check(productDto.getUpdated_time(),"yyyy/mm/dd");
        if (update_time != null){
            productEntity.setUpdated_time(update_time);
        }

//        productEntity.setUpdated_time(productDto.getUpdated_time());


        productEntity.setWidth(productDto.getWidth());
        productEntity.setWeight(productDto.getWeight());

        productRepository.save(productEntity);
        System.out.println("thêm sản phẩm thành công ");

        return Response.builder().message("thêm sản phẩm thành công").code(0).build();

    }


    @Override
    public List<ProductEntity> getAll() {

        return productRepository.findAll();
    }
}
