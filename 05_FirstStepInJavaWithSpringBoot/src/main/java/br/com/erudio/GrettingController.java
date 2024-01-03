package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrettingController {
	
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/gretting")
	public Gretting gretting (@RequestParam(value = "name",
			defaultValue = "Word") String name) {
		
		return new Gretting(counter.incrementAndGet(), String.format(template, name));
	}
}
