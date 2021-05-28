package hrms.hrms.core.utilities.business;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;

public class BusinessRules {

	public static Result run(Result... results) {
		for(Result result : results) {
			if(!result.isSuccess()) {
				return result;
			}
		}
		
		return new SuccessResult();
	}
}
