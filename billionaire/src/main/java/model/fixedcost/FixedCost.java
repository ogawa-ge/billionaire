package model.fixedcost;

import java.io.Serializable;

import javax.validation.Valid;

public class FixedCost implements Serializable{
	@Valid
	private FixedCostAmount fixedCostAmount;
	private FixedCostId fixedCostId;
	@Valid
	private FixedCostName fixedCostName;

	public FixedCost(FixedCostAmount fixedCostAmount, FixedCostId fixedCostId, FixedCostName fixedCostName){
		this.fixedCostAmount = fixedCostAmount;
		this.fixedCostId = fixedCostId;
		this.fixedCostName = fixedCostName;
	}
	public FixedCost(){
		fixedCostAmount = new FixedCostAmount();
		fixedCostId = new FixedCostId();
		fixedCostName = new FixedCostName();
	}


	public FixedCostId fixedCostId(){
		return fixedCostId;
	}
	@Deprecated
	public FixedCostAmount getFixedCostAmount(){
		return fixedCostAmount;
	}
	@Deprecated
	public FixedCostId getFixedCostId(){
		return fixedCostId;
	}
	@Deprecated
	public FixedCostName getFixedCostName(){
		return fixedCostName;
	}

	@Override
	public String toString() {
		return String.format("FixedCost [fixedCostAmount=%s, fixedCostId=%s, fixedCostName=%s]", fixedCostAmount,
				fixedCostId, fixedCostName);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -735295555550939287L;

}
