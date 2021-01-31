package com.netty.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {

        response.headers().set("tln", "java-1-nio");
        response.headers().set("ceshi","test filter");
    }
}
