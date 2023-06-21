package demo.vn.btdemo.sevice.user;

import demo.vn.btdemo.dto.Response;
import demo.vn.btdemo.dto.UserDto;
import demo.vn.btdemo.entities.UserEntity;

import java.util.List;

public  interface UserService {
    Response saveOrUpdate(UserDto userDto);

    List<UserEntity> getALL();

    Response delete (String ID);

//    UserEntity get_user_by_id(int id);



}
