package com.example.demo.factory;

import com.example.demo.request.BaseRequest;

public interface BaseFactory<T> {

    BaseRequest create(T input);
}
