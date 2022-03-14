import com.zdk.landlord.LandlordService;
import com.zdk.landlord.LandlordServiceImpl;
import com.zdk.service.UserService;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    @Test
    public void testJDK(){
        //target
        LandlordService landlordService = new LandlordServiceImpl();
        //Additional functionality
        InvocationHandler ih = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //secondary function
                System.out.println("release rental information 1");
                System.out.println("see the apartment 1");
                //kernel
                landlordService.renting();
                return null;
            }
        };
        //dynamically generate proxy classes
        LandlordService proxy = (LandlordService) Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(),
                landlordService.getClass().getInterfaces(),ih);
        proxy.renting();

    }
    @Test
    public void testCGLIB(){
        //target
        LandlordService landlordService = new LandlordServiceImpl();
        //
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(LandlordServiceImpl.class);
        enhancer.setCallback(new org.springframework.cglib.proxy.InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                //secondary function
                System.out.println("release rental information 2");
                System.out.println("see the apartment 2");
                //kernel
                landlordService.renting();
                return null;
            }
        });
        //dynamically generate proxy classes
        LandlordServiceImpl proxy = (LandlordServiceImpl) enhancer.create();
        proxy.renting();
    }
    @Test
    public void testSpringAOP(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        //通过目标的bean id，获得代理对象
        UserService proxy = (UserService) context.getBean("userService");
        //System.out.println(proxy.getClass());
        proxy.queryUsers();
        System.out.println("===========");
        proxy.deleteUser(null);
        System.out.println("============");
        proxy.updateUser(null);
        System.out.println("============");
        proxy.saveUser(null);
    }
}
