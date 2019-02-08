/**
 * A rest controller which accepts the queries and calls the other microservice which are load balanced through ribbon 
 * @author ancel
 */
package com.ancel.microservice.forex.currencyconversion;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	/**
	 * requests are routed through this method
	 * 
	 * @param from
	 *            the Currency Code of the Source
	 * @param to
	 *            the Currency Code of the Destination
	 * @return
	 */
	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		CurrencyConversionBean response = proxy.retriveExchangeValue(from, to);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
}
