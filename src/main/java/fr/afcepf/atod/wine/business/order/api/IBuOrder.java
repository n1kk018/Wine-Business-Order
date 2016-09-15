/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.atod.wine.business.order.api;

import fr.afcepf.atod.vin.data.exception.WineException;
import fr.afcepf.atod.wine.entity.Order;
import fr.afcepf.atod.wine.entity.Product;

/**
 *
 * @author ronan
 */
public interface IBuOrder {
    /**
     * 
     * @param order
     * @param product
     * @return
     * @throws WineException 
     */
    Order addItemCart(Order order, Product product) throws WineException;
    
    Order addNewOrder(Order order) throws WineException; 
    
}
