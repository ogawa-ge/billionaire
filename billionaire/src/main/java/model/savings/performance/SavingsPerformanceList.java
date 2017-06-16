package model.savings.performance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SavingsPerformanceList implements Serializable{
	private List<SavingsPerformance> savingsPerformanceList;

	public SavingsPerformanceList(List<SavingsPerformance> savingsPerformanceList){
		this.savingsPerformanceList = savingsPerformanceList;
	}
	public SavingsPerformanceList(){
		savingsPerformanceList = new ArrayList<SavingsPerformance>();
	}

	@Deprecated
	public void setSavingsPerformanceList(List<SavingsPerformance> savingsPerformanceList){
		this.savingsPerformanceList = savingsPerformanceList;
	}
	@Deprecated
	public List<SavingsPerformance> getSavingsPerformanceList(){
		return savingsPerformanceList;
	}

	@Override
	public String toString() {
		return String.format("SavingsPerformanceList [savingsPerformanceList=%s]", savingsPerformanceList);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -8390109845418824630L;
}
