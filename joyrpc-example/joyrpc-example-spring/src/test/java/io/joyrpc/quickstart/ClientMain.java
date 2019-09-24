package io.joyrpc.quickstart;

/*-
 * #%L
 * joyrpc
 * %%
 * Copyright (C) 2019 joyrpc.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import io.joyrpc.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Quick Start client
 */
public class ClientMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientMain.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/joyrpc-consumer.xml");
        DemoService service = (DemoService) appContext.getBean("demoService");

        try {
            String result = service.sayHello("hello");
            LOGGER.info("response msg from server :{}", result);
        } catch (Exception e) {
        }

        System.in.read();//终端输入任意字符，shutdown进程
    }
}
