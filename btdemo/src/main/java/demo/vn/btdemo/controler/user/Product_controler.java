package demo.vn.btdemo.controler.user;

import demo.vn.btdemo.dto.ProductDto;
import demo.vn.btdemo.entities.ProductEntity;
import demo.vn.btdemo.sevice.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("product")
public class Product_controler {

    @Autowired
    ProductService productService;

    @GetMapping(value = "get-all")
    public String getAll_product(Model model){

        try {
            model.addAttribute("data",productService.getAll());
//            System.out.println(productService.getAll());
        }catch (Exception ex){
            model.addAttribute("data", new ProductEntity()); // thả đối tượng rỗng và form trong trường hợp lỗi get dữ liệu
            System.out.println("lỗi khi get all product "+ ex);
        }


        return "/product/list.html";
    }

//    @PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String upload_img(@ModelAttribute MultipartFile file){
//
//        System.out.println(file);
//
//        return "ay";
//
//    }

    @GetMapping("add-product-frm")
    public String add_product_frm(Model model){

        model.addAttribute("data",new ProductDto());

        return "/product/add_product.html";
    }


    @PostMapping( value = "add-product" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String add_product(@ModelAttribute ProductDto data){
//        System.out.println("ayyyyyyyyyyy");

//        System.out.println("data" +  data);
        productService.saveOrUpdate(data,"add");
        return "redirect:/product/get-all";
    }


}
