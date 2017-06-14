package datasource.fixedcost;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.fixedcost.FixedCost;
import model.user.UserId;

public interface FixedCostMapper {
	public List<FixedCost> listOf(@Param("userId") UserId userId);
	public void register(@Param("fixedCost") FixedCost fixedCost, @Param("userId") UserId userId);
	public FixedCost findBy(@Param("fixedCostId") Integer fixedCostId);
	public void modify(@Param("fixedCost") FixedCost fixedCost);
	public void delete(@Param("fixedCostId") Integer fixedCostId);
	public Integer findTotal(@Param("userId") UserId userId);
}
