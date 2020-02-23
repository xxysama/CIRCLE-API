package com.x2yu.circle;

import com.x2yu.circle.service.ITblBookInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CircleApiApplicationTests {

    @Autowired
    ITblBookInfoService bookInfoService;
    @Test
    void contextLoads() {

    }

}
