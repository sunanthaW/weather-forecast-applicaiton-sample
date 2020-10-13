package com.ityourgalj.thaiweather.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OAuthInteceptor implements Interceptor {
	private String tokenType;
	private String acceessToken;

	public OAuthInteceptor(String tokenType, String acceessToken) {
		this.tokenType = tokenType;
		this.acceessToken = acceessToken;
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request request = chain.request();
		request = request.newBuilder().header("Authorization", String.format("%s %s", tokenType, acceessToken)).build();

		return chain.proceed(request);
	}

}
