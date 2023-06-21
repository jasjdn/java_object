package demo.vn.btdemo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class Upload_file_img {

    @Value("${folder.image}")
    String forderImage;

    public String saveFile(MultipartFile multipartFile) throws IOException {


        File file = new File(forderImage);
        if(!file.exists())
            file.mkdirs();

        String name = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();

        InputStream inputStream = multipartFile.getInputStream();

        byte[] bytes = new byte[inputStream.available()];

        File taget_file = new File(forderImage+name);
        inputStream.read(bytes);

        try(OutputStream outputStream =  new FileOutputStream(taget_file)){
            outputStream.write(bytes);
        }
        catch (Exception ex){

        }
        inputStream.close();





        return name;

    }

}
