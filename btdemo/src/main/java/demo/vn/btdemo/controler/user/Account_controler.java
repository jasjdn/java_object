package demo.vn.btdemo.controler.user;

import demo.vn.btdemo.dto.UserDto;
import demo.vn.btdemo.entities.UserEntity;
import demo.vn.btdemo.repository.UserRepository;
import demo.vn.btdemo.sevice.user.UserService;
import demo.vn.btdemo.utils.Upload_file_img;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Account_controler {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    Upload_file_img upload_file_img;

//    @Autowired
//    IImageService imageService;


    @GetMapping("/")
    public String list_accout (Model model){

        model.addAttribute("data",userService.getALL());


        return "list_user.html";
    }

    @GetMapping("delete/{id}")
    public String delete_user(@PathVariable String id){

        userService.delete(id);  // respon

        return "redirect:/";
    }

    @GetMapping("add_user")
    public String add_user(Model model){


        model.addAttribute("data", new UserDto());


        return "add_user.html";

    }

    @PostMapping("add_action_user")
    public String add_user(@ModelAttribute UserDto userDto){

        userService.saveOrUpdate(userDto);

        return "redirect:/";
    }



    @GetMapping("update_user/{id}")
    public String update_user( @PathVariable String id , Model model){

//        System.out.println("tess" +  userRepository.findById(Integer.parseInt(id)));
//        userRepository.findById(Integer.parseInt(id));
        model.addAttribute("data",userRepository.findById(Integer.parseInt(id))  );


        return "update_user.html";

    }

    @PostMapping("update_action_user")
    public String update_action_users(@ModelAttribute UserEntity userEntity){


        userService.saveOrUpdate(UserDto.builder().ID(userEntity.getID()).EMAIL(userEntity.getEMAIL()).ADDRESS(userEntity.getADDRESS()).PASSWORD(userEntity.getPASSWORD()).STATUS(userEntity.getSTATUS()).build());


        return "redirect:/";
    }

    @GetMapping(value = "demo_upload")
    public String uploadfile (Model model ){
        return "demo_upload.html";


    }

    @GetMapping("ays")
    public String asy(){

        return "index1,html";
    }

    @PostMapping(value="demo_upload2" ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadfiles (Model model , @ModelAttribute MultipartFile file ){
//        MultipartFile file = null;
//        model.addAttribute("img",  file );
        System.out.println(file);

        try {
            if(!file.isEmpty())
            {
                System.out.println("thêm file thành công " +upload_file_img.saveFile(file)  );
            }
            else {
                System.out.println("không có ảnh được thêm ");
            }

        }
        catch (Exception ex){
            System.out.println(" lỗi upload file " + ex);
        }

        return "redirect:/demo_upload";


    }

    @PostMapping
    public void create(@RequestParam(name = "file") MultipartFile file) {



//            try {
//
//                String fileName = imageService.save(file);
//
//                String imageUrl = imageService.getImageUrl(fileName);
//
//                System.out.println(imageUrl);
//                // do whatever you want with that
//
//            } catch (Exception e) {
//                //  throw internal error;
//                System.out.println("không upload được ảnh ");
//            }


//        return ResponseEntity.ok().build();
    }



}
