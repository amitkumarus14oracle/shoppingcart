package com.shoppingCart.app.dao;

import com.shoppingCart.app.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CartDaoImplTest {

    @Mock
    SessionFactory sessionFactory;

    @Mock
    Session session;

    @InjectMocks
    CartDaoImp cartDao;

    @Test
    public void testSave() {
        Cart cart = new Cart();
        cart.setIdCart(1l);
        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
        Mockito.when(session.save(cart)).thenReturn(1l);
        long rs = cartDao.save(cart);
        Assert.assertEquals(rs , 1l);
    }
}
