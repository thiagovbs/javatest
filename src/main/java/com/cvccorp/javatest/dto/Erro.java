package com.cvccorp.javatest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class Erro implements Serializable {

    private static final long serialVersionUID = -7781657048788205780L;
    private String mensagem;
}
