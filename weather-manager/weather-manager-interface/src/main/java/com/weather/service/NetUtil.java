package com.weather.service;

import java.io.IOException;
import java.net.MalformedURLException;

public interface NetUtil {
    String getJson(String url) throws IOException;
}
