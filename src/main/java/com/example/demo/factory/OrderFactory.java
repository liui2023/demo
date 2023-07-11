package com.example.demo.factory;

import com.example.demo.dto.OrderDTO;
import com.example.demo.request.BaseRequest;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory implements BaseFactory<OrderDTO> {
    @Override
    public BaseRequest create(OrderDTO input) {
        System.out.println("order factory");
        return null;
    }
}
