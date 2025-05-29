package com.ygt.dashboard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import com.ygt.dashboard.config.TestMailConfig;

@SpringBootTest
@Import(TestMailConfig.class)
class DashboardApplicationTest {

	@Test
	void contextLoads() {
	}

}
