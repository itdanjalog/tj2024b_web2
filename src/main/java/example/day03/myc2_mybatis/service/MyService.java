package example.day03.myc2_mybatis.service;

import example.day03.myc2_mybatis.model.mapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService { @Autowired private MyMapper myMapper; }
