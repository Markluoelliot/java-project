package com.luo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.luo.service.LikeService;

public class LikeServiceTests {
    @Autowired
    LikeService likeService;
    @Before
	public void setUp() {
		System.out.println("setup");
	}
    @Test
    public void testlike() {
    	likeService.like(123, 1, 1);
    	Assert.assertEquals(1, likeService.like(123, 1, 1));
    	
    	likeService.disLike(123,1, 1);
    	Assert.assertEquals(-1,likeService.disLike(123, 1, 1));
        
    	
    }
}
