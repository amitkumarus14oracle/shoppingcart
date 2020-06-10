package com.shoppingCart.app.controller;

import com.shoppingCart.app.exception.AuthenticationFailedException;
import com.shoppingCart.app.model.Cart;
import com.shoppingCart.app.model.Customer;
import com.shoppingCart.app.model.LineItem;
import com.shoppingCart.app.service.CartService;
import com.shoppingCart.app.service.CustomerService;
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
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    @Test
    public void testLogin() throws AuthenticationFailedException, NoSuchAlgorithmException {
        String username = "any";
        String password = "password";
        Customer cust = new Customer();
        cust.setFirstName("amit");
        Mockito.when(customerService.authentication(username, password)).thenReturn(cust);
        ResponseEntity rs = customerController.login(username, password);
        Assert.assertEquals(rs.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(((Customer)rs.getBody()).getFirstName(), "amit");
    }

    @Test
    public void testAddCustomer() throws URISyntaxException, NoSuchAlgorithmException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Customer cust = new Customer();
        cust.setFirstName("amit");
        Mockito.when(customerService.addCustomer(cust)).thenReturn(1l);
        ResponseEntity rs = customerController.addCustomer(cust,request);
        Assert.assertEquals(rs.getStatusCode(), HttpStatus.CREATED);
    }

}
