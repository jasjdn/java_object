package demo.vn.btdemo.demo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("demo")
public class Demo_Upload {


    @PostMapping("upload")
    public String uploadFile(@ModelAttribute MultipartFile multipartFile) throws IOException {
        String objectName = generateFileName(multipartFile);
        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setProjectId("my-project")
                .setCredentials(GoogleCredentials
                        .fromStream(new ClassPathResource("firebase.json").getInputStream()))  // file kết nối sdk của bọn google firebase
                .build();
        Storage storage = storageOptions.getService();
        BlobId blobId = BlobId.of("staging.testupload-93817.appspot.com", objectName);

        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(multipartFile.getContentType()).build();

        Blob blob = storage.create(blobInfo, multipartFile.getBytes());

        System.out.println("UPLOAD FILE" + multipartFile.getName() + " " + multipartFile.getSize() + " octet");
        String fileUrl = blob.getMediaLink();

        System.out.println("ay : " + blob);

//        return fileUrl;  // cái này là đường dẫn tải về

        return "https://storage.googleapis.com/"+blob.getBucket()+"/"+blob.getName();
    }

    private String generateFileName(MultipartFile multipartFile) {
        return System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename().replace(" ", "_");  // tạo tên file
    }

}
