
/**
 * @author ancel litto
 */
package com.ancel.microservice.forex.currencyconversion;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Fiegn is used to communicated with the other microservice this is much easier than using the rest
 * template Enabled Ribbon Client to load balance the different instances of the forex-service
 * 
 * @author Ancel Litto
 *
 */
@FeignClient(name = "forex-service")
@RibbonClient(name = "forex-service")
public interface CurrencyExchangeServiceProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retriveExchangeValue(@PathVariable String from, @PathVariable String to);
}
