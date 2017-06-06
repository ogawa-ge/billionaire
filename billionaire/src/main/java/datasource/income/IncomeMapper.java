package datasource.income;

import org.apache.ibatis.annotations.Param;

import model.income.Income;
import model.user.UserId;

public interface IncomeMapper {
	public void regiser(@Param("income") Income income, @Param("userId") UserId userId);
}
