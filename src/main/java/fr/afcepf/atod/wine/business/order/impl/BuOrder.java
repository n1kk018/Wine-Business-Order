/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.atod.wine.business.order.impl;

import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.business.order.api.IBuOrder;
import fr.afcepf.atod.wine.entity.Order;
import fr.afcepf.atod.wine.entity.OrderDetail;
import fr.afcepf.atod.wine.entity.Product;
import java.util.HashSet;
import org.springframework.stereotype.Service;

/**
 *
 * @author ronan
 */
@Service
public class BuOrder implements IBuOrder {
    /**
     * quantity initial = 1
     */
    private static final int QUANTITY_INIT = 1;
    
    /**
     * 
     * @param order
     * @param product
     * @return
     * @throws WineException 
     */    
    @Override
    public Order addItemCart(Order order, Product product) throws WineException {
        boolean itemFoundCart  = false;
       if (order.getOrdersDetail()== null) {
           order.setOrdersDetail(new HashSet<OrderDetail>());
           insertNewOrderDetail(order, product);
       } else {
           for (OrderDetail od : order.getOrdersDetail()) {
               if (od.getProductOrdered().getIdProduct() 
                       == product.getIdProduct()) {
                   od.setQuantite(od.getQuantite() + 1);
                   itemFoundCart = true;
               }
           }
           
           if (!itemFoundCart) {
               insertNewOrderDetail(order, product);
           }
       }
       return order;
    }
    
    private void insertNewOrderDetail(Order order, Product product) {
        order.getOrdersDetail().add(
                new OrderDetail(null,QUANTITY_INIT, order, product));
    }
}
