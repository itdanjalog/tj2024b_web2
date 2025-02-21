package example.day03.myc2_mybatis.controller;

import example.day03.myc2_mybatis.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController { @Autowired private MyService myService; }
