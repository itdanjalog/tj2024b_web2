package example.day11._스프링스케줄링과제;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TaskMapper {

    @Update( "UPDATE day11products SET stock_quantity = stock_quantity - 3" )
    public boolean task1();

    @Select( "SELECT * FROM day11products" )
    public List< HashMap<String, String> >task2( List<HashMap< String, String >> pList );

    @Insert( "UPDATE day11products " +
            "SET stock_quantity = stock_quantity + 20 " +
            "WHERE stock_quantity <= 10" )
    public boolean task3();

}