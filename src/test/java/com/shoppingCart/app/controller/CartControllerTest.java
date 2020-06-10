package com.shoppingCart.app.controller;

import com.shoppingCart.app.model.Cart;
import com.shoppingCart.app.model.Customer;
import com.shoppingCart.app.model.LineItem;
import com.shoppingCart.app.service.CartService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class CartControllerTest {

    @Mock
    CartService cartService;

    @InjectMocks
    CartController cartController;

    @Test
    public void testCreate() throws URISyntaxException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Cart cart = new Cart();
        cart.setIdCart(1l);
        cart.setCustomer(new Customer());
        cart.setLinesItems(Arrays.asList(new LineItem()));
        cart.setSubtotal(new BigDecimal(0));
        Mockito.when(cartService.save(cart)).thenReturn(1l);
        ResponseEntity rs = cartController.create(cart, request);
        Assert.assertEquals(rs.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void testAddProduct() throws URISyntaxException {
        Long idCart = 1l;
        Long idProduct = 1l;
        Integer quantity = 20;
        Mockito.doNothing().when(cartService).add(idCart, idProduct, quantity);
        ResponseEntity rs = cartController.addProduct(idCart, idProduct, quantity);
        Assert.assertEquals(rs.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void testOrdered() throws URISyntaxException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Long idCart = 1l;
        Mockito.when(cartService.ordered(idCart)).thenReturn(1l);
        ResponseEntity rs = cartController.ordered(idCart, request);
        Assert.assertEquals(rs.getStatusCode(), HttpStatus.CREATED);
    }
}
