package datasource.income;

import org.apache.ibatis.annotations.Param;

import model.income.Income;
import model.user.UserId;

public interface IncomeMapper {
	public void register(@Param("income") Income income, @Param("userId") UserId userId);
	public Income findBy(@Param("userId") UserId userId);
	public Integer findAmount(@Param("userId") UserId userId);
}
