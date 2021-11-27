package com.cp.compiler.utilities;

import com.cp.compiler.models.Verdict;

public class StatusUtil {
	
	private StatusUtil() {
	}
	
	/**
	 *
	 * @param status an integer that represents the status returned by the docker container
	 * @param ans if the status code is 0, then this boolean must be equal to true or false to specify if Response is Accepted, or it's a Wrong answer
	 * @return return a String representing the status response
	 */
	public static String statusResponse(int status, boolean ans) {
		
		// the status is taken from the return code of the container
		switch (status) {
			
			// The code compile and the execution finish before the time limit, and the memory does not exceed the limit
			case 0:
				// Is it the excepted output ?
				if (ans)
					return Verdict.ACCEPTED.getVerdict();
				else
					return Verdict.WRONG_ANSWER.getVerdict();
			
			case 2: return Verdict.COMPILATION_ERROR.getVerdict();
			
			case 139: return Verdict.OUT_OF_MEMORY.getVerdict();
			
			case 124: return Verdict.TIME_LIMIT_EXCEEDED.getVerdict();
			
			default: return Verdict.RUNTIME_ERROR.getVerdict();
		}
	}
}