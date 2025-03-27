package example.day13;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TranMapper {

    // (1)
    @Insert("insert into day13users( name ) values( #{name} )")
    public boolean tran(String name);

    // (2) 출금 , 빼기
    @Update(" update day13users " +
            " set money = money - #{ money } " +
            " where name = #{ name }")
    public boolean withdraw( String name , int money);

    // (2) 입금 , 더하기
    @Update(" update day13users " +
            " set money = money + #{ money } " +
            " where name = #{ name } ")
    public boolean deposit( String name , int money);

}
