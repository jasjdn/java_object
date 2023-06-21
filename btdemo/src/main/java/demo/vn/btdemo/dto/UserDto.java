package demo.vn.btdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor// Tự động generate Khởi tạo khong tham số
@AllArgsConstructor// Tự động generate Khởi tạo tất cả tham số
public class UserDto {


    Integer ID;
    String EMAIL;
    String ADDRESS;
    String PASSWORD;
    String AVATAR;
    int STATUS;

    MultipartFile fileAvatar;

}
