/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.oristartech.dubbo.consumer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oristartech.dubbo.consumer.servicePro.TestDubbo;

@RestController
@RequestMapping("/test")
public class DemoAction {

   /* @Reference
    private IDemoService demoService;*/

    @Autowired
    private TestDubbo testDubbo;

    @RequestMapping(value = "/dubboPost",method = RequestMethod.POST)
    public String setDemoService(@RequestParam("str") String str) {
        //System.out.println(demoService.sayHello("hello"));
        //this.dubboService = demoService;
        return testDubbo.testDubbo(str);
    }
    
    @RequestMapping(value = "/dubboGet",method = RequestMethod.GET)
    public String setDemoServiceGet(@RequestParam("str") String str) {
        //System.out.println(demoService.sayHello("hello"));
        //this.dubboService = demoService;
        return testDubbo.testDubbo(str);
    }
    
   /* public void start() throws Exception {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            try {
                String hello = dubboService.sayHello("world" + i);
                System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + hello);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
        }
    }*/

}