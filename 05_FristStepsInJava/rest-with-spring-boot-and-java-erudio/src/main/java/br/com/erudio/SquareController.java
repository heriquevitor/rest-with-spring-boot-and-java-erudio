package br.com.erudio;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
@RestController

public class SquareController {

	private final AtomicLong counter= new AtomicLong();
	@RequestMapping(value= "/square/{number}",method=RequestMethod.GET)
	public Double square(@PathVariable(value="number")String number)
			throws Exception{
		if(!isNumeric(number)){
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
			return Math.sqrt(convertToDouble(number));

		}
		private Double convertToDouble(String strNumber) {
			if(strNumber == null) return 0D;
			String number = strNumber.replaceAll(",", ".");
			if(isNumeric(number)) return Double.parseDouble(number);
			return 0D;
		}
		private boolean isNumeric(String strNumber) {
			if(strNumber == null)return false;
			String number = strNumber.replaceAll(",", ".");
			return number.matches("[-+]?[0-9]*\\.?[0-9]+");
		}}
