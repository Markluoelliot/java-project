package com.luo;

import com.luo.util.JedisAdapter;

public class TestRedis {
    public static void main(String[] args) {
		JedisAdapter ja = new JedisAdapter();
		System.out.println(ja.smembers("sets"));
	}
}
