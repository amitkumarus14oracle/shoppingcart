package com.shoppingCart.app.controller;

import com.shoppingCart.app.exception.ProductNotFoundException;
import com.shoppingCart.app.model.Cart;
import com.shoppingCart.app.model.Customer;
import com.shoppingCart.app.model.LineItem;
import com.shoppingCart.app.model.Product;
import com.shoppingCart.app.service.CartService;
import com.shoppingCart.app.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;

    @Test
    public void testGetProduct() throws ProductNotFoundException {
        Product product = new Product();
        product.setIdProduct(1l);
        Mockito.when(productService.findAll()).thenReturn(Arrays.asList(product));
        ResponseEntity rs = productController.getProducts();
        Assert.assertEquals(((List<Product>)rs.getBody()).get(0).getIdProduct().longValue(), 1l);
    }
}
