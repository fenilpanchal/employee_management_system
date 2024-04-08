package com.stevenhornghub.promotionrequest.models;
import lombok.Data;
@Data
public class UserSearchRequest {

    private String searchKey ;
    private String searchValue;
    private String sortBy;
    private int offset;
    private int limit;

}
