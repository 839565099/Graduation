package com.imooc.pay.controller;

import com.imooc.pay.dao.ResponseVo;
import com.imooc.pay.pojo.PayInfo;
import com.imooc.pay.service.impl.PayServiceImpl;
import com.imooc.pay.vo.PayVo;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyiqi
 */
@Controller
//@RequestMapping("/pay")
@CrossOrigin(origins = "*",allowCredentials = "true")
@Slf4j
public class PayController {

	@Autowired
	private PayServiceImpl payService;

	@Autowired
	private WxPayConfig wxPayConfig;

	@GetMapping("/pay")
	@ResponseBody
	public ResponseVo<PayVo> create(@RequestParam("orderId") String orderId,
									@RequestParam("amount") BigDecimal amount,
									@RequestParam("payType") BestPayTypeEnum bestPayTypeEnum
							   ) {
		PayResponse response = payService.create(orderId, amount, bestPayTypeEnum);

		//支付方式不同，渲染就不同, WXPAY_NATIVE使用codeUrl,  ALIPAY_PC使用body
		if (bestPayTypeEnum == BestPayTypeEnum.WXPAY_NATIVE) {
			PayVo payVo=new PayVo(response.getCodeUrl(),orderId,wxPayConfig.getReturnUrl());
			return ResponseVo.success(payVo);
		}else if (bestPayTypeEnum == BestPayTypeEnum.ALIPAY_PC) {

			PayVo payVo = new PayVo();
			payVo.setBody(response.getBody());
			return  ResponseVo.success(payVo);
		}
		throw new RuntimeException("暂不支持的支付类型");
	}

	@PostMapping("/notify")
	@ResponseBody
	public String asyncNotify(@RequestBody String notifyData) {
		return payService.asyncNotify(notifyData);
	}

	@GetMapping("/queryByOrderId")
	@ResponseBody
	public PayInfo queryByOrderId(@RequestParam String orderId) {
		log.info("查询支付记录...");
		return payService.queryByOrderId(orderId);
	}
}
