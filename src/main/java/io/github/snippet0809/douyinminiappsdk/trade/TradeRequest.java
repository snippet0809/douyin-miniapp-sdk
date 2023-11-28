package io.github.snippet0809.douyinminiappsdk.trade;


import io.github.snippet0809.douyinminiappsdk.DouyinApi;

public class TradeRequest<T extends TradeResponse.TradeResponseBody> {

    public transient final String domain = DouyinApi.DOMAIN;
    public transient final String path;
    public transient final String url;

    public TradeRequest(String path) {
        this.path = path;
        this.url = domain + path;
    }
}
