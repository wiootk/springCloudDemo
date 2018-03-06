import com.jun.entity.User;
import com.jun.mapper.UserMapper;
import com.jun.utils.Access;
import com.jun.utils.AccessModule;
import com.jun.utils.GetApi;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class Tests {

    public static void main(String[] args) {
        GetApi<Access,AccessModule> api=new GetApi();
        Set<Class<?>> classSet= api.getClasses("com.jun.controller");
        for(Class cla:classSet){
            api.getApis(cla,Access.class,AccessModule.class);
        }
    }
}