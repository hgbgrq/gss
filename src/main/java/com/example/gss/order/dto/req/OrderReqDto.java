package com.example.gss.order.dto.req;

import lombok.Data;

@Data
public class OrderReqDto {

    private String keyword;

    private String keywordType;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeywordType() {
        return keywordType;
    }

    public void setKeywordType(String keywordType) {
        this.keywordType = keywordType;
    }
}
