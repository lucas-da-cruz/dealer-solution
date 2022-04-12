package com.exercise.dealersolution.business.model.enumDomain;

import lombok.Getter;

@Getter
public enum StatusProduto {

    OUTDATED(0), TRANSPORT(1), AVAILABLE(2);

    private final Integer status;

    StatusProduto(Integer status){
        this.status = status;
    }

}
