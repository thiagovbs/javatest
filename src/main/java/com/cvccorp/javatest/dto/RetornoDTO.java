package com.cvccorp.javatest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RetornoDTO<T, E> {
    private T objeto;
    private E erro;
}
