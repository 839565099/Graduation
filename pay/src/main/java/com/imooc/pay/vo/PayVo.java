package com.imooc.pay.vo;

import lombok.Data;

/**
 * 作者：张翼麒
 * Date:2020-2-24
 */
@Data
public class PayVo {
    private String codeUrl;
    private String orderId;
    private String returnUrl;
    private String body;

    public PayVo() {
    }

    public PayVo(String codeUrl, String orderId, String returnUrl) {
        this.codeUrl = codeUrl;
        this.orderId = orderId;
        this.returnUrl = returnUrl;
    }
}
