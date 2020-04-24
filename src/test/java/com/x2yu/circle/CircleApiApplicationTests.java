package com.x2yu.circle;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.x2yu.circle.dto.TopicPageDto;
import com.x2yu.circle.entity.TblCircleTopic;
import com.x2yu.circle.service.ITblBookInfoService;
import com.x2yu.circle.service.ITblCircleTopicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CircleApiApplicationTests {

    @Autowired
    ITblBookInfoService bookInfoService;

    @Autowired
    ITblCircleTopicService circleTopicService;
    @Test
    void contextLoads() {

    }

}
