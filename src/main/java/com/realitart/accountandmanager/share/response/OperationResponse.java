package com.realitart.accountandmanager.share.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OperationResponse {
    private boolean status;
    private String message;

}
