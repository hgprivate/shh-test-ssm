package cn.shh.test.ssm.mapper;

import cn.shh.test.ssm.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashSet;
import java.util.List;

@Mapper
public interface DeptMapper {
    public void insert(Dept dept);
    Dept getDeptById(@Param("dId") int dId);
    public List<Dept> getAllDept();
    public int updateById(Dept dept);
    public int deleteById(@Param("id") int id);
    public int deleteByIds(@Param("ids") String ids);
    public int deleteByIds2(@Param("ids") HashSet<Integer> ids);
    List<Dept> getByLike(@Param("mohu") String mohu);
}
