package demo.vn.btdemo.utils;


import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CheckDate {




    public Date check(String str_date, String type){



        DateFormat ay = new SimpleDateFormat(type);
        ay.setLenient(true);  // mặc định là true nếu để false nó sẽ yêu cầu đầu vào thời gian chính xác hơn
        Date date = null;
        try{
          date = ay.parse(str_date);
        }
        catch(Exception ex){
            date = null;
        }

        return date;
    }
}
