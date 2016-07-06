import com.itis.bobrinskaya.model.Product;
import com.itis.bobrinskaya.model.Slider;
import com.itis.bobrinskaya.model.enums.ProductTypeEnum;
import com.itis.bobrinskaya.repository.ProductRepository;
import com.itis.bobrinskaya.repository.SliderRepository;
import com.itis.bobrinskaya.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Ekaterina on 09.05.2016.
 */
public class TestProductService {
    private static ProductServiceImpl productService;
    private static Product product;
    private static List<Product> products;
    private static List<Slider> productsInSlider;
    private  static List<Product> featured;


    @BeforeClass
    public static void init() {
        productService = new ProductServiceImpl();
        product = mock(Product.class);
        when(product.getName()).thenReturn("name");
        products = new ArrayList<>();
        for(int i = 0; i< 5; i++){
            products.add(product);
        }
         featured = new ArrayList<>();
        for(int i = 0; i< 3; i++){
            featured.add(product);
        }
        productsInSlider = new ArrayList<>();
        productService.productRepository = mock(ProductRepository.class);
        productService.sliderRepository = mock(SliderRepository.class);
        when(productService.productRepository.findAll()).thenReturn(products);
        when(productService.productRepository.findByName(anyString())).thenReturn(product);
        when(productService.productRepository.findByType(ProductTypeEnum.ROLL)).thenReturn(products);
        when(productService.productRepository.findOrderById()).thenReturn(products);
        when(productService.productRepository.findOrderByPrice()).thenReturn(products);
        when(productService.sliderRepository.findAll()).thenReturn(productsInSlider);
    }

    @Test
    public void getAllShouldWorkCorrect(){
        Assert.assertEquals(products, productService.getAll());
    }

    @Test
    public void getOneShouldWorkCorrect(){
        Assert.assertEquals(product, productService.getOne("name"));
    }

    @Test
    public void getMealsOfDayShouldWorkCorrect(){
        Assert.assertEquals(products, productService.getMealsOfDay());
    }
    @Test
    public void getFeaturedMealsShouldWorkCorrect(){
        Assert.assertEquals(featured, productService.getFeaturedMeals());
    }

    @Test
    public void sendToListingShouldWorkCorrect(){
        Assert.assertEquals(products, productService.sendToListing(ProductTypeEnum.ROLL));
    }


}
