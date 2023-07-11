package com.example.demo.service;

public interface TestInterface<QueryReq, QueryResp> {

    QueryResp test(QueryReq req);
}
