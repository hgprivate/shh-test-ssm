package cn.shh.test.ssm.mapper;

import cn.shh.test.ssm.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashSet;
import java.util.List;

@Mapper
public interface EmpMapper {
    public void insert(Emp emp);
    public Emp getEmpById(@Param("eId") int eId);
    public List<Emp> getAllEmp();
    public int updateById(Emp emp);
    public int deleteById(@Param("eId") int eId);
    public int deleteByIds(@Param("eIds") String eIds);
    public int deleteByIds2(@Param("eIds") HashSet<Integer> eIds);
    List<Emp> getByLike(@Param("mohu") String mohu);
}