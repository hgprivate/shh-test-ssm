package cn.shh.test.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emp implements Serializable {
    private Integer eId;
    private String eName;
    private Integer eAge;
    private String eGender;
    private Dept dept;
}
