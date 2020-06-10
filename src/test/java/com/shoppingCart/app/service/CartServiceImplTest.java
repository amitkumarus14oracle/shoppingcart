package com.shoppingCart.app.service;

import com.shoppingCart.app.dao.CartDao;
import com.shoppingCart.app.model.Cart;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceImplTest {

    @Mock
    CartDao cartDao;

    @InjectMocks
    CartServiceImp cartService;

    @Test
    public void testSave() {
        Cart cart = new Cart();
        cart.setIdCart(1l);
        Mockito.when(cartDao.save(cart)).thenReturn(1l);
        long rs = cartService.save(cart);
        Assert.assertEquals(rs , 1l);
    }
}
