package demo.vn.btdemo.sevice.user;

import demo.vn.btdemo.dto.Response;
import demo.vn.btdemo.dto.UserDto;
import demo.vn.btdemo.entities.UserEntity;
import demo.vn.btdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Response saveOrUpdate(UserDto userDto) {
        if(userDto ==null)
            return Response.builder().code(1).build();
        if (userDto.getPASSWORD()==null){
            return Response.builder().code(1).message("không được bỏ trống password").build();
        }
        if(userDto.getFileAvatar() != null){
            // TODO: lưu ảnh
        }


        ///////////////////

        UserEntity userEntity = null;
        if(userDto.getID() != null){
            userEntity = userRepository.findById(userDto.getID()).orElse(new UserEntity());




        } else {
            userEntity = new UserEntity();
//            return Response.builder().code(0).message("có dữ liệu").data(userEntity).build();




        }

        userEntity.setPASSWORD(userDto.getPASSWORD());
        userEntity.setEMAIL(userDto.getEMAIL());
        userEntity.setADDRESS(userDto.getADDRESS());
        userEntity.setAVATAR("ayyyyy");
        userEntity.setSTATUS(userDto.getSTATUS());
//        return Response.builder().code(0).data(userEntity).build();
        userRepository.save(userEntity);
//

        return Response.builder().code(0).message("thêm thành công").data(userDto).build();
    }

    @Override
    public List<UserEntity> getALL() {
        return userRepository.findAll();
    }

    @Override
    public Response delete(String ID2) {
        int ID=0;
        try{
            ID = Integer.parseInt(ID2);
            if( ID <= 0 ){
                Response.builder().code(0).message(" id tài khoản không hợp lệ ").data(ID).build();
            }
        }catch (Exception ex){
            return Response.builder().code(0).message(" id tài khoản không hợp lệ ").data(ID).build();
        }


//        System.out.println("ayyyyy" + userRepository.findById(ID));
        if (userRepository.findById(ID) != null)
        {
            userRepository.deleteById(ID);
            return Response.builder().code(1).message("xóa thành công").build();

        }
        else {

            return Response.builder().code(0).message("không tìm thấy user trong database ").build();
        }
    }
}
