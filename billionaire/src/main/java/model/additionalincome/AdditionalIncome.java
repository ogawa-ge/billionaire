package model.additionalincome;

import java.io.Serializable;

public class AdditionalIncome implements Serializable{
	private AdditionalIncomeAddDate additionalIncomeAddDate;
	private AdditionalIncomeAmount additionalIncomeAmount;
	private AdditionalIncomeId additionalIncomeId;
	private AdditionalIncomeName additionalIncomeName;

	public AdditionalIncome(AdditionalIncomeAddDate additionalIncomeAddDate, AdditionalIncomeAmount additionalIncomeAmount, AdditionalIncomeId additionalIncomeId, AdditionalIncomeName additionalIncomeName){
		this.additionalIncomeAddDate = additionalIncomeAddDate;
		this.additionalIncomeAmount = additionalIncomeAmount;
		this.additionalIncomeId = additionalIncomeId;
		this.additionalIncomeName = additionalIncomeName;
	}
	public AdditionalIncome(){
		additionalIncomeAddDate = new AdditionalIncomeAddDate();
		additionalIncomeAmount = new AdditionalIncomeAmount();
		additionalIncomeId = new AdditionalIncomeId();
		additionalIncomeName = new AdditionalIncomeName();
	}

	@Deprecated
	public AdditionalIncomeAddDate getAdditionalIncomeAddDate(){
		return additionalIncomeAddDate;
	}
	@Deprecated
	public AdditionalIncomeAmount getAdditionalIncomeAmount(){
		return additionalIncomeAmount;
	}
	@Deprecated
	public AdditionalIncomeId getAdditionalIncomeId(){
		return additionalIncomeId;
	}
	@Deprecated
	public AdditionalIncomeName getAdditionalIncomeName(){
		return additionalIncomeName;
	}

	@Override
	public String toString() {
		return String.format(
				"AdditionalIncome [additionalIncomeAddDate=%s, additionalIncomeAmount=%s, additionalIncomeId=%s, additionalIncomeName=%s]",
				additionalIncomeAddDate, additionalIncomeAmount, additionalIncomeId, additionalIncomeName);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -496069857284349719L;

}
