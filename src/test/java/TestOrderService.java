import com.itis.bobrinskaya.model.Orders;
import com.itis.bobrinskaya.model.Productinorder;
import com.itis.bobrinskaya.model.Users;
import com.itis.bobrinskaya.repository.OrderRepository;
import com.itis.bobrinskaya.repository.ProductInOrderRepository;
import com.itis.bobrinskaya.service.impl.OrderServiceimpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Ekaterina on 09.05.2016.
 */
public class TestOrderService {
    private static OrderServiceimpl orderService;
    private static Orders order;
    private static Users user;
    private  static List<Orders> ordersList;
    private static Productinorder productinorder;

    @BeforeClass
    public static void init() {
        user = mock(Users.class);
        when(user.getId()).thenReturn(1);
        ordersList = new ArrayList<>();
        order = new Orders();
        order.setId(1);
        productinorder = mock(Productinorder.class);
        orderService = new OrderServiceimpl();
        orderService.productInOrderRepository = mock(ProductInOrderRepository.class);
        orderService.orderRepository = mock(OrderRepository.class);
        when(orderService.orderRepository.findAll()).thenReturn(ordersList);
        when(orderService.orderRepository.findNotReady()).thenReturn(ordersList);
        when(orderService.orderRepository.findReady()).thenReturn(ordersList);
        when(orderService.orderRepository.findUsersLastOrder(user.getId())).thenReturn(order.getId());
        when(orderService.orderRepository.findOne(order.getId())).thenReturn(order);
        when(orderService.orderRepository.save(order)).thenReturn(order);

        when(orderService.productInOrderRepository.save(productinorder)).thenReturn(productinorder);

    }

    @Test
    public void getAllShouldworkCorrect(){
        Assert.assertEquals(ordersList, orderService.getAll());
    }

    @Test
    public void getNotReadyShouldworkCorrect(){
        Assert.assertEquals(ordersList, orderService.getNotReady());
    }

    @Test
    public void getReadyShouldworkCorrect(){
        Assert.assertEquals(ordersList, orderService.getReady());
    }

    @Test
    public void createNewOrderShouldworkCorrect(){
        Assert.assertEquals(order, orderService.createNewOrder(order));
    }

    @Test
    public void addproductsShouldworkCorrect(){
        Assert.assertEquals(productinorder, orderService.addproducts(productinorder));
    }

    @Test
    public void getUsersLastOrderShouldworkCorrect(){
        Assert.assertEquals(order.getId(), orderService.getUsersLastOrder(user.getId()));
    }
    @Test
    public void getOneShouldworkCorrect(){
        Assert.assertEquals(order, orderService.getOne(order.getId()));
    }


}
