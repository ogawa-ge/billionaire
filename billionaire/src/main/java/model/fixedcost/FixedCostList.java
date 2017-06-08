package model.fixedcost;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FixedCostList implements Serializable{
	private List<FixedCost> fixedCostList;

	public FixedCostList(List<FixedCost> fixedCostList){
		this.fixedCostList = fixedCostList;
	}
	public FixedCostList(){
		fixedCostList = new ArrayList<FixedCost>();
	}

	public List<FixedCost> fixedCostList(){
		return fixedCostList;
	}
	@Deprecated
	public List<FixedCost> getFixedCostList(){
		return fixedCostList;
	}

	@Override
	public String toString() {
		return String.format("FixedCostList [fixedCostList=%s]", fixedCostList);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 871239857175364998L;

}
