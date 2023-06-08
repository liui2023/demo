package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author LiuYi
 * @Date 2023/5/26  17:33
 * @Desc 又是充满希望的一天
 */
@Data
@Builder
public class Dto implements Serializable{

    private String str;
    private String str1;
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dto dto = (Dto) o;
        return Objects.equals(str, dto.str) && Objects.equals(str1, dto.str1) && Objects.equals(id, dto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str, str1, id);
    }
}
