package demo.vn.btdemo.controler.user;

import demo.vn.btdemo.dto.Response;
import demo.vn.btdemo.dto.UserDto;
import demo.vn.btdemo.sevice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class Account {
    @Autowired
    UserService userService;

    @GetMapping("create")
    public Object create(){

        return new UserDto();
    }

    @PostMapping("save")
    public Response create(@RequestBody UserDto data){

        Response response = userService.saveOrUpdate(data);

        return response;

    }



}
