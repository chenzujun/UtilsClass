package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @Data 包含重新equals和hashCode
 *
 * @author chenjun
 * @date 2019/5/23
 * @since V1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    private String name;

    @Override
    public boolean equals(Object obj){
        if(obj!=null && obj.getClass()==this.getClass()){
            Animal a = (Animal)obj;
            if(a.getName() == null || name==null){
                return false;
            }else {
                return name.equalsIgnoreCase(a.getName());
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder().append(name).toHashCode();
    }
}
