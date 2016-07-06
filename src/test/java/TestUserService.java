import com.itis.bobrinskaya.model.Users;
import com.itis.bobrinskaya.repository.UserRepository;
import com.itis.bobrinskaya.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Ekaterina on 09.05.2016.
 */
public class TestUserService {
    private static UserServiceImpl userService;
    private static Users user;



    @BeforeClass
    public static void init() {
        user = new Users();
        userService = new UserServiceImpl();
        userService.userRepository = mock(UserRepository.class);
        when(userService.userRepository.findByLogin(anyString())).thenReturn(user);
        when(userService.userRepository.findByPhone(anyString())).thenReturn(user);



    }

    @Test
    public void getByloginShoulworkCorrect(){
         Assert.assertEquals(user, userService.getOneByLogin("login"));
    }

    @Test
    public void getByPhoneShouldworkCorrect(){
        Assert.assertEquals(user, userService.getOneByLogin("988735712"));
    }
}
